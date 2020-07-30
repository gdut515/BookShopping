package net.gdut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.gdut.bean.Paging;import net.gdut.bean.TbBook;
import net.gdut.bean.TbUser;
import net.gdut.service.TbBookService;
import net.gdut.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class TbUserController {

    @Resource
    TbUserService tbUserService;

    @Resource
    TbBookService bookService;

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

    //尚未提供可供jsp调用的/addAdmin方法

//    @GetMapping("/all")
//    public String getAllStudent(HttpServletRequest request){
//        List<TbStudent> studentList = studentMapper.getAllStudentInfo();
//        request.setAttribute("students",studentList);
//        return "allStudent";
//    }
    @PostMapping("/addAdmin")
    public String addAdmin(TbUser tbUser){
    tbUserService.addAdmin(tbUser);
    return "result";
    }

    @GetMapping("/allbook1")
    public String getAllBook(HttpServletRequest request){
        int pageNum=1;
        int pageSize=1;
        int navigatePages=1;
        PageHelper.startPage(pageNum,pageSize);
        List<TbBook> books = tbUserService.getAllBook();
        PageInfo<TbBook> userPageInfo = new PageInfo<>(books,navigatePages);
        books.forEach(System.out::println);
        request.setAttribute("books",books);

        System.out.println("导航页码：" + Arrays.toString(userPageInfo.getNavigatepageNums()));
        System.out.println("是否有下一页:" + userPageInfo.isHasNextPage());
        System.out.println("是否有上一页:" + userPageInfo.isHasPreviousPage());
        System.out.println("总页数:" + userPageInfo.getPages());
        System.out.println("总数据条数:" + userPageInfo.getTotal());

        return "user";
    }
    @RequestMapping(value = "/allbook")
    public String getAllBook(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,@RequestParam Integer uno, Model model) {
        PageHelper.startPage(pageNo, 10);
        //startPage后面紧跟的就是一个分页查询
        List<TbBook> books = bookService.getAllBook();
        //使用PageInfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询的数据.连续显示的页数
        PageInfo pageInfo = new PageInfo(books, 4);
        model.addAttribute("books", books);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("uno",uno);
        return "login/user1";
    }
}
