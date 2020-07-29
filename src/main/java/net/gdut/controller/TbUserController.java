package net.gdut.controller;

import net.gdut.bean.Paging;
import net.gdut.bean.TbBook;
import net.gdut.bean.TbUser;
import net.gdut.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TbUserController {

    @Resource
    TbUserService tbUserService;

    @GetMapping("/regist")
    public String userRegist(){
        return "regist";
    }

    @GetMapping("/toLogin")
    public String userLogin(){
        return "home";
    }

    @PostMapping("/login")
    public String login(String uname,String password){
        TbUser user = tbUserService.getUser(uname);
        //用户不存在
        if(user==null){
            return "login/error";
        }
        //密码错误
        else if(!user.getPassword().equals(password)){
            return "login/error";
        }
        //成功登录用户页面
        else if(user.getAuthority().equals("user")){
            return "login/userSuccess";
        }
        //成功登录管理员页面
        else{
            return "login/adminSuccess";
        }
    }

    @PostMapping("/addUser")
    public String addUser(TbUser tbUser){
        tbUserService.addUser(tbUser);
        return "result";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(TbUser tbUser){
    tbUserService.addAdmin(tbUser);
    return "result";
    }

    @GetMapping("/allbook")
    public String getAllBook(@RequestParam Integer page, HttpServletRequest request){
        //Integer page=0;
        Integer count=4;
        Paging paging = new Paging(page,count);
        List<TbBook> books = tbUserService.getAllBook(paging);
        request.setAttribute("books",books);
        books.forEach(System.out::println);
        return "user";
    }

}
