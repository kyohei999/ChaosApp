package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Food;
import com.example.demo.entity.Type;

@Service
public class RandomFoodService {

	public Map<String, List<Food>> getRondomFoodList() {

		List<Food> allFoodList = findAll();
		Collections.shuffle(allFoodList);
		List<Type> typeList = getTypeList();

		List<Food> mainFoodList = new ArrayList<Food>();
		List<Food> subFoodList = new ArrayList<Food>();
		List<Food> soupFoodList = new ArrayList<Food>();
		List<Food> hitFoodList = new ArrayList<Food>();
		List<Food> missFoodList = new ArrayList<Food>();
		List<List<Food>> JudgList = Arrays.asList(mainFoodList, subFoodList, soupFoodList, hitFoodList, missFoodList);

		for (Food food : allFoodList) {
			for (int i = 0; i < typeList.size(); i++) {
				if (food.getType_id() == typeList.get(i).getType_id()) {
					JudgList.get(i).add(food);
				}
			}
		}

		Map<String, List<Food>> weekFoodList = new LinkedHashMap<String, List<Food>>();
		String[] week = { "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日" };
		Random random = new Random();

		for (int i = 0; i < week.length; i++) {
			int randomFood;
			List<Food> rundomFoodList = new ArrayList<Food>();

			for (int j = 0; j < 3; j++) {
				randomFood = random.nextInt(JudgList.get(j).size());
				rundomFoodList.add(JudgList.get(j).get(randomFood));
			}

			int hit = random.nextInt(20);

			if (hit == 0) {
				rundomFoodList.add(hitFoodList.get(0));
			} else if (hit == 1) {
				rundomFoodList.clear();
				rundomFoodList.add(missFoodList.get(0));
			}
			weekFoodList.put(week[i], rundomFoodList);
		}
		return weekFoodList;
	}

	public List<Type> getTypeList() {
		Type type = null;
		List<Type> typeList = new ArrayList<Type>();
		String[] allType = {"主菜", "副菜", "汁物", "アタリ", "ハズレ"};

		for (int i = 0; i < allType.length; i++) {
			type = new Type();
			type.setType_id(i + 1);
			type.setType(allType[i]);
			typeList.add(type);
		}
		return typeList;
	}

	public List<Food> findAll() {
		List<Food> allFoodList = new ArrayList<Food>();
		Map<String, Integer> foodInfo = getFoodMap();

		Food food = null;
		for (String key : foodInfo.keySet()) {
			int i = 1;
			food = new Food();
			food.setFood_id(i + 1);
			food.setFood(key);
			food.setType_id(foodInfo.get(key));
			allFoodList.add(food);
			i++;
		}
		return allFoodList;
	}

	public Map<String, Integer> getFoodMap() {
		Map<String, Integer> foodMap = new HashMap<String, Integer>();
		foodMap.put("オムライス", 1);
		foodMap.put("ラーメン", 1);
		foodMap.put("焼きめし", 1);
		foodMap.put("かつ丼", 1);
		foodMap.put("焼肉", 1);
		foodMap.put("オムライス", 1);
		foodMap.put("おにぎり", 1);
		foodMap.put("海鮮丼", 1);
		foodMap.put("寿司", 1);
		foodMap.put("ハンバーグ", 1);
		foodMap.put("ピザ", 1);
		foodMap.put("パスタ", 1);
		foodMap.put("素うどん", 1);
		foodMap.put("お好み焼き", 1);
		foodMap.put("おせち", 1);
		foodMap.put("天丼", 1);
		foodMap.put("ミートスパ", 1);

		foodMap.put("ネギとツナサラダ", 2);
		foodMap.put("アボカドサラダ", 2);
		foodMap.put("小松菜の和え物", 2);
		foodMap.put("筍の土佐煮", 2);
		foodMap.put("煮物", 2);
		foodMap.put("もやしときゅうりのナムル", 2);
		foodMap.put("アスパラガスソテー", 2);
		foodMap.put("こんにゃくの甘辛煮", 2);
		foodMap.put("春雨サラダ", 2);
		foodMap.put("ほうれん草の白和え", 2);
		foodMap.put("プチトマトのマリネ", 2);
		foodMap.put("きんぴら炒め", 2);
		foodMap.put("ブロッコリーの胡麻和え", 2);
		foodMap.put("ホルモン炒め", 2);

		foodMap.put("オニオンスープ", 3);
		foodMap.put("キノコスープ", 3);
		foodMap.put("味噌汁", 3);
		foodMap.put("かぼちゃスープ", 3);
		foodMap.put("かに玉スープ", 3);
		foodMap.put("スープカレー", 3);
		foodMap.put("牛テールスープ", 3);
		foodMap.put("コーンポタージュ", 3);
		foodMap.put("クリームシチュー", 3);
		foodMap.put("豚汁", 3);
		foodMap.put("けんちん汁", 3);
		foodMap.put("コーラ汁", 3);
		foodMap.put("骨煮込みスープ", 3);
		foodMap.put("ツバメの巣ープ", 3);
		foodMap.put("リンスープ", 3);

		foodMap.put("ハーゲンダッツ", 4);
		foodMap.put("チョコ", 4);
		foodMap.put("ポテチ", 4);
		foodMap.put("ハイボール", 4);
		foodMap.put("生ビール", 4);
		foodMap.put("お刺身", 4);
		foodMap.put("さきイカ", 4);
		foodMap.put("柿ピー", 4);
		foodMap.put("焼き鳥の缶詰", 4);
		foodMap.put("生ハム", 4);

		foodMap.put("歯磨き粉", 5);
		foodMap.put("脱脂粉乳", 5);
		foodMap.put("くさや", 5);
		foodMap.put("シュールストレミング", 5);
		foodMap.put("ガム", 5);
		foodMap.put("梅干し一粒", 5);
		foodMap.put("ふりかけとごはん", 5);
		foodMap.put("飴一粒", 5);
		foodMap.put("ポテチ一枚", 5);
		foodMap.put("飯抜き", 5);
		foodMap.put("キャットフード", 5);
		foodMap.put("ドッグフード", 5);
		foodMap.put("うまい棒", 5);
		foodMap.put("たくわん一切れ", 5);


		return foodMap;
	}

}
