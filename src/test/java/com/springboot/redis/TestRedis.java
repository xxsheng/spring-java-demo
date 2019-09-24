package com.springboot.redis;

import com.springboot.SpringJavaDemoApplication;
import com.springboot.demo.SpringJavaDemoApplicationTests;
import com.springboot.demo.api.config.XxqProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.time.Instant;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringJavaDemoApplication.class})
public class TestRedis {
    @Autowired
     JedisPool jedisPool;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisProperties redisProperties;

    @Autowired
    XxqProperties xxqProperties;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Test
    public void test() {
        System.out.println(jedisPool);
//        Jedis resource = jedisPool.getResource();
        System.out.println(jedisPool.getResource().hget("user:1","age"));
    }

    @Test
    public void init() {
        Jedis jedis = jedisPool.getResource();

        Map<String,String> map1 = new HashMap<>();
        map1.put("orderId", "1");
        map1.put("money", "36.6");
        map1.put("time", "2018-01-01");

        Map<String,String> map2 = new HashMap<>();
        map2.put("orderId", "2");
        map2.put("money", "38.6");
        map2.put("time", "2018-01-01");

        Map<String,String> map3 = new HashMap<>();
        map3.put("orderId", "3");
        map3.put("money", "39.6");
        map3.put("time", "2018-01-01");

        jedis.hmset("order:1",map1);
        jedis.hmset("order:2",map2);
        jedis.hmset("order:3",map3);

    }

    @Test
    public void testOrder() {

        Jedis jedis = jedisPool.getResource();

        System.out.println(jedis.lpush("user:1:order", new String[]{"order:1", "order:2", "order:3"}));
    }

    @Test
    public void step3() {
        Jedis jedis = jedisPool.getResource();
//        Map<String,String> map = new HashMap<>();
//        map.put("orderId", "4");
//        map.put("money", "40.6");
//        map.put("time", "2018-01-01");

        Map<String,String> map = new HashMap<>();
        map.put("orderId", "5");
        map.put("money", "40.6");
        map.put("time", "2018-01-01");

        redisTemplate.opsForHash().putAll("order:5", map);

//        System.out.println(jedis.hmset("order:5", map));
    }

    @Test
    public void step4() {
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.lpush("user:2:order", "{\n" +
                "  \"id\" : 1,\n" +
                "  \"message\" : \"Hello World\",\n" +
                "  \"sendTime\" : 1569346703633,\n" +
                "  \"intList\" : null,\n" +
                "  \"nodeName\" : null\n" +
                "}"));
    }

    @Test
    public void step5() {
        List<String> range = redisTemplate.opsForList().range("user:2:order", 1, -1);
        System.out.println();
        System.out.println(redisTemplate.opsForHash().entries("order:1"));

        Jedis jedis = jedisPool.getResource();

        List<String> list = jedis.lrange("user:1:order", 1, -1);

        for (String key : list) {
            System.out.println(jedis.hgetAll(key));
        }

    }

    @Test
    public void test6() {
        List<String> range = redisTemplate.opsForList().range("user:2:order", 0, -1);
        System.out.println("--------------");
        System.out.println(range);
//        redisTemplate.opsForList().leftPushAll("user:3:order", Arrays.asList(1L,2L,3L));
//        redisTemplate.opsForList().leftPushAll("user:3:order", Arrays.asList("order:1","order:2","order:3"));
    }

    @Test
    public void test7() {
        List<Order> list = new ArrayList<>();
        Order order1 = Order.builder().orderId(1L).createdTime(Instant.now()).name("name1").price(1.1).build();
        Order order2 = Order.builder().orderId(2L).createdTime(Instant.now()).name("name2").price(1.2).build();
        Order order3 = Order.builder().orderId(3L).createdTime(Instant.now()).name("name3").price(1.3).build();
        Order order4 = Order.builder().orderId(4L).createdTime(Instant.now()).name("name4").price(1.4).build();

        list.add(order1);
        list.add(order2);
        list.add(order3);
        list.add(order4);

        redisTemplate.opsForList().leftPushAll("user:4:order", list);

    }

    @Test
    public void test8() {
        redisTemplate.opsForList().leftPush("test:1", "test3", "test1");
    }
}
