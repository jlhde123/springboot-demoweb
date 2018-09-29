package com.jlh.demoworkweb;

import com.jlh.demowork.core.utils.RedisManager;
import com.jlh.demoworkweb.mapper.UserMapper;
import com.jlh.demoworkweb.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoworkWebApplicationTests {

    @Autowired
    private RedisManager redisManager;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        List<User> users= redisManager.getIfNullSet("key5",()-> userMapper.findAll());

        System.out.println(users);


        List<List<User>> users1 = redisManager.mget(Arrays.asList("key4","key5"));

        System.out.println(users1);
    }



}
