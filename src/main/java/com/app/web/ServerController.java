package com.app.web;

import com.app.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lucky on 2017/12/19.
 */
@RestController
@RequestMapping(value = "/servers")     // 通过这里配置使下面的映射都在 /users
public class ServerController {
    @Autowired
    ServerService serverService;
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public List<Integer> getUserList(@PathVariable long id) {
        System.out.println(id);
        int count = serverService.getAllUsers();
        return Arrays.asList(1, 1, 1, 1);
    }

    /**
     * 显示创建用户表单
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUserForm(ModelMap map) {
        map.addAttribute("action", "create");
        return "userForm";
    }
}
