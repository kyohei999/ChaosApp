package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserDto;
import com.example.demo.service.UserService;

@RestController
public class JsonResponseController {
	@Autowired
	UserService userService;

	@GetMapping("getUser")
	public HashMap<String, ArrayList<UserDto>> getUser() throws IOException {
		return userService.getUser();
	}

	@PostMapping("insertUser")
	public HashMap<String, ArrayList<UserDto>> insertUser(@RequestParam("userId") String userId,
			@RequestParam("userName") String userName,
			@RequestParam("userAge") String userAge) throws IOException {

		userService.insertUser(userId, userName, userAge);

		return userService.getUser();
	}

	@PostMapping("deleteUser")
	public HashMap<String, ArrayList<UserDto>> deleteUser(@RequestParam("userId") String userId) throws IOException {
		System.out.println(userId);

		userService.deleteUser(userId);

		return userService.getUser();
	}
}
