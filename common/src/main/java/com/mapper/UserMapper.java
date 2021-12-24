package com.mapper;


import com.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    public List<User> getAllUser();

    @Select("select * from user where id=#{id}")
    public User getOneUser(Long id);

    @Select("select * from user where name=#{name}")
    public User getOneUser(String username);

    @Delete("delete from user where id=#{id}")
    public Integer deleteUserById(Long id);

    @Update("update user set username=#{username},age=#{age},port=#{port} where id=#{id}")
    public Integer updateUserById(User user);
}
