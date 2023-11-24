package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.form.MessageForm;

@Mapper
public interface GoodReplyMapper {
	public int insert(MessageForm messageForm);
}
