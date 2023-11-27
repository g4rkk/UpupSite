package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.GoodChat;
import com.example.form.DeleteForm;
import com.example.form.MessageForm;
import com.example.mapper.GoodChatMapper;
import com.example.mapper.GoodReplyMapper;

@Service
public class GoodChatService {
	
	private final GoodChatMapper goodChatMapper;
	private final GoodReplyMapper goodReplyMapper;
	
	@Autowired
	public GoodChatService(GoodChatMapper goodChatMapper, GoodReplyMapper goodReplyMapper) {
		this.goodChatMapper = goodChatMapper;
		this.goodReplyMapper = goodReplyMapper;
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
		goodChat.setName(loginUser.getUser().getName());
		
		return goodChat;
	}
	
	public GoodChat softDelete(DeleteForm deleteForm, LoginUser loginUser) {
		GoodChat goodChat = new GoodChat();
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		
		deleteForm.setDeletedAt(nowLocalDateTime);
		this.goodChatMapper.softDelete(deleteForm);
		goodChat.setId(deleteForm.getId());
		
		this.goodReplyMapper.cascadeReplySoftDelete(deleteForm);
		
		return goodChat;
	}
	
}
