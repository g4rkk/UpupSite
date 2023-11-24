package com.example.entity;

import java.time.LocalDateTime;
import java.util.List;

public class GoodReply {
	private Integer id;
	private Integer userId;
	private Integer chatId;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;
	private GoodChat goodChat;
	private User replyUser;
	
	private List<GoodReplyLike> goodReplyLikes;
	private Integer goodReplyLikesCount;
	
	private Integer loggedUserFlag;
	
	
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
	
	public User getReplyUser() {
		return this.replyUser;
	}
	public void setReplyUser(User replyUser) {
		this.replyUser = replyUser;
	}
	
	public List<GoodReplyLike> getGoodReplyLikes() {
		return this.goodReplyLikes;
	}
	public void setGoodReplyLikes(List<GoodReplyLike> goodReplyLikes) {
		this.goodReplyLikes = goodReplyLikes;
	}
	
	public Integer getGoodReplyLikesCount() {
		return this.goodReplyLikesCount;
	}
	public void setGoodReplyLikesCount(Integer goodReplyLikesCount) {
		this.goodReplyLikesCount = goodReplyLikesCount;
	}
	
	public Integer getLoggedUserFlag() {
		return this.loggedUserFlag;
	}
	public void setLoggedUserFlag(Integer loggedUserFlag) {
		this.loggedUserFlag = loggedUserFlag;
	}
}
