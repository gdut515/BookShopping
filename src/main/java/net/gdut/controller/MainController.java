package net.gdut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.gdut.bean.Book;
import net.gdut.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//主页面功能
@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    BookService bookService;

    @GetMapping("/toMain")
    public String toMain(){
        return "redirect:/main/toindex";
    }

    @GetMapping("/toLogin")
    public String userLogin(){
        return "redirect:/toLogin";
    }

    @GetMapping("/toAddBook")
    public String toAddBook(){
        return "redirect:/admin/toAddBook";
    }

    @GetMapping("/toCart")
    public String toCart() { return "redirect:/cart/cart"; }

    /**
     * 查询书籍并做出分页处理，并跳转到首页
     */
    @RequestMapping(value = "/toindex")
    public String toindex(@RequestParam(value = "pageNo", required = false, defaultValue = "0") Integer pageNo, Model model){
        System.out.println("现在在浏览第"+pageNo+"页书籍");
        PageHelper.startPage(pageNo,10);
        //startPage后面紧跟的就是一个分页查询
        List<Book> books= bookService.getAllBook();
        //使用PageInfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询的数据.连续显示的页数
        PageInfo pageInfo=new PageInfo(books,5);
        model.addAttribute("books", books);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("url", "toindex");
        return "commons/main";
    }

    /**
     * 通过书籍名模糊查询书籍
     */
    @RequestMapping(value = "/checkBook")
    public String checkBook(String bookName,Model model){
        List<Book> books=bookService.getAllBookByName(bookName);
        model.addAttribute("books", books);
        return "commons/main";
    }

}
