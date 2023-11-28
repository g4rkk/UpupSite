package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.BadReplyLike;
import com.example.form.LikeForm;
import com.example.service.BadReplyLikeService;
import com.example.service.LoginUser;
import com.example.service.LoginUserPrincipalService;

@Controller
@RequestMapping("/main/bad/reply/like")
public class BadReplyLikeController {
	
	private final BadReplyLikeService badReplyLikeService;
	private final LoginUserPrincipalService loginUserPrincipalService;
	
	@Autowired
	public BadReplyLikeController(BadReplyLikeService badReplyLikeService, LoginUserPrincipalService loginUserPrincipalService) { 
		this.badReplyLikeService = badReplyLikeService;
		this.loginUserPrincipalService = loginUserPrincipalService;
	}
	
	@PostMapping("/add")
	@ResponseBody
	public BadReplyLike addLike(@RequestBody LikeForm likeForm, Principal principal) {
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		BadReplyLike insertBadReplyLikeData = this.badReplyLikeService.insert(likeForm, loginUser);
		
		return insertBadReplyLikeData;
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public BadReplyLike deleteLike(@RequestBody LikeForm likeForm, Principal principal) {
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		BadReplyLike deleteBadReplyLikeData = this.badReplyLikeService.delete(likeForm, loginUser);
		
		return deleteBadReplyLikeData;
	}
}
