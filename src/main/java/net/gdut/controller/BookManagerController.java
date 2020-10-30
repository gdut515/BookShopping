package net.gdut.controller;

import net.gdut.bean.Book;
import net.gdut.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

//书籍管理控制器
@Controller
@RequestMapping("/admin")
public class BookManagerController {
    @Resource
    BookService bookService;

    @GetMapping("/toMain")
    public String toMain(){
        return "redirect:/main/toMain";
    }

    @GetMapping("/toAddBook")
    public String toAddBook(){
        return "admin/addBook";
    }

    @RequestMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id")Integer id) {
        bookService.deleteBook(id);
        return "redirect:/admin/toMain";
    }

    @RequestMapping(value = "/addBook")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/admin/toMain";
    }
}
