package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.GoodChatLike;
import com.example.entity.GoodReplyLike;
import com.example.form.LikeForm;
import com.example.mapper.GoodReplyLikeMapper;

@Service
public class GoodReplyLikeService {
	
	private final GoodReplyLikeMapper goodReplyLikeMapper;
	
	@Autowired
	public GoodReplyLikeService(GoodReplyLikeMapper goodReplyLikeMapper) {
		this.goodReplyLikeMapper = goodReplyLikeMapper;
	}
	
	
	public GoodReplyLike insert(LikeForm likeForm, LoginUser loginUser) {
		GoodReplyLike goodReplyLike = new GoodReplyLike();
		
		likeForm.setUserId(loginUser.getUser().getId());
		this.goodReplyLikeMapper.insert(likeForm);

		goodReplyLike.setReplyId(likeForm.getReplyId());
		goodReplyLike.setUserId(likeForm.getUserId());
		
		return goodReplyLike;
	}
	
	public GoodReplyLike delete(LikeForm likeForm, LoginUser loginUser) {
		GoodReplyLike goodReplyLike = new GoodReplyLike();
		
		likeForm.setUserId(loginUser.getUser().getId());
		this.goodReplyLikeMapper.delete(likeForm);

		goodReplyLike.setReplyId(likeForm.getReplyId());
		goodReplyLike.setUserId(likeForm.getUserId());
		
		return goodReplyLike;
	}
}
