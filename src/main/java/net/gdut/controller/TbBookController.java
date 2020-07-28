package net.gdut.controller;

import net.gdut.bean.TbBook;
import net.gdut.service.TbBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class TbBookController {
    @Resource
    TbBookService tbBookService;

    @PostMapping("/addBook")
    public String addBook(TbBook tbBook){
    tbBookService.addBook(tbBook);
        return "admin"; }

    @PostMapping("/deleteBook")
    public String deleteBook(String bname){
        tbBookService.deleteBook(bname);
        return "admin"; }

    @GetMapping("/admin")
    public String admin(){ return "admin"; }

}
