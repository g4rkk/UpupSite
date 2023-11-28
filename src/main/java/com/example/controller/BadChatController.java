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

import com.example.entity.BadChat;
import com.example.form.DeleteForm;
import com.example.form.MessageForm;
import com.example.service.BadChatService;
import com.example.service.LoginUser;
import com.example.service.LoginUserPrincipalService;

@Controller
@RequestMapping("/main")
public class BadChatController {
	private final BadChatService badChatService;
	private final LoginUserPrincipalService loginUserPrincipalService;
	
	@Autowired
	public BadChatController(BadChatService badChatService, LoginUserPrincipalService loginUserPrincipalService) { 
		this.badChatService = badChatService;
		this.loginUserPrincipalService = loginUserPrincipalService;
	}
	
	
	@GetMapping("/bad")
	public String index(@ModelAttribute MessageForm messageForm, Model model, @AuthenticationPrincipal LoginUser loginUser) {
		List<BadChat> badChats = this.badChatService.findAll();
		model.addAttribute("badChats", badChats);
		model.addAttribute("loginUserId", loginUser.getUser().getId());

		return "chats/bad";
	}
	
	@MessageMapping("/main/bad/chat")
	@SendTo("/topic/messages")
	public BadChat sendChatMessage(MessageForm messageForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		BadChat insertBadChatData = this.badChatService.insert(messageForm, loginUser);
		insertBadChatData.setTypeMessage("chat");
		
		return insertBadChatData;
	}
	
	@MessageMapping("/main/bad/chat/delete")
	@SendTo("/topic/deleteMessage")
	public BadChat chatDelete(DeleteForm deleteForm, Principal principal) {
		
		LoginUser loginUser = this.loginUserPrincipalService.getLoginUserPrincipal(principal);
		BadChat softDeleteData = this.badChatService.softDelete(deleteForm, loginUser);
		softDeleteData.setTypeMessage("chat");
		
		return softDeleteData;
	}
}
