package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.mapper.UserMapper;

@Service
public class SettingService {
    private final UserMapper userMapper;

    @Autowired
    public  SettingService(UserMapper userMapper) {
        this. userMapper = userMapper;
    }
 
    public User findById(Integer id) {
     return this.userMapper.findById(id);
      }
    
    public void update(Integer id, String name,String image, String motivation) {
    this.userMapper.update(id,name,image,motivation);
     }
}