package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.GoodReply;
import com.example.form.MessageForm;
import com.example.mapper.GoodReplyMapper;

@Service
public class GoodReplyService {
	
	private final GoodReplyMapper goodReplyMapper;
	
	@Autowired
	public GoodReplyService(GoodReplyMapper goodReplyMapper) {
		this.goodReplyMapper = goodReplyMapper;
	}
	
	public GoodReply insert(MessageForm messageForm, LoginUser loginUser) {
		GoodReply goodReply = new GoodReply();
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		
		messageForm.setUserId(loginUser.getUser().getId());
		messageForm.setCreatedAt(nowLocalDateTime);
		this.goodReplyMapper.insert(messageForm);

		goodReply.setId(messageForm.getId());
		goodReply.setUserId(messageForm.getUserId());
		goodReply.setChatId(messageForm.getChatId());
		goodReply.setCreatedAt(messageForm.getCreatedAt());
		goodReply.setMessage(messageForm.getMessage());
		
		return goodReply;
	}
}
