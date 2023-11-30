package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.BadChat;
import com.example.entity.GoodChat;


@Mapper
public interface MainMapper {
    public List<GoodChat> findGoodchatRandom();
    public List<BadChat> findBadchatRandom();
    public  void choice_good_update(Integer id);
    public  void choice_bad_update(Integer id);
	public void choice_good_update1(Integer id);
}