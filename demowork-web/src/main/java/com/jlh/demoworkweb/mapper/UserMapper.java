package com.jlh.demoworkweb.mapper;

import java.util.List;

import com.jlh.demoworkweb.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2018-09-28 15:31
 * Description:
 */
@Repository
public interface UserMapper extends BaseMapper<User> {


    @Select("select * from user where #{id}")
    List<User> getById(@Param("id") Long id);
}
