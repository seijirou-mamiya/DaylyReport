package com.example.layout.form;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * ログインフォーム
 */
@Data
public class LoginForm{
	@NotBlank(message = "ログイン名を入力してください")
	private String loginUserName;

	@NotBlank(message = "パスワードを入力してください")
	private String loginPassWord;
}