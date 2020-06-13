package com.lagou.router;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.dubbo.common.utils.CollectionUtils;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadyRestartInstances  implements PathChildrenCacheListener {
    private  static  final Logger  LOGGER  = LoggerFactory.getLogger( ReadyRestartInstances.class);
    private  static  final  String LISTEN_PATHS = "/lagou/dubbo/restart/instances";

    private   final   CuratorFramework  zkClient;
    // 当节点变化时 给这个集合赋值 重启机器的信息列表
    private volatile Set<String>  restartInstances = new HashSet<>();

    private  ReadyRestartInstances(CuratorFramework zkClient) {
        this.zkClient = zkClient;
    }
    public static  ReadyRestartInstances  create(){
        final   CuratorFramework  zookeeperClient = ZookeeperClients.client();
        try {
            // 检查监听路径是否存在
            final Stat stat =  zookeeperClient.checkExists().forPath(LISTEN_PATHS);
            // 如果监听路径不存在 则创建
            if (stat == null){
                zookeeperClient.create().creatingParentsIfNeeded().forPath(LISTEN_PATHS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("确保基础路径存在");
        }
        final   ReadyRestartInstances  instances = new ReadyRestartInstances(zookeeperClient);
        // 创建一个NodeCache
        PathChildrenCache  nodeCache = new PathChildrenCache(zookeeperClient,LISTEN_PATHS,false);
        // 给节点缓存对象 加入监听
        nodeCache.getListenable().addListener(instances);
        try {
            nodeCache.start();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("启动路径监听失败");
        }
        return instances;
    }
    /** 返回应用名  和  主机拼接后的字符串 */
    private  String   buildApplicationAndInstanceString(String  applicationName,String host){
        return  applicationName + "_" + host;
    }
    /** 增加重启实例的配置信息方法 */
    public void  addRestartingInstance(String applicationName,String host) throws  Exception{
         zkClient.create().creatingParentsIfNeeded().forPath(LISTEN_PATHS + "/" + buildApplicationAndInstanceString(applicationName,host));
    }
    /** 删除重启实例的配置信息方法 */
    public void removeRestartingInstance(String applicationName,String host) throws  Exception{
        zkClient.delete().forPath(LISTEN_PATHS + "/" + buildApplicationAndInstanceString(applicationName,host));
    }
    /** 判断节点信息 是否存在于 restartInstances */
    public  boolean  hasRestartingInstance(String applicationName,String host){
        return  restartInstances.contains(buildApplicationAndInstanceString(applicationName,host));
    }
    @Override
    public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
          // 查询出监听路径下 所有的目录配置信息
        final List<String>  restartingInstances = zkClient.getChildren().forPath(LISTEN_PATHS);
        // 给 restartInstances
        if(CollectionUtils.isEmpty(restartingInstances)){
            this.restartInstances = Collections.emptySet();
        }else{
            this.restartInstances = new HashSet<>(restartingInstances);
        }
    }
}
