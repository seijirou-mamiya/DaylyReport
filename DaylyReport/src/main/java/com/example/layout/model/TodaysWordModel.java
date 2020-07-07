package com.example.layout.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.layout.config.TodaysWordConfig;

/**
 * 今日のひとことモデル
 */
@Component
public class TodaysWordModel {

	@Autowired
	TodaysWordConfig todaysWordConfig;
	
	/**
	 * 今日の一言を取得する「
	 * @return 今日のひとこと
	 */
	public String getTodaysWord() {
		int length;
		length = todaysWordConfig.getTodays_word().size();

		// 表示するメッセージ番号をランダムに決める
		Random random = new Random();
		int index = random.nextInt(length);

		return todaysWordConfig.getTodays_word().get(index);
	}
}
