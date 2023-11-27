package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.form.DeleteForm;

@Mapper
public interface GoodChatDeleteMapper {
	public int softDelete(DeleteForm deleteForm);
}
