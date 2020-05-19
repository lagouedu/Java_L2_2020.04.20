package elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.util.List;
import java.util.Map;

/**
 * ElasticJobLite定时任务业务逻辑处理类
 */
public class ArchivieJob implements SimpleJob {

    /**
     * 需求：resume表中未归档的数据归档到resume_bak表中，每次归档1条记录
     * execute方法中写我们的业务逻辑（execute方法每次定时任务执行都会执行一次）
     * @param shardingContext
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        int shardingItem = shardingContext.getShardingItem();
        System.out.println("=====>>>>当前分片：" + shardingItem);

        // 获取分片参数
        String shardingParameter = shardingContext.getShardingParameter(); // 0=bachelor,1=master,2=doctor


        // 1 从resume表中查询出1条记录（未归档）
        String selectSql = "select * from resume where state='未归档' and education='"+ shardingParameter +"' limit 1";
        List<Map<String, Object>> list = JdbcUtil.executeQuery(selectSql);
        if(list == null || list.size() ==0 ) {
            System.out.println("数据已经处理完毕！！！！！！");
            return;
        }
        // 2 "未归档"更改为"已归档"
        Map<String, Object> stringObjectMap = list.get(0);
        long id = (long) stringObjectMap.get("id");
        String name = (String) stringObjectMap.get("name");
        String education = (String) stringObjectMap.get("education");

        System.out.println("=======>>>>id：" + id + "  name：" + name + " education：" + education);

        String updateSql = "update resume set state='已归档' where id=?";
        JdbcUtil.executeUpdate(updateSql,id);

        // 3 归档这条记录，把这条记录插入到resume_bak表
        String insertSql = "insert into resume_bak select * from resume where id=?";
        JdbcUtil.executeUpdate(insertSql,id);
    }
}
