package com.api.domain.repo.inMemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.api.domain.Task;
import com.api.domain.repo.TaskDAO;

@Repository
public class InMemoryTaskRepositiry implements TaskDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<Task> taskDB = new ArrayList<>();

	public int getNextSequenceId() {
		return this.taskDB.stream().mapToInt(Task::getId).max().orElse(0) + 1;
	}

	@Override
	public void createTask(Task task) {
		task.setId(getNextSequenceId());
		taskDB.add(task);
		logger.info(String.format("[-----------------------]Task: [%s] ", task.toString()));
	}

	@Override
	public Task findById(int taskId) {
		return taskDB.stream().filter(task -> Objects.nonNull(task.getId()) && task.getId() == taskId)
				.peek(t -> logger.info(String.format("Task: [%s]", t.toString()))).findAny().orElse(null);
	}

	@Override
	public List<Task> findByAssignee(int assigneeId) {
		return taskDB.stream()
				.filter(task -> Objects.nonNull(task.getAssignee()) && task.getAssignee().getId() == assigneeId)
				.collect(Collectors.toList());
	}

	@Override
	public List<Task> findByAssignee(String assigneeUserName) {
		return taskDB.stream().filter(task -> task.getAssignee().getUserName().equals(assigneeUserName))
				.collect(Collectors.toList());
	}

	@Override
	public List<Task> findAllTasks() {
		return taskDB;
	}

	@Override
	public int findAllTasksCount() {
		return taskDB.size();
	}

	@Override
	public List<Task> findAllOpenTasks() {
		return taskDB.stream().filter(task -> task.getStatus().equals("Open")).collect(Collectors.toList());
	}

	@Override
	public int findAllOpenTasksCount() {
		return this.findAllOpenTasks().size();
	}

	@Override
	public List<Task> findOpenTasksByAssignee(int assigneeId) {
		return this.findByAssignee(assigneeId).stream().filter(task -> task.getStatus().equals("Open"))
				.collect(Collectors.toList());
	}

	@Override
	public List<Task> findOpenTasksByAssignee(String assigneeUserName) {
		return this.findByAssignee(assigneeUserName).stream().filter(task -> task.getStatus().equals("Open"))
				.collect(Collectors.toList());
	}

}
