package com.springboot.redis;

import com.springboot.SpringJavaDemoApplication;
import com.springboot.demo.SpringJavaDemoApplicationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringJavaDemoApplication.class})
public class TestRedis {
    @Autowired
     JedisPool jedisPool;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisProperties redisProperties;

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
        System.out.println(jedis.lpush("user:1:order", "order4"));
    }

    @Test
    public void step5() {
        System.out.println(redisTemplate.opsForList().range("user:1:order", 1, -1));
        System.out.println(redisTemplate.opsForHash().entries("order:1"));

        Jedis jedis = jedisPool.getResource();

        List<String> list = jedis.lrange("user:1:order", 1, -1);

        for (String key : list) {
            System.out.println(jedis.hgetAll(key));
        }

    }
}
