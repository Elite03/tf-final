package com.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Task implements Serializable {

	private static final long serialVersionUID = -2376108659631495672L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int priority;
	private String status;

	@OneToOne
	private User createdBy;
	private Date createedDate;

	@OneToOne
	private User assignee;
	private Date completionDate;

	@OneToMany
	@JoinTable
	private List<TaskComment> taskComments = new ArrayList<>();

	public Task() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	public String getStatus() {
		return status;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public Date getCreateedDate() {
		return createedDate;
	}

	public User getAssignee() {
		return assignee;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public List<TaskComment> getTaskComments() {
		return taskComments;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreateedDate(Date createedDate) {
		this.createedDate = createedDate;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public void setTaskComments(List<TaskComment> taskComments) {
		this.taskComments = taskComments;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", priority=" + priority + ", status=" + status + ", createdBy="
				+ createdBy + ", createedDate=" + createedDate + ", assignee=" + assignee + ", completionDate="
				+ completionDate + ", taskComments=" + taskComments + "]";
	}

}
