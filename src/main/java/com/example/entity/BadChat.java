package com.example.entity;

import java.time.LocalDateTime;
import java.util.List;

public class BadChat {
	private Integer id;
	private Integer userId;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;
	private List<BadReply> BadReplies;
	private User chatUser;
	
	private List<BadChatLike> badChatLikes;
	private Integer badChatLikesCount;
	
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
	
	
	public List<BadReply> getBadReplies() {
		return this.BadReplies;
	}
	public void setBadReplies(List<BadReply> BadReplies) {
		this.BadReplies = BadReplies;
	}
	
	public User getChatUser() {
		return this.chatUser;
	}
	public void setChatUser(User chatUser) {
		this.chatUser = chatUser;
	}
	
	public List<BadChatLike> getBadChatLikes() {
		return this.badChatLikes;
	}
	public void setBadChatLikes(List<BadChatLike> badChatLikes) {
		this.badChatLikes = badChatLikes;
	}

	public Integer getBadChatLikesCount() {
		return this.badChatLikesCount;
	}
	public void setBadChatLikesCount(Integer badChatLikesCount) {
		this.badChatLikesCount = badChatLikesCount;
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
