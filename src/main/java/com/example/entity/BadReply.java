package com.example.entity;

import java.time.LocalDateTime;
import java.util.List;

public class BadReply {
	private Integer id;
	private Integer userId;
	private Integer chatId;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;
	private BadChat badChat;
	private User replyUser;
	
	private List<BadReplyLike> badReplyLikes;
	private Integer badReplyLikesCount;
	
	private String typeMessage;
	private String name;
	private String image;
	
	
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
	
	public User getReplyUser() {
		return this.replyUser;
	}
	public void setReplyUser(User replyUser) {
		this.replyUser = replyUser;
	}
	
	public List<BadReplyLike> getBadReplyLikes() {
		return this.badReplyLikes;
	}
	public void setBadReplyLikes(List<BadReplyLike> badReplyLikes) {
		this.badReplyLikes = badReplyLikes;
	}
	
	public Integer getBadReplyLikesCount() {
		return this.badReplyLikesCount;
	}
	public void setBadReplyLikesCount(Integer badReplyLikesCount) {
		this.badReplyLikesCount = badReplyLikesCount;
	}
	
	public String getTypeMessage() {
		return this.typeMessage;
	}
	public void setTypeMessage(String typeMessage) {
		this.typeMessage = typeMessage;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
