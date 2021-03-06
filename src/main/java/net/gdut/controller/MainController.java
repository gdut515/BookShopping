package net.gdut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.gdut.bean.Book;
import net.gdut.service.BookService;
import net.gdut.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

//主页面功能
@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    BookService bookService;
    @Resource
    ClassificationService classificationService;

    @GetMapping("/toMain")
    public String toMain(){
        return "redirect:/main/toIndex";
    }
    @GetMapping("/toLogin")
    public String userLogin(){
        return "redirect:/toLogin";
    }
    @GetMapping("/toClassificationManager")
    public String toClassificationManager(){
        return "redirect:/classificationManager/toClassificationManager";
    }
    @GetMapping("/toCart")
    public String toCart() { return "redirect:/cart/toCart"; }

    //查询书籍并做出分页处理，并跳转到首页
    @RequestMapping(value = "/toIndex")
    public String toindex(@RequestParam(value = "pageNo", required = false, defaultValue = "0") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,10);
        //startPage后面紧跟的就是一个分页查询
        List<Book> books= bookService.getAllBook();
        books.forEach((Book book)->{
            book.setCategoryName(classificationService.getCategoryItem(book.getCategory()).getCategoryName());
            book.setPublisherName(classificationService.getPublisherItem(book.getPublisher()).getPublisherName());
            book.setAgeName(classificationService.getAgeItem(book.getAge()).getAgeName());
        });
        //使用PageInfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询的数据.连续显示的页数
        PageInfo pageInfo=new PageInfo(books,5);
        model.addAttribute("books", books);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("url", "toindex");
        return "main/main";
    }

    //通过书籍名模糊查询书籍
    @RequestMapping(value = "/checkBook")
    public String checkBook(String bookName,Model model){
        List<Book> books=bookService.getAllBookByName(bookName);
        books.forEach((Book book)->{
            book.setCategoryName(classificationService.getCategoryItem(book.getCategory()).getCategoryName());
            book.setPublisherName(classificationService.getPublisherItem(book.getPublisher()).getPublisherName());
            book.setAgeName(classificationService.getAgeItem(book.getAge()).getAgeName());
        });
        model.addAttribute("books", books);
        return "main/main";
    }

    @RequestMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id")Integer id) {
        bookService.deleteBook(id);
        return "redirect:/main/toMain";
    }
}
