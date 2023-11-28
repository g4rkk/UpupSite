package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.form.DeleteForm;
import com.example.form.MessageForm;

@Mapper
public interface BadReplyMapper {
	public int insert(MessageForm messageForm);
	public int softDelete(DeleteForm deleteForm);
	public int cascadeReplySoftDelete(DeleteForm deleteForm);
}
