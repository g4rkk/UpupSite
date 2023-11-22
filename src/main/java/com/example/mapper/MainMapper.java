package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.BadChat;
import com.example.entity.GoodChat;


@Mapper
public interface MainMapper {
    public List<GoodChat> findGoodchatRandom();
    public List<BadChat> findBadchatRandom();
    
}