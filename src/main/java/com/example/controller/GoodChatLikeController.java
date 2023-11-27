package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.GoodChatLike;
import com.example.form.LikeForm;
import com.example.service.GoodChatLikeService;
import com.example.service.LoginUser;
import com.example.service.LoginUserPrincipalService;

@Controller
@RequestMapping("/main/good/chat/like")
public class GoodChatLikeController {
	private final GoodChatLikeService goodChatLikeService;
	private final LoginUserPrincipalService loginUserPrincipalService;
	
	@Autowired
	public GoodChatLikeController(GoodChatLikeService goodChatLikeService, LoginUserPrincipalService loginUserPrincipalService) { 
		this.goodChatLikeService = goodChatLikeService;
		this.loginUserPrincipalService = loginUserPrincipalService;
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	public GoodChatLike addLike(@RequestBody LikeForm likeForm, Principal principal) {
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodChatLike insertGoodChatLikeData = this.goodChatLikeService.insert(likeForm, loginUser);
		
		return insertGoodChatLikeData;
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public GoodChatLike deleteLike(@RequestBody LikeForm likeForm, Principal principal) {
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodChatLike deleteGoodChatLikeData = this.goodChatLikeService.delete(likeForm, loginUser);
		
		return deleteGoodChatLikeData;
	}
}
