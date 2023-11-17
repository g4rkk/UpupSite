package com.example.entity;

import java.time.LocalDateTime;
import java.util.List;

public class GoodChat {
	private Integer id;
	private Integer userId;
	private String message;
	private LocalDateTime createdAt;
	private LocalDateTime deletedAt;
	private List<GoodReply> goodReplies;
	
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
	
	
	public List<GoodReply> getGoodReplies() {
		return this.goodReplies;
	}
	public void setGoodReplies(List<GoodReply> goodReplies) {
		this.goodReplies = goodReplies;
	}
}
