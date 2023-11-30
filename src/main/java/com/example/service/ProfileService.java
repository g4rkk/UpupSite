package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Profile;
import com.example.mapper.ProfileMapper;

@Service
public class ProfileService {
    private final ProfileMapper profileMapper;

    @Autowired
    public ProfileService(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    public Profile getProfile(Integer id) {
    	Profile profile = this.profileMapper.getUserProfileById(id);
    	
        return profile;
    }
    
    public boolean updateGoodBadCount(Integer id, Integer goodCount, Integer badCount) {
        try {
            profileMapper.updateGoodBadCount(id, goodCount, badCount);
            return true;
        } catch (Exception e) {
            // 日志记录异常 e
            return false;
        }
    }

}

