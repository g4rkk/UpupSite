package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.form.LikeForm;

@Mapper
public interface GoodReplyLikeMapper {
	public int insert(LikeForm likeForm);
	public int delete(LikeForm likeForm);
}
