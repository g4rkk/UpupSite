package com.example.service;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginUserPrincipalService {
	public LoginUser getLoginUserPrincipal(Principal principal) {
		/**
		 * 
		 * WebSocketのメッセージハンドラ内で認証情報（LoginUser）を取得するにはPrincipalを使用する必要がある
		 * 
		 */
		Authentication authentication = (Authentication) principal;
		Object userDetails = authentication.getPrincipal();
		LoginUser loginUser = (LoginUser) userDetails;
		
		return loginUser;
	}
}
