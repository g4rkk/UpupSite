package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BadChat;
import com.example.entity.GoodChat;
import com.example.mapper.MainMapper;

@Service
public class MainService {
    private final MainMapper mainMapper;

    @Autowired
    public MainService(MainMapper mainMapper) {
        this.mainMapper = mainMapper;
    }

    public List<GoodChat> findgoodchatRandom() {
        return this.mainMapper.findGoodchatRandom();
    }
    
    public List<BadChat> findBadchatRandom() {
        return this.mainMapper.findBadchatRandom();
    }
}
