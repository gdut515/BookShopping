package net.gdut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.gdut.bean.TbBook;
import net.gdut.service.TbBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    TbBookService bookService;

    @GetMapping("")
    public String admin(){
        return "redirect:/user/book/getAllBook";
    }

    @RequestMapping(value = "/book/getAllBook")
    public String toindex(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, Model model) {
        PageHelper.startPage(pageNo, 10);
        //startPage后面紧跟的就是一个分页查询
        List<TbBook> books = bookService.getAllBook();
        //使用PageInfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询的数据.连续显示的页数
        PageInfo pageInfo = new PageInfo(books, 5);
        model.addAttribute("books", books);
        model.addAttribute("pageInfo", pageInfo);
        return "/user/BookList";
    }

    @PostMapping(value = "buyBook")
    public String buyBook(@PathVariable(value = "id")Integer id){
        //将书本添加至购物篮
        return "redirect:/user/book/getAllBook";
    }
}
