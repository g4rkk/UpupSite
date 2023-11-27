package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.GoodReply;
import com.example.form.DeleteForm;
import com.example.form.MessageForm;
import com.example.service.GoodReplyService;
import com.example.service.LoginUser;
import com.example.service.LoginUserPrincipalService;

@Controller
@RequestMapping("/main")
public class GoodReplyController {
	private final GoodReplyService goodReplyService;
	private final LoginUserPrincipalService loginUserPrincipalService;
	
	@Autowired
	public GoodReplyController(GoodReplyService goodReplyService, LoginUserPrincipalService loginUserPrincipalService) { 
		this.goodReplyService = goodReplyService;
		this.loginUserPrincipalService = loginUserPrincipalService;
	}
	
	@MessageMapping("/main/good/reply")
	@SendTo("/topic/messages")
	public GoodReply sendReplyMessage(MessageForm messageForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodReply insertGoodReplyData = this.goodReplyService.insert(messageForm, loginUser);
		insertGoodReplyData.setTypeMessage("reply");
		
		return insertGoodReplyData;
	}
	
	@MessageMapping("/main/good/reply/delete")
	@SendTo("/topic/deleteMessage")
	public GoodReply replyDelete(DeleteForm deleteForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodReply softDeleteData = this.goodReplyService.softDelete(deleteForm, loginUser);
		softDeleteData.setTypeMessage("reply");
		
		return softDeleteData;
	}
}
