package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @GetMapping("/profile/updateCounts/{id}")
    public ResponseEntity<?> updateCounts(@PathVariable("id") Integer id, 
            @RequestParam("good") Integer goodCount, 
            @RequestParam("bad") Integer badCount) {
try {
boolean updated = profileService.updateGoodBadCount(id, goodCount, badCount);
if (updated) {
return ResponseEntity.ok().body("{\"success\": true}");
} else {
return ResponseEntity.badRequest().body("{\"success\": false, \"message\": \"Update failed\"}");
}
} catch (Exception e) {
// 日志记录异常 e
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"success\": false, \"message\": \"Internal server error\"}");
}
}
    
}

