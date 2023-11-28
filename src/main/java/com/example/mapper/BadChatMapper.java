package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.BadChat;
import com.example.form.DeleteForm;
import com.example.form.MessageForm;

@Mapper
public interface BadChatMapper {
	public List<BadChat> findAll();
	public int insert(MessageForm messageForm);
	public int softDelete(DeleteForm deleteForm);
}
