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
        return profileMapper.getUserProfileById(id);
    }
}
