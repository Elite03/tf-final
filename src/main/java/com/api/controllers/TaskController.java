package com.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.domain.Task;
import com.api.service.TaskService;
import com.api.service.UserService;

@Controller
@RequestMapping("/task/")
public class TaskController {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public String all(Model model) {
		model.addAttribute("tasks", taskService.findAllTasks());
		return "task/list";
	}

	@GetMapping("/new")
	public String newTaskForm(Model model) {
		model.addAttribute("task", new Task());
		return "task/new";
	}

}
