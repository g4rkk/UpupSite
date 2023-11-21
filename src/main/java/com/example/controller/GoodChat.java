package com.example.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.MessageForm;

@Controller
@RequestMapping("/main")
public class GoodChat {
	
	@GetMapping("/good")
	public String index(@ModelAttribute MessageForm messageForm) {
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
