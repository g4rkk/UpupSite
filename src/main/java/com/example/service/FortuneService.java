package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Fortune;
import com.example.entity.User;
import com.example.mapper.FortuneMapper;
import com.example.mapper.UserMapper;

@Service
public class FortuneService {
    
    private final FortuneMapper fortuneMapper;
    private final UserMapper userMapper;

    @Autowired
    public FortuneService(FortuneMapper fortuneMapper, UserMapper userMapper) {
        this.fortuneMapper = fortuneMapper;
        this.userMapper = userMapper;
    }

    public List<Fortune> findAll() {
        return fortuneMapper.findAll();
    }
    
    public void update(Integer id, Integer money, Integer job, Integer love) {
        User user = new User(); 
        user.setId(id);
        user.setMoney(money);
        user.setJob(job); // 修改为正确的setter
        user.setLove(love); // 修改为正确的setter
        this.userMapper.updateFortune(user); // 应该是一个存在的方法，如updateFortune
    }
}
