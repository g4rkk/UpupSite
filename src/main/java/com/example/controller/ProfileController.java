package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Profile;
import com.example.service.ProfileService;

@Controller
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profile/{id}")
    public String getProfile(@PathVariable("id") Integer id, Model model) {
        Profile profile = profileService.getProfile(id);
        if (profile == null) {
            // Option 1: Redirect to an error page
            // return "redirect:/error-page";

            // Option 2: Set default values
            profile = new Profile();
            profile.setName("Unknown");
            // Set other default values as needed...
        }
        model.addAttribute("profile", profile);
        return "profile";
    }
}
