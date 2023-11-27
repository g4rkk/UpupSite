package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.GoodChatLike;
import com.example.form.LikeForm;
import com.example.mapper.GoodChatLikeMapper;

@Service
public class GoodChatLikeService {
	
	private final GoodChatLikeMapper goodChatLikeMapper;
	
	@Autowired
	public GoodChatLikeService(GoodChatLikeMapper goodChatLikeMapper) {
		this.goodChatLikeMapper = goodChatLikeMapper;
	}
	
	
	public GoodChatLike insert(LikeForm likeForm, LoginUser loginUser) {
		GoodChatLike goodChatLike = new GoodChatLike();
		
		likeForm.setUserId(loginUser.getUser().getId());
		this.goodChatLikeMapper.insert(likeForm);

		goodChatLike.setChatId(likeForm.getChatId());
		goodChatLike.setUserId(likeForm.getUserId());
		
		return goodChatLike;
	}
	
	public GoodChatLike delete(LikeForm likeForm, LoginUser loginUser) {
		GoodChatLike goodChatLike = new GoodChatLike();
		
		likeForm.setUserId(loginUser.getUser().getId());
		this.goodChatLikeMapper.delete(likeForm);

		goodChatLike.setChatId(likeForm.getChatId());
		goodChatLike.setUserId(likeForm.getUserId());
		
		return goodChatLike;
	}
}
