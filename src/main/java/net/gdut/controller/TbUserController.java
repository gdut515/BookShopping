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
<<<<<<< Updated upstream
=======
    @PostMapping("/addAdmin")
    public String addAdmin(TbUser tbUser){
    tbUserService.addAdmin(tbUser);
    return "result";
    }

    @GetMapping("/allbook")
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
>>>>>>> Stashed changes
}
