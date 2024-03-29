package com.example.entity;

import java.time.LocalDateTime;

public class User {
	private Integer id;
	private String email;
	private String password;
	private String name;
	private Integer choiceGood;
	private Integer choiceBad;
	private LocalDateTime birthday;
	private String image;
	private Integer money;
	private Integer job;
	private Integer love;
	private String motivation;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getChoiceGood() {
		return this.choiceGood;
	}
	public void setChoiceGood(Integer choiceGood) {
		this.choiceGood = choiceGood;
	}
	
	public Integer getChoiceBad() {
		return this.choiceBad;
	}
	public void setChoiceBad(Integer choiceBad) {
		this.choiceBad = choiceBad;
	}

	public LocalDateTime getBirthday() {
		return this.birthday;
	}
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Integer getMoney() {
		return this.money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
	public Integer getJob() {
		return this.job;
	}
	public void setJob(Integer job) {
		this.job = job;
	}
	
	public Integer getLove() {
		return this.love;
	}
	public void setLove(Integer love) {
		this.love = love;
	}
	
	public String getMotivation() {
		return this.motivation;
	}
	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}
}
