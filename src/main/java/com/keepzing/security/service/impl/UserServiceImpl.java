package com.keepzing.security.service.impl;

import com.keepzing.security.bean.User;
import com.keepzing.security.dao.UserDao;
import com.keepzing.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.selectUserByUsername(username);
    }
}
