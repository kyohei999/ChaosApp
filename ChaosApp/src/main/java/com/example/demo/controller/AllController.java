package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RandomWordService;

@Controller
public class AllController {
	@Autowired
	RandomWordService randomWordService;

	@GetMapping("CatController")
	public String catPictureshow(Model model) {
		String chaos = "にゃおにゃお！！！";
		model.addAttribute("Chaos", chaos);
		return "cat";
	}

	@PostMapping("RandomWordController")
	//nameに代入されたデータがString wordに代入される
	public String RandomWord(Model model, @RequestParam(value = "word", defaultValue = "") String value) {

		String randomWord = "";

		if (!(value == null || value.isEmpty())) {
			randomWord = randomWordService.MakeRandomWord(value);
		} else {
			randomWord = "";
		}

		model.addAttribute("randomWord", randomWord);
		return "RandomWord";
	}

}
