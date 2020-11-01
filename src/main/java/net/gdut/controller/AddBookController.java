package net.gdut.controller;

import net.gdut.bean.Book;
import net.gdut.service.BookService;
import net.gdut.service.ClassificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

//书籍管理控制器
@Controller
@RequestMapping("/addBook")
public class AddBookController {
    @Resource
    BookService bookService;
    @Resource
    ClassificationService classificationService;

    @GetMapping("/toAddBook")
    public String toBookManager(HttpSession session){
        System.out.println("书籍分类条目有："+classificationService.getAllCategoryItem().size());
        session.setAttribute("categoryItems",classificationService.getAllCategoryItem());
        session.setAttribute("publisherItems",classificationService.getAllPublisherItem());
        session.setAttribute("ageItems",classificationService.getAllAgeItem());
        return "book/addBook";
    }

    @RequestMapping(value = "/addBook")
    public String addBook(Book book){
        try {
            book.setAuthor(new String(book.getAuthor().getBytes("ISO-8859-1"), "UTF-8"));
            book.setBname(new String(book.getBname().getBytes("ISO-8859-1"), "UTF-8"));
            book.setDescription(new String(book.getDescription().getBytes("ISO-8859-1"), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        bookService.addBook(book);
        return "redirect:/main/toMain";
    }
}
