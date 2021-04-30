package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllController {
	@GetMapping("ChaosController")
	public String findAll(Model model) {
		String chaos = "にゃおにゃお！！！";
		model.addAttribute("Chaos", chaos );
		return "success";
	}

}
