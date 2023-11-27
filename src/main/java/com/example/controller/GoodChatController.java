package com.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.GoodChat;
import com.example.form.DeleteForm;
import com.example.form.MessageForm;
import com.example.service.GoodChatService;
import com.example.service.LoginUser;
import com.example.service.LoginUserPrincipalService;

@Controller
@RequestMapping("/main")
public class GoodChatController {
	private final GoodChatService goodChatService;
	private final LoginUserPrincipalService loginUserPrincipalService;
	
	@Autowired
	public GoodChatController(GoodChatService goodChatService, LoginUserPrincipalService loginUserPrincipalService) { 
		this.goodChatService = goodChatService;
		this.loginUserPrincipalService = loginUserPrincipalService;
	}
	
	
	@GetMapping("/good")
	public String index(@ModelAttribute MessageForm messageForm, Model model, @AuthenticationPrincipal LoginUser loginUser) {
		List<GoodChat> goodChats = this.goodChatService.findAll();
		model.addAttribute("goodChats", goodChats);
		model.addAttribute("loginUserId", loginUser.getUser().getId());

		return "chats/good";
	}
	
	@MessageMapping("/main/good/chat")
	@SendTo("/topic/messages")
	public GoodChat sendChatMessage(MessageForm messageForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodChat insertGoodChatData = this.goodChatService.insert(messageForm, loginUser);
		insertGoodChatData.setTypeMessage("chat");
		
		return insertGoodChatData;
	}
	
	@MessageMapping("/main/good/chat/delete")
	@SendTo("/topic/deleteMessage")
	public GoodChat chatDelete(DeleteForm deleteForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodChat softDeleteData = this.goodChatService.softDelete(deleteForm, loginUser);
		softDeleteData.setTypeMessage("chat");
		
		return softDeleteData;
	}
}

