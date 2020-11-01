package net.gdut.controller;

import net.gdut.bean.User;
import net.gdut.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/toUser")
    public String toUser(HttpSession session){
        List<User> users = userService.getAllUsers();
        session.setAttribute("users",users);
        return "user/user";
    }

    //移出用户
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "uno")Integer uno){
        userService.deleteUser(uno);
        return "redirect:/user/toUser";
    }
}
