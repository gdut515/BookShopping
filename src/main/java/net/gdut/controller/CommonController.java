package net.gdut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
    //当用户无权限时跳转的页面
    @RequestMapping("/noPermission")
    public String noPermission(Model model) {
        model.addAttribute("message", "您无权访问该页面");
        return "commons/error";
    }
}
