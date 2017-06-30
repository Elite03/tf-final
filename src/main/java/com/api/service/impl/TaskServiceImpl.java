package com.api.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.api.Util;
import com.api.domain.Task;
import com.api.domain.TaskComment;
import com.api.domain.repo.TaskDAO;
import com.api.service.TaskService;
import com.api.service.UserService;

@Service
public class TaskServiceImpl implements TaskService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TaskDAO taskRepositiry;

	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {
		logger.info("Initated");

	}

	@PreDestroy
	public void cleanUp() {
		logger.info("Destroyed");
	}

	@Override
	public Task findTaskById(int taskId) {
		return taskRepositiry.findById(taskId);
	}

	@Override
	public List<Task> findTasksByAssignee(int assigneeId) {
		return taskRepositiry.findOpenTasksByAssignee(assigneeId);
	}

	@Override
	public List<Task> findAllTasks() {
		return taskRepositiry.findAllTasks();
	}

	@Override
	public int findAllTasksCount() {
		return taskRepositiry.findAllTasksCount();
	}

	@Override
	public List<Task> findAllOpenTasks() {
		return taskRepositiry.findAllOpenTasks();
	}

	@Override
	public int findAllOpenTasksCount() {
		return taskRepositiry.findAllTasksCount();
	}

	@Override
	public List<Task> findTasksByAssignee(String assigneeUserName) {
		return taskRepositiry.findOpenTasksByAssignee(assigneeUserName);
	}

	@Override
	public List<Task> findOpenTasksByAssignee(int assigneeId) {
		return taskRepositiry.findOpenTasksByAssignee(assigneeId);
	}

	@Override
	public List<Task> findOpenTasksByAssignee(String assigneeUserName) {
		return taskRepositiry.findOpenTasksByAssignee(assigneeUserName);
	}

	@Override
	public void completeTask(int taskId, String comments, int user) {
		Task task = new Task();
		if (task.getAssignee().getId() != user) {
			throw new UnsupportedOperationException("This Task has not been assigned by provided User");
		}

		task.setStatus("Complete");
		task.setCreateedDate(Util.now());

		if (!StringUtils.isEmpty(task.getTaskComments())) {
			task.getTaskComments().add(new TaskComment(userService.findById(user), comments, task.getStatus()));
		}
		logger.info("Task Completed");

	}

	@Override
	public Task createTask(Task task) {
		taskRepositiry.createTask(task);
		return task;
	}

	@Override
	public Task createTask(String name, int priority, int createdByuserId, int assigneeUserId, String comments) {
		Task task = new Task();
		task.setName(name);
		task.setPriority(priority);
		task.setCreatedBy(userService.findById(createdByuserId));
		task.setAssignee(userService.findById(assigneeUserId));
		task.setStatus("Open");
		taskRepositiry.createTask(task);
		return task;
	}

	@Override
	public List<Task> findAllClosedTasks() {
		return taskRepositiry.findAllClosedTasks();
	}

	@Override
	public List<Task> findClosedTasksByAssignee(int assigneeId) {
		return taskRepositiry.findClosedTasksByAssignee(assigneeId);
	}

	@Override
	public List<Task> findClosedTasksByAssignee(String assigneeUserName) {
		return taskRepositiry.findClosedTasksByAssignee(assigneeUserName);
	}

	@Override
	public void reassignTask(int taskId, String comments, int assigneeId) {

	}

	@Override
	public void deleteTask(int taskId) {
		taskRepositiry.deleteTask(taskRepositiry.findById(taskId));
	}

	@Override
	public void addFile(int taskId, String fileName) {
		taskRepositiry.addFile(taskId, fileName);
	}

	@Override
	public void deleteFile(int taskId, int fileId) {
		taskRepositiry.deleteFile(taskId, fileId);
	}

	@Override
	public void deleteAllFiles(int taskId) {
		taskRepositiry.deleteAllFiles(taskId);
	}
}
