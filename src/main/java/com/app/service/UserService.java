package com.app.service;

import com.app.dao.UserDAO;
import com.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lucky on 2017/12/20.
 */
@Service
@EnableAutoConfiguration
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void addNewUser(User user) {
        userDAO.insertByUser(user);
    }

    public List<User> getAllUser() {
        return userDAO.findAll();
    }
}
