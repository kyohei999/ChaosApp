package com.example.demo.entity;

import lombok.Data;

/**
 * このクラスは料理に関する情報の保持を行います。
 *
 * @author Mori
 */

@Data
public class Type {
	/** Id */
	private int type_id;
	/** 名前 */
	private String type;

}
