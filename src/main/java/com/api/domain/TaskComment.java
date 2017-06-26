package com.api.domain;

public class TaskComment {

	private User user;
	private String comment;
	private String status;

	public TaskComment() {
	}

	public TaskComment(User user, String comment, String status) {
		this.user = user;
		this.comment = comment;
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public String getComment() {
		return comment;
	}

	public String getStatus() {
		return status;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TaskComment [user=" + user + ", comment=" + comment + ", status=" + status + "]";
	}

}
