package net.gdut.controller;

import net.gdut.bean.User;
import net.gdut.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

//帐号管理控制器
@Controller
@RequestMapping("/user")
public class UserManagerController {
    @Resource
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "login/addresult";
    }
}
