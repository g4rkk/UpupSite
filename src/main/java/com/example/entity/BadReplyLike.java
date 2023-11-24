package com.example.entity;

public class BadReplyLike {
	private Integer id;
	private Integer replyId;
	private Integer userId;
	private BadReply badReply;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getReplyId() {
		return this.replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	public BadReply getBadReply() {
		return this.badReply;
	}
	public void setBadReply(BadReply badReply) {
		this.badReply = badReply;
	}
}
