package net.gdut.controller;

import net.gdut.bean.Book;
import net.gdut.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//管理员功能
@Controller
@RequestMapping("/admin")
public class AdminController {
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
