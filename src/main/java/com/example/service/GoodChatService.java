package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.GoodChat;
import com.example.form.MessageForm;
import com.example.mapper.GoodChatMapper;

@Service
public class GoodChatService {
	
	private final GoodChatMapper goodChatMapper;
	
	@Autowired
	public GoodChatService(GoodChatMapper goodChatMapper) {
		this.goodChatMapper = goodChatMapper;
	}
	
	
	public List<GoodChat> findAll() {
		return this.goodChatMapper.findAll();
	}
	
	public GoodChat insert(MessageForm messageForm, LoginUser loginUser) {
		GoodChat goodChat = new GoodChat();
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		
		messageForm.setUserId(loginUser.getUser().getId());
		messageForm.setCreatedAt(nowLocalDateTime);
		this.goodChatMapper.insert(messageForm);

		goodChat.setId(messageForm.getId());
		goodChat.setUserId(messageForm.getUserId());
		goodChat.setCreatedAt(messageForm.getCreatedAt());
		goodChat.setMessage(messageForm.getMessage());
		
		return goodChat;
	}
	
}
