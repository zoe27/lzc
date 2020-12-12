package cn.com.pro.service;

import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 *
 * @title: JRedisService
 * @projectName pro
 * @description: TODO
 * @User: zhoubin
 * @Date: 2020-11-14 16:18
 */
public interface JRedisService {

    Jedis getClient();
    
    // push数据
    void lpush(String key, Object value);
    
    // pop 数据
    Object pop(String key);
}
