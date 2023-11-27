package com.example.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegistrationForm {

    @NotEmpty(message = "ユーザー名は空欄ではありません")
    private String username;

    @Email(message = "メールアドレスを入力してください")
    @NotEmpty(message = "メールアドレスは空欄ではありません")
    private String email;

    @Size(min = 6, message = "パスワードを入力してください")
    private String password;

	public Object getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public String getEmail() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    // Getter和Setter方法
    // ...
}
