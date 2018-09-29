package com.jlh.demowork.core.utils;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao@yixin.im
 * Date: 2018-09-28 16:21
 * Description: redis缓存管理
 */
public class RedisManager {

    private RedisTemplate redisTemplate;

    public RedisManager(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <T> T getIfNullSet(String key, CallbackFunction<T> callbackFunction){
        T t= (T) redisTemplate.opsForValue().get(key);
        if (t == null){
            t = callbackFunction.call();
            redisTemplate.opsForValue().set(key,t);
        }
        return t;
    }

    public <T> T get(String key){
        return (T) redisTemplate.opsForValue().get(key);
    }

    public <T> List<T> mget(List<String> keys){
        return redisTemplate.opsForValue().multiGet(keys);
    }

    public void set(String key,Object val){
        redisTemplate.opsForValue().set(key,val);
    }

    public void set(String key,Object val,long timeout){
        redisTemplate.opsForValue().set(key,val,timeout, TimeUnit.MICROSECONDS);
    }

    public boolean delete(String key){
        return redisTemplate.delete(key);
    }

    public boolean expire(String key,long timeout){
        return redisTemplate.expire(key,timeout,TimeUnit.MICROSECONDS);
    }

    public Long ttl(String key){
        return redisTemplate.getExpire(key,TimeUnit.MICROSECONDS);
    }

}
