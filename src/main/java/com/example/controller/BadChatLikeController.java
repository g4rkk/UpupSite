package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.BadChatLike;
import com.example.form.LikeForm;
import com.example.service.BadChatLikeService;
import com.example.service.LoginUser;
import com.example.service.LoginUserPrincipalService;

@Controller
@RequestMapping("/main/bad/chat/like")
public class BadChatLikeController {

	private final BadChatLikeService badChatLikeService;
	private final LoginUserPrincipalService loginUserPrincipalService;
	
	@Autowired
	public BadChatLikeController(BadChatLikeService badChatLikeService, LoginUserPrincipalService loginUserPrincipalService) { 
		this.badChatLikeService = badChatLikeService;
		this.loginUserPrincipalService = loginUserPrincipalService;
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	public BadChatLike addLike(@RequestBody LikeForm likeForm, Principal principal) {
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		BadChatLike insertBadChatLikeData = this.badChatLikeService.insert(likeForm, loginUser);
		
		return insertBadChatLikeData;
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public BadChatLike deleteLike(@RequestBody LikeForm likeForm, Principal principal) {
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		BadChatLike deleteBadChatLikeData = this.badChatLikeService.delete(likeForm, loginUser);
		
		return deleteBadChatLikeData;
	}
}
