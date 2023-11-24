package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.mapper.UserMapper;

@Service
public class LoginUserService implements UserDetailsService {
	
	private final UserMapper userMapper;
	
	@Autowired
	public LoginUserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userMapper.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("ユーザーが見つかりません");
		}
		
		return new LoginUser(user);
	}
}
