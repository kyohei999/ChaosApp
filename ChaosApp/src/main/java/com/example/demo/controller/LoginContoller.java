package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginContoller {

	@PostMapping("UserController")
	public String getUser(Model model, @RequestParam("userId") String userId,
			@RequestParam("userPass") String userPass) {
		model.addAttribute("userId", userId);
		model.addAttribute("userPass", userPass);

		return "user_crud";
	}

	@GetMapping("UserLogin")
	public String userLogin(Model model) {
		return "login";
	}

	@GetMapping("EntryUser")
	public String entryUser(Model model) {
		return "entry_user";
	}

	@PostMapping("EntryUserInfo")
	public String entryUser(Model model, @RequestParam("userId") String userId,
			@RequestParam("userName") String userName,
			@RequestParam("userAge") String userAge) {
		//model.addAttribute("randomWord", randomWord);
		return "login";
	}
}
