package com.example.demo.entity;

import lombok.Data;

/**
 * このクラスは料理に関する情報の保持を行います。
 *
 * @author Mori
 */

@Data
public class Food {
	/** Id */
	private int food_id;
	/** 名前 */
	private String food;
	/** 年齢 */
	private int type_id;
}
