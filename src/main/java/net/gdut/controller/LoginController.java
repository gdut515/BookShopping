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
public class LoginController {

    @Resource
    TbUserService tbUserService;

    @GetMapping("/regist")
    public String userRegist(){
        return "regist";
    }

    @GetMapping("/toLogin")
    public String userLogin(){
        return "login/login";
    }

    @PostMapping("/login")
    public String login(String uname,String password,HttpServletRequest request){
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
            request.setAttribute("uno",user.getUno());
            return "login/userSuccess";
        }
        //成功登录管理员页面
        else{
            return "redirect:/admin/book/getAllBook";
        }
    }

    @PostMapping("/addUser")
    public String addUser(TbUser tbUser){
        tbUserService.addUser(tbUser);
        return "addresult";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(TbUser tbUser){
    tbUserService.addAdmin(tbUser);
    return "result";
    }

    @GetMapping("/allbook")
    public String getAllBook(@RequestParam(required=true,defaultValue = "0")Integer page,
                             @RequestParam Integer uno, HttpServletRequest request){
        //Integer page=0;
        Integer count=4;
        Paging paging = new Paging(page,count);
        List<TbBook> books = tbUserService.getAllBook(paging);
        request.setAttribute("books",books);
        request.setAttribute("uno",uno);
        books.forEach(System.out::println);
        return "user";
    }

}