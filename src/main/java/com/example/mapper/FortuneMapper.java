package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.model.Fortune;

@Mapper
public interface FortuneMapper {
    @Select("SELECT * FROM fortune WHERE id = #{id}")
    Fortune selectFortuneById(Long id);

    // 可以根据需要添加更多方法
}