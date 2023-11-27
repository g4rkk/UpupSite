package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BadReplyLike;
import com.example.form.LikeForm;
import com.example.mapper.BadReplyLikeMapper;

@Service
public class BadReplyLikeService {

	private final BadReplyLikeMapper badReplyLikeMapper;
	
	@Autowired
	public BadReplyLikeService(BadReplyLikeMapper badReplyLikeMapper) {
		this.badReplyLikeMapper = badReplyLikeMapper;
	}
	
	
	public BadReplyLike insert(LikeForm likeForm, LoginUser loginUser) {
		BadReplyLike badReplyLike = new BadReplyLike();
		
		likeForm.setUserId(loginUser.getUser().getId());
		this.badReplyLikeMapper.insert(likeForm);
	
		badReplyLike.setReplyId(likeForm.getReplyId());
		badReplyLike.setUserId(likeForm.getUserId());
		
		return badReplyLike;
	}
	
	public BadReplyLike delete(LikeForm likeForm, LoginUser loginUser) {
		BadReplyLike badReplyLike = new BadReplyLike();
		
		likeForm.setUserId(loginUser.getUser().getId());
		this.badReplyLikeMapper.delete(likeForm);
	
		badReplyLike.setReplyId(likeForm.getReplyId());
		badReplyLike.setUserId(likeForm.getUserId());
		
		return badReplyLike;
	}
}
