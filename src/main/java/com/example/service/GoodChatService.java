package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.GoodChat;
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
	
	
	
}
