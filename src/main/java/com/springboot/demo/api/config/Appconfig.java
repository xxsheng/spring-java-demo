package com.springboot.demo.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.demo.api.domain.User;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource("classpath:redis.properties")
@Slf4j
@EnableConfigurationProperties(XxqProperties.class)
public class Appconfig {

//    @Bean
//    public User user() {
//        return new User();
//    }

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

//    @Value("${spring.redis.password}")
//    private String password;

    @Value("${spring.redis.block-when-exhausted}")
    private boolean blockWhenExhausted;

    @Bean
    public JedisPool redisPoolFactory() {
        log.info("JedisPoll注入成功");
        log.info("redis地址----主机ip：{}----端口port：{}", host, port);
        JedisPoolConfig jedisPoolConfig =  new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        jedisPoolConfig.setJmxEnabled(true);


        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null, 10);
        return  jedisPool;
    }

//    @Bean
//    public Filter filter() {
//        return new Filter();
//    }
}
