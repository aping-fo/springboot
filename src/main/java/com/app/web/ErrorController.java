package com.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lucky on 2017/12/19.
 */
@Controller
public class ErrorController {

    /**
     * 显示创建用户表单
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String createUserForm(ModelMap map) {
        return "userForm";
    }
}
