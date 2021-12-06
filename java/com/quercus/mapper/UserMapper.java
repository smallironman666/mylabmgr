package com.quercus.mapper;

import com.quercus.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //    查询单个用户的信息  参数：用户名  密码  返回值：user
    @Select("select * from user where uname=#{param1} and pwd=#{param2}")
    User selectOne(String uname, String pwd);
}
