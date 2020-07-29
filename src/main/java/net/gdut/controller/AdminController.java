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
@RequestMapping("admin")
public class AdminController {
    @Resource
    TbBookService bookService;

    @GetMapping("")
    public String admin(){
        return "redirect:/admin/book/getAllBook";
    }

    @GetMapping("/toAddBook")
    public String toAddBook(){
        return "admin/addBook";
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
        return "admin/BookManagement";
    }

    @RequestMapping(value = "/book/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id")Integer id) {
        bookService.deleteBook(id);
        return "redirect:/admin/book/getAllBook";
    }

    @RequestMapping(value = "/book/update/{id}")
    public String update(@PathVariable(value = "id")Integer id, Model model) {
        TbBook book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "admin/UpdateBook";
    }

    @RequestMapping(value = "/book/addBook")
    public String addBook(TbBook book) {
        bookService.addBook(book);
        return "redirect:/admin/book/getAllBook";
    }

}
