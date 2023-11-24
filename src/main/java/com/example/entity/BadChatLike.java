package com.example.entity;

public class BadChatLike {
	private Integer id;
	private Integer chatId;
	private Integer userId;
	private BadChat badChat;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getChatId() {
		return this.chatId;
	}
	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	public BadChat getBadChat() {
		return this.badChat;
	}
	public void setBadChat(BadChat badChat) {
		this.badChat = badChat;
	}
}
