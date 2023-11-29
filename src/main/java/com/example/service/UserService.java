package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.form.UserForm;
import com.example.mapper.UserMapper;

@Service
public class UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	private final LoginUserService loginUserService;
	 private final AuthenticationManager authenticationManager;
	 
	
    @Autowired
    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder, LoginUserService loginUserService, AuthenticationManager authenticationManager) {
    	this.userMapper = userMapper;
    	this.passwordEncoder = passwordEncoder;
    	this.loginUserService = loginUserService;
    	this.authenticationManager = authenticationManager;
    }


    public void registerUser(UserForm userForm) {
    	User user = new User();
    	user.setEmail(userForm.getEmail());
    	user.setPassword(passwordEncoder.encode(userForm.getPassword()));
    	user.setName(userForm.getName());
    	
        this.userMapper.registerUser(user);
        
        loginAfterRegistration(user.getEmail(), userForm.getPassword());
    }
    
    public void loginAfterRegistration(String email, String rawPassword) {
    	UserDetails userDetails = loginUserService.loadUserByUsername(email);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, rawPassword, userDetails.getAuthorities());
        Authentication authenticated = authenticationManager.authenticate(authentication);

        if (authenticated.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticated);
        }
    }
}
