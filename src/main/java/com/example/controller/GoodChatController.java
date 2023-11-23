package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.GoodChat;
import com.example.form.MessageForm;
import com.example.service.GoodChatService;

@Controller
@RequestMapping("/main")
public class GoodChatController {
	private final GoodChatService goodChatService;
	
	@Autowired
	public GoodChatController(GoodChatService goodChatService) { 
		this.goodChatService = goodChatService;
	}
	
	
	@GetMapping("/good")
	public String index(@ModelAttribute MessageForm messageForm, Model model) {
		List<GoodChat> goodChats = this.goodChatService.findAll();
		
		model.addAttribute("goodChats", goodChats);
		return "chats/good";
	}
	
	@MessageMapping("/main/good/chat")
	@SendTo("/topic/messages")
	public MessageForm sendChatMessage(MessageForm messageForm) {
		/**
		 * 
		 * ここにDBの処理を書く
		 * 
		 */
		
		System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲");
		System.out.println(messageForm.getMessage());
		System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲");
		
		/**
		 * 条件分岐でログインユーザーと、登録したメッセージのユーザーIDが一致した場合は
		 * messageForm.setLoggedUserFlag(1);
		 * 
		 * 一致しない場合は
		 * messageForm.setLoggedUserFlag(0);
		 */
		
		messageForm.setLoggedUserFlag(0);
		return messageForm;
	}
	
	@MessageMapping("/main/good/reply")
	@SendTo("/topic/messages")
	public String sendReplyMessage(String message) {
		/**
		 * ここに返信に必要なDB処理
		 */
		return message;
	}
	
	
	
	
	/**
	 * 
	 * @param messageForm
	@PostMapping("/good/message")
	public void message(@ModelAttribute MessageForm messageForm) {
		System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲");
		System.out.println(messageForm.getMessage());
		System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲");
	}
	 */
}

