package net.gdut.controller;

import net.gdut.bean.TbUser;
import net.gdut.mapper.TbUserMapper;
import net.gdut.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class TbUserController {

    @Resource
    TbUserService tbUserService;

    @GetMapping("/regist")
    public String userRegist(){
        return "regist";
    }

    @PostMapping("/addUser")
    public String addUser(TbUser tbUser){
        tbUserService.addUser(tbUser);
        return "result";
    }

    //尚未提供可供jsp调用的/addAdmin方法

//    @GetMapping("/all")
//    public String getAllStudent(HttpServletRequest request){
//        List<TbStudent> studentList = studentMapper.getAllStudentInfo();
//        request.setAttribute("students",studentList);
//        return "allStudent";
//    }
}
