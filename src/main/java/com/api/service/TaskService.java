package com.api.service;

import java.util.List;

import com.api.domain.Task;

public interface TaskService {
	Task createTask(Task task);

	Task createTask(String name, int priority, int createdByuserId, int assigneeUserId, String comments);

	Task findTaskById(int taskId);

	List<Task> findTasksByAssignee(int assigneeId);

	List<Task> findAllTasks();

	int findAllTasksCount();

	List<Task> findAllOpenTasks();

	List<Task> findAllClosedTasks();

	int findAllOpenTasksCount();

	List<Task> findTasksByAssignee(String assigneeUserName);

	List<Task> findOpenTasksByAssignee(int assigneeId);

	List<Task> findOpenTasksByAssignee(String assigneeUserName);

	List<Task> findClosedTasksByAssignee(int assigneeId);

	List<Task> findClosedTasksByAssignee(String assigneeUserName);

	void completeTask(int taskId, String comments, int userId);

	void reassignTask(int taskId, String comments, int assigneeId);

	void deleteTask(int taskId);

	void addFile(int taskId, String fileName);

	void deleteFile(int taskId, int fileId);

	void deleteAllFiles(int taskId);
}
