package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserDto;
import com.example.demo.service.UserService;

@RestController
public class JsonResponseController {
	@Autowired
	UserService userService;

	@PostMapping("getUser")
	public HashMap<String, ArrayList<UserDto>> getUser(
			@RequestParam("personId") String personId) throws IOException {
		System.out.println(personId);
		return userService.getUser(personId);
	}

	@PostMapping("insertUser")
	public HashMap<String, ArrayList<UserDto>> insertUser(@RequestParam("userId") String userId,
			@RequestParam("userName") String userName,
			@RequestParam("userAge") String userAge,
			@RequestParam("personId") String personId) throws IOException {

		HashMap<String, ArrayList<UserDto>> userInfo = null;
		if (!(userId.isEmpty() || userName.isEmpty() || userAge.isEmpty())) {
			userService.insertUser(userId, userName, userAge, personId);
			userInfo = userService.getUser(personId);
		} else {
			//userInfo = "{\"users\":[]}";
			userInfo = null;
			System.out.println(userInfo);
		}

		return userInfo;
	}

	@PostMapping("deleteUser")
	public HashMap<String, ArrayList<UserDto>> deleteUser(
			@RequestParam("userId") String userId,
			@RequestParam("personId") String personId) throws IOException {
		userService.deleteUser(userId, personId);
		return userService.getUser(personId);
	}


}
