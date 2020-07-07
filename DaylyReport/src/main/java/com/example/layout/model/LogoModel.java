package com.example.layout.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.layout.config.LogoConfig;

/**
 * ロゴモデル
 */
@Component
public class LogoModel {

	@Autowired
	LogoConfig logoConfig;

	public String getLogoUrl() {
		int length;
		length = logoConfig.getLogo().size();

		// 表示するメッセージ番号をランダムに決める
		Random random = new Random();
		int index = random.nextInt(length);

		return logoConfig.getLogo().get(index);
	}
}
