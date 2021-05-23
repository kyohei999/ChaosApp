package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RandomWordService {
	public String MakeRandomWord(String word) {
		DictionaryService dictionaryService = new DictionaryService();
		String randomWord = dictionaryService.JudgWord(word);

		return randomWord;
	}
}
