package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Fortune;

@Mapper
public interface FortuneMapper {

    public List<Fortune> findAll();

}