package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BadReply;
import com.example.form.DeleteForm;
import com.example.form.MessageForm;
import com.example.mapper.BadReplyMapper;

@Service
public class BadReplyService {
	
private final BadReplyMapper badReplyMapper;
	
	@Autowired
	public BadReplyService(BadReplyMapper badReplyMapper) {
		this.badReplyMapper = badReplyMapper;
	}
	
	public BadReply insert(MessageForm messageForm, LoginUser loginUser) {
		BadReply badReply = new BadReply();
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		
		messageForm.setUserId(loginUser.getUser().getId());
		messageForm.setCreatedAt(nowLocalDateTime);
		this.badReplyMapper.insert(messageForm);

		badReply.setId(messageForm.getId());
		badReply.setUserId(messageForm.getUserId());
		badReply.setChatId(messageForm.getChatId());
		badReply.setCreatedAt(messageForm.getCreatedAt());
		badReply.setMessage(messageForm.getMessage());
		badReply.setName(loginUser.getUser().getName());
		
		return badReply;
	}
	
	public BadReply softDelete(DeleteForm deleteForm, LoginUser loginUser) {
		BadReply badReply = new BadReply();
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		
		deleteForm.setDeletedAt(nowLocalDateTime);
		this.badReplyMapper.softDelete(deleteForm);
		badReply.setId(deleteForm.getId());
		
		return badReply;
	}
}
