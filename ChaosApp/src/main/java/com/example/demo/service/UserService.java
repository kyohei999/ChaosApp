package com.example.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserDto;

@Service
public class UserService {
	@Autowired
	private UserDto userdto;

	/** カンマ */
	private static final String COMMA = ",";
	/** 改行コード */
	private static final String NEW_LINE = "\r\n";

	public HashMap<String, ArrayList<UserDto>> getUser() throws IOException {
		FileInputStream fileInput;
		fileInput = new FileInputStream("src/main/resources/json_users.csv");
		InputStreamReader inputStream = new InputStreamReader(fileInput);
		BufferedReader br = new BufferedReader(inputStream);
		ArrayList<UserDto> userList = new ArrayList<UserDto>();
		String line;
		while ((line = br.readLine()) != null) {
			String[] userData = line.split(",", 0);
			userdto = new UserDto();
			userdto.setId(userData[0]);
			userdto.setName(userData[1]);
			userdto.setAge(userData[2]);
			userList.add(userdto);
		}

		HashMap<String, ArrayList<UserDto>> jsonUser = new HashMap<String, ArrayList<UserDto>>();
		jsonUser.put("users", userList);
		br.close();
		return jsonUser;
	}

	public void insertUser(String userId, String userName, String userAge) {
		FileWriter fw = null;
		try {
			File file = new File("src/main/resources/json_users.csv");
			fw = new FileWriter(file, true);
			fw.write(userId + COMMA);
			fw.write(userName + COMMA);
			fw.write(userAge + COMMA);
			fw.write(NEW_LINE);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.flush();
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteUser(String userId) {
		FileWriter fw = null;
		try {
			//ファイルの読み込み、編集をを行い、再書き込み書き込みを行う
			//DB使用しないと実装が困難
			FileInputStream fileInput;
			fileInput = new FileInputStream("src/main/resources/json_users.csv");
			InputStreamReader inputStream = new InputStreamReader(fileInput);
			BufferedReader br = new BufferedReader(inputStream);
			String line;
			String[] userData = null;

			//ループ処理でファイルから取得
			ArrayList<String> userList = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				userData = line.split(",", 0);
				if (userData[0].equals(userId)) {
					continue;
				}

				userList.add(userData[0]);
				userList.add(userData[1]);
				userList.add(userData[2]);
			}
			br.close();

			//書き込み
			File file = new File("src/main/resources/json_users.csv");
			fw = new FileWriter(file);
			for (int i = 0; i < userList.size(); i+=3 ) {
				fw.write(userList.get(i) + COMMA);
				fw.write(userList.get(i + 1) + COMMA);
				fw.write(userList.get(i + 2) + NEW_LINE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.flush();
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}