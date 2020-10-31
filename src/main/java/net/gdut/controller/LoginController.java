package net.gdut.controller;

import net.gdut.bean.User;
import net.gdut.service.UserService;
import net.gdut.utils.CookieUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录管理控制器
@Controller
public class LoginController {
    @Resource
    UserService userService;

    @GetMapping("/toRegist")
    public String userRegist(){
        return "login/regist";
    }

    @GetMapping("/toLogin")
    public String userLogin(){
        return "login/login";
    }

    //用shiro提供的Realm拦截器来判断当前用户是否存在并授权
    @RequestMapping("/login")
    public String login(String uname, String password, Model model, HttpSession session) {
        //获取当前用户对象
        Subject subject = SecurityUtils.getSubject();
        //生成令牌(传入用户输入的账号和密码)
        UsernamePasswordToken token = new UsernamePasswordToken(uname, password);
        //认证登录
        try {
            //这里会加载自定义的realm
            //把令牌放到login里面进行查询,如果查询账号和密码时候匹配,如果匹配就把user对象获取出来,失败就抛异常
            SecurityUtils.getSubject().login(token);
        } catch (Exception e) {
            //认证登录失败抛出异常
            model.addAttribute("message", "账号或密码错误");
            return "redirect:/toLogin";
        }
        User loginUser = userService.getUser(uname);
        session.setAttribute("user", loginUser);
        return "redirect:main/toMain";
    }

    //注册
    @GetMapping("/regist")
    public String regist(){
        return "redirect:/toRegist";
    }

    //添加用户
    @PostMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "addUserSuccess";
    }

    //登出
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {
        //shiro认证退出
        SecurityUtils.getSubject().logout();
        //清理session
        session.setAttribute("user",null);
        //清楚cookie缓存
        CookieUtil.deleteCookie(request, response,"cart");
        return "redirect:/toLogin";
    }

    //当用户无权限时跳转的页面
    @RequestMapping("/noPermission")
    public String noPermission(Model model) {
        model.addAttribute("message", "您无权访问该页面");
        return "commons/error";
    }
}
