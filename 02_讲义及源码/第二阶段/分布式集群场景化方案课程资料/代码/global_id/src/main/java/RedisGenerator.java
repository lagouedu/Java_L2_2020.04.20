import redis.clients.jedis.Jedis;

public class RedisGenerator {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("111.229.248.243",6379);
        Long id = jedis.incr("id");//<id,0>
        System.out.println(id);
    }
}
