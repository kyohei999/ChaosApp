package com.example.demo.service;

public class DictionaryService {
	public String JudgWord(String word) {

		//カタカナの場合はひらがなに変換
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < word.length(); i++) {
			char code = word.charAt(i);
			if ((code >= 0x30a1) && (code <= 0x30f3)) {
				buf.append((char) (code - 0x60));
			} else {
				buf.append(code);
			}
		}

		if (buf.substring(buf.length() - 1).toString().equals("ー")) {
			buf.setLength(buf.length() - 1);
		}

		String randomWord = "";
		String lastWord = buf.substring(buf.length() - 1);

		switch (lastWord) {
		case "あ":
			randomWord = "あべべ";
			break;
		case "い":
			randomWord = "石焼き芋、お芋♪";
			break;
		case "う":
			randomWord = "牛に問う";
			break;
		case "え":
			randomWord = "駅前のタクシー";
			break;
		case "お":
			randomWord = "お絵描き二級";
			break;
		case "か":
			randomWord = "柿の種５粒";
			break;
		case "き":
			randomWord = "鬼滅の差し歯";
			break;
		case "く":
			randomWord = "国の言いなり";
			break;
		case "け":
			randomWord = "ケシカス2ｍｇ";
			break;
		case "こ":
			randomWord = "こそばゆい";
			break;
		case "さ":
			randomWord = "殺傷能力";
			break;
		case "し":
			randomWord = "しけた面";
			break;
		case "す":
			randomWord = "隙間産業";
			break;
		case "せ":
			randomWord = "セネガルの刺客";
			break;
		case "そ":
			randomWord = "それーいそれーい";
			break;
		case "た":
			randomWord = "田んぼツアー";
			break;
		case "ち":
			randomWord = "チュートリアル徳井(納税)";
			break;
		case "つ":
			randomWord = "積み立てNEET";
			break;
		case "て":
			randomWord = "テスト地獄";
			break;
		case "と":
			randomWord = "徳川の裁縫";
			break;
		case "な":
			randomWord = "泣きっ面にクソ";
			break;
		case "に":
			randomWord = "人間ドミノ";
			break;
		case "ぬ":
			randomWord = "塗り壁の苦悩";
			break;
		case "ね":
			randomWord = "寧々ちゃんのおままごと";
			break;
		case "の":
			randomWord = "野原家の日常";
			break;
		case "は":
			randomWord = "針の筵";
			break;
		case "ひ":
			randomWord = "ひいひいひいひいひいひいおじいさんの下駄";
			break;
		case "ふ":
			randomWord = "フーリガン暴走";
			break;
		case "へ":
			randomWord = "下手こいた";
			break;
		case "ほ":
			randomWord = "干し草";
			break;
		case "ま":
			randomWord = "マナー教師の悪態";
			break;
		case "み":
			randomWord = "ミニストップ利用率";
			break;
		case "む":
			randomWord = "むき出しのヅラ";
			break;
		case "め":
			randomWord = "目覚めのメザシ";
			break;
		case "も":
			randomWord = "モチモチのモチ";
			break;
		case "や":
			randomWord = "やばい言葉";
			break;
		case "ゆ":
			randomWord = "ユーザー確保";
			break;
		case "よ":
			randomWord = "預金調査実施";
			break;
		case "ん":
			randomWord = "んんんんんんんんんんんんんんんんんんはあかんんんんんんんんんんんんんんんんんんんんんんんんんん";
			break;
		case "が":
			randomWord = "餓死回避";
			break;
		case "ぎ":
			randomWord = "技能試験54回目";
			break;
		case "ぐ":
			randomWord = "グミ咀嚼";
			break;
		case "げ":
			randomWord = "ゲーム中毒カツオ";
			break;
		case "ご":
			randomWord = "ごめんね";
			break;
		case "ざ":
			randomWord = "雑草魂";
			break;
		case "じ":
			randomWord = "時期尚早";
			break;
		case "ず":
			randomWord = "ずっとカレー";
			break;
		case "ぜ":
			randomWord = "銭亀";
			break;
		case "ぞ":
			randomWord = "臓器メンテナンス";
			break;
		case "だ":
			randomWord = "蛇行走法";
			break;
		case "ぢ":
			randomWord = "地価暴騰";
			break;
		case "づ":
			randomWord = "づけまぐろ";
			break;
		case "で":
			randomWord = "デリバリーサービス";
			break;
		case "ど":
			randomWord = "ドバイ在住";
			break;
		case "ば":
			randomWord = "バーチャルデータ";
			break;
		case "び":
			randomWord = "びっくりくりくりくりっくりっ！";
			break;
		case "ぶ":
			randomWord = "ブーバー";
			break;
		case "べ":
			randomWord = "紅芋タルト";
			break;
		case "ぼ":
			randomWord = "冒険王ルフィ";
			break;
		case "ぱ":
			randomWord = "パロディアス";
			break;
		case "ぴ":
			randomWord = "ピーナッツ戦法";
			break;
		case "ぷ":
			randomWord = "ぷっちょチャップス";
			break;
		case "ぺ":
			randomWord = "PayPay";
			break;
		case "ぽ":
			randomWord = "ぽっとべとる";
			break;
		case "ら":
			randomWord = "らりりりりりるーーー";
			break;
		case "り":
			randomWord = "利便制の追求";
			break;
		case "る":
			randomWord = "るーるる♪るるる♪";
			break;
		case "れ":
			randomWord = "れれれのれー♪";
			break;
		case "ろ":
			randomWord = "ロールケーキ買った";
			break;

		}

		return randomWord;
	}

}
