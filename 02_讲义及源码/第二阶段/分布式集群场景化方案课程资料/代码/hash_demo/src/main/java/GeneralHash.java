/**
 * 普通Hash算法实现
 */
public class GeneralHash {

    public static void main(String[] args) {
        // 定义客户端IP
        String[] clients = new String[]{"10.78.12.3","113.25.63.1","126.12.3.8"};

        // 定义服务器数量
        int serverCount = 5;// (编号对应0，1，2)

        // hash(ip)%node_counts=index
        //根据index锁定应该路由到的tomcat服务器
        for(String client: clients) {
            int hash = Math.abs(client.hashCode());
            int index = hash%serverCount;
            System.out.println("客户端：" + client + " 被路由到服务器编号为：" + index);

        }
    }
}
