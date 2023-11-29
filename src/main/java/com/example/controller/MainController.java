package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.BadChat;
import com.example.entity.GoodChat;
import com.example.service.LoginUser;
import com.example.service.MainService;

@Controller
@RequestMapping("/main")
public class MainController {
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public String main(Model model) {
        List<GoodChat> goodchats = this.mainService.findgoodchatRandom();
        model.addAttribute("goodchats", goodchats);
        List<BadChat> badchats = this.mainService.findBadchatRandom();
        model.addAttribute("badchats", badchats);
        System.out.println(goodchats.toString());
//        System.out.println(badchats.get(0));
        return "/chats/mainPage";
    }
    
//    @PostMapping("/goodCount")
//    public String goodCount(Integer id) {
//    	this.mainService.choice_good_update(id);
//    	return "redirect:/item";
//    }
    
    @GetMapping("/countGood")
    public String goodCount(@AuthenticationPrincipal LoginUser loginUser) {
		System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲");
		System.out.println("user_id: " + loginUser.getUser().getId());
		System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲");
    	this.mainService.choice_good_update(loginUser.getUser().getId());
    	return "redirect:/main/good";
    }
    
    @GetMapping("/countBad")
    public String badCount(@AuthenticationPrincipal LoginUser loginUser) {
		System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲");
		System.out.println("user_id: " + loginUser.getUser().getId());
		System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲");
    	this.mainService.choice_good_update(loginUser.getUser().getId());
    	return "redirect:/main/bad";
    }
    
    
}
