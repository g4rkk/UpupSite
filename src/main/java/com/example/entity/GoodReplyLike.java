package com.example.entity;

public class GoodReplyLike {
	private Integer id;
	private Integer replyId;
	private Integer userId;
	private GoodReply goodReply;
	
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
	
	
	public GoodReply getGoodReply() {
		return this.goodReply;
	}
	public void setGoodReply(GoodReply goodReply) {
		this.goodReply = goodReply;
	}
}
