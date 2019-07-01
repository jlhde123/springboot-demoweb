package com.jlh.demoworkweb.controller;

import com.github.pagehelper.PageInfo;
import com.jlh.demowork.core.exceptions.UnAuthorizedException;
import com.jlh.demowork.core.http.PageRequestDTO;
import com.jlh.demoworkweb.mapper.UserMapper;
import com.jlh.demoworkweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 11:26
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public PageInfo<User> getUser(){
//        return PageHelper.startPage(PageRequestDTO.builder()
//                .pageNum(1)
//                .pageSize(10)
//        ).doSelectPageInfo(()->userMapper.findAll());
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        return null;
    }

    @GetMapping("/unauth")
    public String getUnauth(){
        throw new UnAuthorizedException("msg")
                .withDeveloperMsg("developer");
    }

}
