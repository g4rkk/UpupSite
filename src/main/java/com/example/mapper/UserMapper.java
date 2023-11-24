package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.User;

@Mapper
public interface UserMapper {
    User findByEmail(@Param("email") String email);
    
    void updateFortune(User user);
}
