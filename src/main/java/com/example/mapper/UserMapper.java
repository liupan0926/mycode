package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User Sel(int id);
    
    /**
     * 
     * @param user
     * @return
     */
    Integer insertUser(User user);
}
