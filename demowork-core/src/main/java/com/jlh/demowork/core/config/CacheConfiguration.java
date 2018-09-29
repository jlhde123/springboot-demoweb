package com.jlh.demowork.core.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.jlh.demowork.core.utils.FastJson2JsonRedisSerializer;
import com.jlh.demowork.core.utils.RedisManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao@yixin.im
 * Date: 2018-09-28 17:25
 * Description:
 */
@Repository
@Configuration
public class CacheConfiguration {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new FastJson2JsonRedisSerializer<Object>(Object.class));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


    @Bean
    public RedisManager redisManager(RedisTemplate redisTemplate){
        return new RedisManager(redisTemplate);
    }
}
