package com.api.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.service.TaskService;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TaskService taskService;

	@RequestMapping("/")
	public String home(Locale locale, Model model) {

		logger.info("Welcome to Taskify! Current locale is {}", locale);
		model.addAttribute("totalTasks", taskService.findAllTasksCount());
		model.addAttribute("totalOpenTasks", taskService.findAllOpenTasksCount());
		return "index";
	}
}
