package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.UserForm;
import com.example.model.RegistrationForm;
import com.example.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
    	this.userService = userService;
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(RegistrationForm registrationForm, UserForm userForm, Model model) {
    	model.addAttribute("registrationForm", registrationForm);
    	model.addAttribute("userForm", userForm);
        return "registerform";
    }
    
    @PostMapping("/register")
    public String registerUser(UserForm userForm, Model model) {
    	try {
    		userService.registerUser(userForm);
            return "redirect:/main";
    	} catch (Exception e) {
    		 model.addAttribute("error",  "このメールアドレスは既に登録されています。");
             return "registerForm";
    	}
    }

}
