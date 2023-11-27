package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.model.RegistrationForm;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void registerUser(RegistrationForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        // 其他字段的转换
        userMapper.insertUser(user);
    }
}
