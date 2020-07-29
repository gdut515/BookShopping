package net.gdut.controller;

import net.gdut.bean.Paging;
import net.gdut.bean.TbBook;
import net.gdut.bean.TbUser;
import net.gdut.service.TbUserService;
import net.gdut.utils.CookieUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public String userLogin(Model model){
    model.addAttribute("message", "您好！");
    return "login/login";
    }

    //当用户无权限时跳转的页面
    @RequestMapping("/nopermission")
    public String nopermission(Model model) {
        model.addAttribute("message", "您无权访问该页面");
        return "commons/error";
    }

    //用shiro提供的Realm拦截器来判断当前用户是否存在并授权
    @RequestMapping("/login")
    public String test(String uname, String password, Model model, HttpSession session) {
        //获取当前用户对象
        Subject subject = SecurityUtils.getSubject();
        //生成令牌(传入用户输入的账号和密码)
        UsernamePasswordToken token = new UsernamePasswordToken(uname, password);
        //认证登录
        try {
            //这里会加载自定义的realm
            //把令牌放到login里面进行查询,如果查询账号和密码时候匹配,如果匹配就把user对象获取出来,失败就抛异常
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            //认证登录失败抛出异常
            model.addAttribute("message", "账号或密码错误");
            return "redirect:/toLogin";
        }
        TbUser loginUser = tbUserService.getUser(uname);
        session.setAttribute("user", loginUser);
        return "redirect:main/toMain";
    }

    /**
     * 登出
     */
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        //清楚cookie缓存
        CookieUtil.deleteCookie(request, response,"user");
        return "redirect:/toLogin";
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


}
