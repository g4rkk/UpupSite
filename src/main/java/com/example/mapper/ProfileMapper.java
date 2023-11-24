package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Profile;
// import org.apache.ibatis.annotations.Select; // 确保没有使用此类注解

@Mapper
public interface ProfileMapper {
    Profile getUserProfileById(Integer id);
}
