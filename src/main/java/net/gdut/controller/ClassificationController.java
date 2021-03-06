package net.gdut.controller;

import net.gdut.bean.classification.AgeItem;
import net.gdut.bean.classification.CategoryItem;
import net.gdut.bean.classification.PublisherItem;
import net.gdut.service.ClassificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/classification")
public class ClassificationController{
    @Resource
    ClassificationService service;

    @GetMapping("/toAddClassification")
    public String toAddClassification(HttpSession session){
        return "classification/addClassification";
    }

    @GetMapping("/toClassification")
    public String toClassification(HttpSession session){
        session.setAttribute("categoryItems", service.getAllCategoryItem());
        session.setAttribute("publisherItems", service.getAllPublisherItem());
        session.setAttribute("ageItems", service.getAllAgeItem());
        return "classification/classification";
    }

    @RequestMapping("/delete")
    public String d(
            @RequestParam(value = "classification")Integer classification,
            @RequestParam(value = "no")Integer no,
            Model model){
        if(classification==1){service.deleteCategoryItem(no); }
        else if(classification==2){service.deletePublisherItem(no); }
        else if(classification==3){service.deleteAgeItem(no); }
        else{System.out.println("分类控制器delete出问题了！！！"); }
        return "redirect:/classification/toClassification";
    }

    @RequestMapping("/add")
    public String add(@RequestParam(value = "no")Integer no,
                      @RequestParam(value = "name")String name){
        String str = null;
        try {
            str = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(no==1){
            CategoryItem item = new CategoryItem();
            item.setCategoryName(str);
            service.addCategoryItem(item);
        }
        else if(no==2){
            PublisherItem item = new PublisherItem();
            item.setPublisherName(str);
            service.addPublisherItem(item);
        }
        else if(no==3){
            AgeItem item = new AgeItem();
            item.setAgeName(str);
            service.addAgeItem(item);
        }
        else{
            System.out.println("分类控制器add出问题了！！！");
        }
        return "redirect:/classification/toClassification";
    }

}
