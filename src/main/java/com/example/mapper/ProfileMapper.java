package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.Profile;
// import org.apache.ibatis.annotations.Select; // 确保没有使用此类注解

@Mapper
public interface ProfileMapper {
    Profile getUserProfileById(Integer id);

    void updateGoodBadCount(
            @Param("id") Integer id, 
            @Param("goodCount") Integer goodCount, 
            @Param("badCount") Integer badCount);
}

