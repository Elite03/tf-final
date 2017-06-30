package com.api.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.Util;
import com.api.domain.User;
import com.api.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/")
	public String listAllUsers(Locale locale, Model model) {
		logger.info("Locale is {}", locale);
		model.addAttribute("users", userService.findAllUsers());
		return "user/list";
	}

	@GetMapping("/new")
	public String newUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user/new";
	}

	@PostMapping("/new")
	public String saveForm(@ModelAttribute User user) {
		user.setDateOfBirth(Util.now());
		userService.createNewUser(user);
		return "redirect:/user/";
	}

	@GetMapping("/{id}")
	public String viewUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.findById(id));
		return "user/view";
	}

	@GetMapping("/{id}/edit")
	public String editUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", new User());
		return "user/edit";
	}

	@PutMapping("/{id}")
	public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user, Model model) {
		userService.updateUser(user);
		model.addAttribute("user", userService.findById(user.getId()));
		return "redirect:/user/" + id;
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		userService.deleteUser(userService.findById(id));
		return "redirect:/user";
	}

}
