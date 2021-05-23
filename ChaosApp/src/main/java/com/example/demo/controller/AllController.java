package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Food;
import com.example.demo.entity.Type;
import com.example.demo.service.RandomFoodService;
import com.example.demo.service.RandomWordService;

@Controller
public class AllController {
	@Autowired
	RandomWordService randomWordService;

	@Autowired
	RandomFoodService randomFoodService;

	@GetMapping("UserController")
	public String getUser(Model model) {
		return "user_crud";
	}

	@GetMapping("CatController")
	public String catPictureshow(Model model) {
		String chaos = "にゃおにゃお！！！";
		//model.addAttribute("Chaos", chaos);
		return "Cat";
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


	@GetMapping("RandomfoodController")
	public String getRandomFood(Model model) {
		Map<String, List<Food>>  foodRandomList = randomFoodService.getRondomFoodList();
		List<Type> typeList = randomFoodService.getTypeList();
		model.addAttribute("foodList", foodRandomList);
		model.addAttribute("typeList", typeList);
		return "RandomFood";
	}
}
