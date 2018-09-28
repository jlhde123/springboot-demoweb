package com.jlh.demoworkweb.mapper;

import com.jlh.demoworkweb.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 15:31
 * Description:
 */
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();
}
