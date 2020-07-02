package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserRoleRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("用户名不能为空");
        }
        User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //获取角色列表
        List<UserRole> userRoles = userRoleRepository.findByUserId(user.getId());
        if (userRoles != null && !userRoles.isEmpty()) {
            List<Long> roleIds = new ArrayList<>();
            for (UserRole userRole : userRoles) {
                roleIds.add(userRole.getRoleId());
            }
            List<Role> roles = roleRepository.findByIdIn(roleIds);
            user.setRoleList(roles);
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
