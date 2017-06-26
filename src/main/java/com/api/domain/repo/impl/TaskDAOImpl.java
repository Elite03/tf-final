package com.api.domain.repo.impl;

import com.api.domain.Task;

public class TaskDAOImpl extends GenericRepoImpl<Task, Long> {
	public TaskDAOImpl() {
		super(Task.class);
	}

}
