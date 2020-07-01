package com.example.demo.Service;

import com.example.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{

    User findByUsername(String username);

    //查找所有
    List<User> findAll();

    void save(User user);

    void delete(User user);
}
