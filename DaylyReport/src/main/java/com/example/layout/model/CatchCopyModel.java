package com.example.layout.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.layout.config.CatchCopyConfig;

/**
 * キャッチコピーモデル
 */
@Component
public class CatchCopyModel {
	@Autowired
	CatchCopyConfig catchCopyConfig;
	
	/**
	 * キャッチコピーを取得する「
	 * @return キャッチコピー
	 */
	public String getCatchCopy() {
		int length;
		length = catchCopyConfig.getCatchcopy().size();

		// 表示するメッセージ番号をランダムに決める
		Random random = new Random();
		int index = random.nextInt(length);

		return catchCopyConfig.getCatchcopy().get(index);
	}
}
