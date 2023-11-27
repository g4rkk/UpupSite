package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.BadReply;
import com.example.form.DeleteForm;
import com.example.form.MessageForm;
import com.example.service.BadReplyService;
import com.example.service.LoginUser;
import com.example.service.LoginUserPrincipalService;

@Controller
@RequestMapping("/main")
public class BadReplyController {
	
	private final BadReplyService badReplyService;
	private final LoginUserPrincipalService loginUserPrincipalService;
	
	@Autowired
	public BadReplyController(BadReplyService badReplyService, LoginUserPrincipalService loginUserPrincipalService) { 
		this.badReplyService = badReplyService;
		this.loginUserPrincipalService = loginUserPrincipalService;
	}
	
	@MessageMapping("/main/bad/reply")
	@SendTo("/topic/messages")
	public BadReply sendReplyMessage(MessageForm messageForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		BadReply insertBadReplyData = this.badReplyService.insert(messageForm, loginUser);
		insertBadReplyData.setTypeMessage("reply");
		
		return insertBadReplyData;
	}
	
	@MessageMapping("/main/bad/reply/delete")
	@SendTo("/topic/deleteMessage")
	public BadReply replyDelete(DeleteForm deleteForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		BadReply softDeleteData = this.badReplyService.softDelete(deleteForm, loginUser);
		softDeleteData.setTypeMessage("reply");
		
		return softDeleteData;
	}
}
