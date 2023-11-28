package com.example.entity;

import java.util.Date;

public class Profile {
	private Integer id;
    private String email;
    private String password;
    private String name;
    private Integer choiseGood; // 而非 choiceGood
    private Integer choiseBad;  // 而非 choiceBad
    private Date birthday;
    private String image;
    private Integer money;
    private Integer job;
    private Integer love;
    private String motivation;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public Integer getChoiseGood() {
        return choiseGood;
    }

    public void setChoiseGood(Integer choiseGood) {
        this.choiseGood = choiseGood;
    }

    public Integer getChoiseBad() {
        return choiseBad;
    }

    public void setChoiseBad(Integer choiseBad) {
        this.choiseBad = choiseBad;
    }
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getJob() {
		return job;
	}
	public void setJob(Integer job) {
		this.job = job;
	}
	public Integer getLove() {
		return love;
	}
	public void setLove(Integer love) {
		this.love = love;
	}
	public String getMotivation() {
		return motivation;
	}
	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

}
