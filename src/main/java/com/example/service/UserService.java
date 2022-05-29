package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User Sel(int id) {
        return userMapper.Sel(id);
    }

    public Integer InsertUser(User user) {

        try {
            Integer userId = userMapper.insertUser(user);
            return userId;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 100;
    }

}
