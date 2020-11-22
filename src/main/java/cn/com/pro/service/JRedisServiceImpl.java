package cn.com.pro.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 *
 * @title: JRedisServiceImpl
 * @projectName pro
 * @description: TODO
 * @User: zhoubin
 * @Date: 2020-11-14 16:18
 */
@Component
public class JRedisServiceImpl implements JRedisService {

    @Value("${redis.ip}")
    private String ip;

    @Value("${redis.port}")
    private String port;

    @Value("${redis.pass}")
    private String pass;

    private static JedisPool pool = null;

    Jedis jedis = null;

    @PostConstruct
    public void setJedis(){
        Jedis jedis = new Jedis(ip, Integer.valueOf(port));
        jedis.auth(pass);
        this.jedis = jedis;
    }


    @Override
    public Jedis getClient() {
        return jedis;
    }

    public static JedisPool getPool() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(500);
            config.setMaxIdle(5);
            config.setMaxWaitMillis(1000*10);
            pool = new JedisPool(config, "127.0.0.1", 6379, 10000,"123456");

        }
        return pool;
    }

    public synchronized static Jedis getResource() {
        if (pool == null) {
            pool = getPool();
        }
        return pool.getResource();
    }

    public static void main(String[] args){
        System.out.println(JRedisServiceImpl.getResource().set("1", "test"));
        System.out.println(JRedisServiceImpl.getResource().get("1"));
    }

}
