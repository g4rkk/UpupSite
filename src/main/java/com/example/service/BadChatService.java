package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BadChat;
import com.example.form.DeleteForm;
import com.example.form.MessageForm;
import com.example.mapper.BadChatMapper;
import com.example.mapper.BadReplyMapper;

@Service
public class BadChatService {
	
	private final BadChatMapper badChatMapper;
	private final BadReplyMapper badReplyMapper;
	
	@Autowired
	public BadChatService(BadChatMapper badChatMapper, BadReplyMapper badReplyMapper) {
		this.badChatMapper = badChatMapper;
		this.badReplyMapper = badReplyMapper;
	}
	
	
	public List<BadChat> findAll() {
		return this.badChatMapper.findAll();
	}
	
	public BadChat insert(MessageForm messageForm, LoginUser loginUser) {
		BadChat badChat = new BadChat();
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		
		messageForm.setUserId(loginUser.getUser().getId());
		messageForm.setCreatedAt(nowLocalDateTime);
		this.badChatMapper.insert(messageForm);

		badChat.setId(messageForm.getId());
		badChat.setUserId(messageForm.getUserId());
		badChat.setCreatedAt(messageForm.getCreatedAt());
		badChat.setMessage(messageForm.getMessage());
		badChat.setName(loginUser.getUser().getName());
		badChat.setImage(loginUser.getUser().getImage());
		
		return badChat;
	}
	
	public BadChat softDelete(DeleteForm deleteForm, LoginUser loginUser) {
		BadChat badChat = new BadChat();
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		
		deleteForm.setDeletedAt(nowLocalDateTime);
		this.badChatMapper.softDelete(deleteForm);
		badChat.setId(deleteForm.getId());
		
		this.badReplyMapper.cascadeReplySoftDelete(deleteForm);
		
		return badChat;
	}
	
}
