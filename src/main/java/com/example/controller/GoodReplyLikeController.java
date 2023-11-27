package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.GoodReplyLike;
import com.example.form.LikeForm;
import com.example.service.GoodReplyLikeService;
import com.example.service.LoginUser;
import com.example.service.LoginUserPrincipalService;

@Controller
@RequestMapping("/main/good/reply/like")
public class GoodReplyLikeController {

	private final GoodReplyLikeService goodReplyLikeService;
	private final LoginUserPrincipalService loginUserPrincipalService;
	
	@Autowired
	public GoodReplyLikeController(GoodReplyLikeService goodReplyLikeService, LoginUserPrincipalService loginUserPrincipalService) { 
		this.goodReplyLikeService = goodReplyLikeService;
		this.loginUserPrincipalService = loginUserPrincipalService;
	}
	
	@PostMapping("/add")
	@ResponseBody
	public GoodReplyLike addLike(@RequestBody LikeForm likeForm, Principal principal) {
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodReplyLike insertGoodReplyLikeData = this.goodReplyLikeService.insert(likeForm, loginUser);
		
		return insertGoodReplyLikeData;
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public GoodReplyLike deleteLike(@RequestBody LikeForm likeForm, Principal principal) {
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodReplyLike deleteGoodReplyLikeData = this.goodReplyLikeService.delete(likeForm, loginUser);
		
		return deleteGoodReplyLikeData;
	}
}
