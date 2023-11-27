package com.example.form;

import java.time.LocalDateTime;

public class DeleteForm {

	private Integer id;
	private LocalDateTime deletedAt;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getDeletedAt() {
		return this.deletedAt;
	}
	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
}
