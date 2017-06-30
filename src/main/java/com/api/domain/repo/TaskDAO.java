package com.api.domain.repo;

import java.util.List;

import com.api.domain.Task;

public interface TaskDAO {

	void createTask(Task task);

	Task findById(int taskId);

	List<Task> findByAssignee(int assigneeId);

	List<Task> findByAssignee(String assigneeUserName);

	List<Task> findAllTasks();

	int findAllTasksCount();

	List<Task> findAllOpenTasks();

	List<Task> findAllClosedTasks();

	int findAllOpenTasksCount();

	List<Task> findOpenTasksByAssignee(int assigneeId);

	List<Task> findOpenTasksByAssignee(String assigneeUserName);

	List<Task> findClosedTasksByAssignee(int assignee);

	List<Task> findClosedTasksByAssignee(String assigneeUserName);

	void deleteTask(Task task);

	void addFile(int taskId, String fileName);

	void deleteFile(int taskId, int fileId);

	void deleteAllFiles(int taskId);

}
