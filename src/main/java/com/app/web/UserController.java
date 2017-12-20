package com.app.web;

import com.app.domain.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lucky on 2017/12/20.
 */
@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在 /users
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add_user", method = {RequestMethod.GET})
    public String addNewUser() {
        User user = new User();
        user.setAge(10);
        user.setId(10L);
        user.setName("mybatis");

        userService.addNewUser(user);

        return "success";
    }

    @RequestMapping(value = "/user_list", method = {RequestMethod.GET})
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
