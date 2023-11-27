package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.LoginUser;
import com.example.service.SettingService;

@Controller
@RequestMapping()
public class SettingController {
    private final SettingService settingService;

    @Autowired
    public SettingController(SettingService settingService) {
        this.settingService = settingService ;
    }
    
    @GetMapping("/edit")
     public String showEdit(@AuthenticationPrincipal LoginUser loginUser, Model model) {
    	User user = this.settingService.findById(loginUser.getUser().getId());
    	model.addAttribute("user", user);
    	return "edit";
      }
    
     @PostMapping("/edit")
     public String edit(@AuthenticationPrincipal LoginUser loginUser, String name,String image, String motivation) {
    	 System.out.println(name);
     this.settingService.update(loginUser.getUser().getId(), name, image, motivation);
     return "redirect:/main";
      }
}