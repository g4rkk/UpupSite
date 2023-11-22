package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Fortune;
import com.example.mapper.FortuneMapper;

@Service
public class FortuneService {
    
    private final FortuneMapper fortuneMapper;

    @Autowired
    public FortuneService(FortuneMapper fortuneMapper) {
        this.fortuneMapper = fortuneMapper;
    }

    public List<Fortune> findAll() {
        return fortuneMapper.findAll();
    }
}
