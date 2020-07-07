package com.example.layout.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.layout.config.LogoConfig;
import com.example.layout.config.TitleConfig;

/**
 * タイトルモデル
 */
@Component
public class TitleModel {

	@Autowired
	TitleConfig titleConfig;

	public String getTitle() {
		int length;
		length = titleConfig.getTitle().size();

		// 表示するメッセージ番号をランダムに決める
		Random random = new Random();
		int index = random.nextInt(length);

		return titleConfig.getTitle().get(index);
	}
}
