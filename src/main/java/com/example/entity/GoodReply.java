package com.example.entity;

import java.time.LocalDateTime;

public class GoodReply {
	private Integer id;
	private Integer userId;
	private Integer chatId;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;
	private GoodChat goodChat;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getChatId() {
		return this.chatId;
	}
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getDeletedAt() {
		return this.deletedAt;
	}
	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	
	public GoodChat getGoodChat() {
		return this.goodChat;
	}
	public void setGoodChat(GoodChat goodChat) {
		this.goodChat = goodChat;
	}
}