package com.example.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.FortuneService;
import com.example.service.LoginUser;

@Controller
public class FortuneController {

    private final FortuneService fortuneService;

    @Autowired
    public FortuneController(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @GetMapping("/fortune")
    public String fortune(@AuthenticationPrincipal LoginUser loginUser, Model model) {
        int MONEY = ThreadLocalRandom.current().nextInt(50, 101);
        int JOB = ThreadLocalRandom.current().nextInt(50, 101);
        int LOVE = ThreadLocalRandom.current().nextInt(50, 101);

        model.addAttribute("moneyLuck", MONEY);
        model.addAttribute("workLuck", JOB);
        model.addAttribute("loveLuck", LOVE);
        
        this.fortuneService.update(loginUser.getUser().getId(), MONEY, JOB, LOVE);

        return "fortune";
    }

	public FortuneService getFortuneService() {
		return fortuneService;
	}
	
}
