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

		return "chats/good";
	}
	
	@MessageMapping("/main/good/chat")
	@SendTo("/topic/messages")
	public GoodChat sendChatMessage(MessageForm messageForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		GoodChat insertGoodChatData = this.goodChatService.insert(messageForm, loginUser);
		
		if (loginUser.getUser().getId() == insertGoodChatData.getUserId()) {
			insertGoodChatData.setLoggedUserFlag(1);
		} else {
			insertGoodChatData.setLoggedUserFlag(0);
		}
		
		return insertGoodChatData;
	}
}

