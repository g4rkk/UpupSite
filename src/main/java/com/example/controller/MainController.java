package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.BadChat;
import com.example.entity.GoodChat;
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
        System.out.println(goodchats.get(0));
        System.out.println(badchats.get(0));
        return "mainPage";
    }
    
    @PostMapping("/goodCount")
    public String goodCount(Integer id) {
    	this.mainService.choise_good_update(id);
    	return "redirect:/item";
    }
    
    @PostMapping("/badCount")
    public String badCount(Integer id) {
    	this.mainService.choise_bad_update(id);
    	return "redirect:/item";
    }
    
    
}
