package com.example.entity;

public class GoodReplyLikes {
	private Integer id;
	private Integer chatId;
	private Integer userId;
	private GoodReply goodReply;
	
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
	
	
	public GoodReply getGoodReply() {
		return this.goodReply;
	}
	public void setGoodReply(GoodReply goodReply) {
		this.goodReply = goodReply;
	}
}
