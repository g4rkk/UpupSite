package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BadChatLike;
import com.example.form.LikeForm;
import com.example.mapper.BadChatLikeMapper;

@Service
public class BadChatLikeService {
	
private final BadChatLikeMapper badChatLikeMapper;
	
	@Autowired
	public BadChatLikeService(BadChatLikeMapper badChatLikeMapper) {
		this.badChatLikeMapper = badChatLikeMapper;
	}
	
	
	public BadChatLike insert(LikeForm likeForm, LoginUser loginUser) {
		BadChatLike badChatLike = new BadChatLike();
		
		likeForm.setUserId(loginUser.getUser().getId());
		this.badChatLikeMapper.insert(likeForm);

		badChatLike.setChatId(likeForm.getChatId());
		badChatLike.setUserId(likeForm.getUserId());
		
		return badChatLike;
	}
	
	public BadChatLike delete(LikeForm likeForm, LoginUser loginUser) {
		BadChatLike badChatLike = new BadChatLike();
		
		likeForm.setUserId(loginUser.getUser().getId());
		this.badChatLikeMapper.delete(likeForm);

		badChatLike.setChatId(likeForm.getChatId());
		badChatLike.setUserId(likeForm.getUserId());
		
		return badChatLike;
	}
}
