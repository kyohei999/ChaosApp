package com.example.demo.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserDto {
	/** Id */
	private String id;
	/** 名前 */
	private String name;
	/** 年齢 */
	private String age;

}
