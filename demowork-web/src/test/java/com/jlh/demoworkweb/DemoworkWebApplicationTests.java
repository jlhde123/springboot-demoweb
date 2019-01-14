package com.jlh.demoworkweb;

import java.time.LocalDateTime;

import com.alibaba.fastjson.JSON;
import com.jlh.demowork.core.utils.RedisManager;
import com.jlh.demoworkweb.mapper.UserMapper;
import com.jlh.demoworkweb.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoworkWebApplicationTests {

    @Autowired
    private RedisManager redisManager;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        System.out.println(JSON.toJSONString(userMapper.getById(2L)));

        User user = new User();
        user.setUsername("jlh4");
        user.setCreateTime(LocalDateTime.now());
        user.setState(1);
        userMapper.insert(user);

        System.out.println(user.getId());
//        System.out.println(userMapper.find(new User()));
//        List<User> users= redisManager.getIfNullSet("key6",()-> userMapper.findAll());
//
//        users.forEach(m->{
//            System.out.println(m.getCreateTime());
//            System.out.println(m.getId());
//        });
//
//
//        List<List<User>> users1 = redisManager.mget(Arrays.asList("key4","key5","key5"));
//
//        users1.stream().flatMap(Collection::stream).forEach(m->{
//            System.out.println(m.getCreateTime());
//            System.out.println(m.getId());
//        });
    }



}
