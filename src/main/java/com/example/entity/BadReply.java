package com.example.entity;

import java.time.LocalDateTime;

public class BadReply {
	private Integer id;
	private Integer userId;
	private Integer chatId;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;
	private BadChat badChat;
	
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
	
	
	public BadChat getBadChat() {
		return this.badChat;
	}
	public void setBadChat(BadChat badChat) {
		this.badChat = badChat;
	}
}
