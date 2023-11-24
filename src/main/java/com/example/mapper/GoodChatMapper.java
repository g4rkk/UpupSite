package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.GoodChat;

@Mapper
public interface GoodChatMapper {
	public List<GoodChat> findAll();
}

