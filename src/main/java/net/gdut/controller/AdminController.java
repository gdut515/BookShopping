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

//管理员功能
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    TbBookService bookService;

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
    public String addBook(TbBook book) {
        bookService.addBook(book);
        return "redirect:/admin/toMain";
    }

}
