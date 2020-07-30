package net.gdut.controller;

import net.gdut.bean.TbBook;
import net.gdut.bean.TbOrder;
import net.gdut.service.TbOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class TbOrderController {
    @Resource
    TbOrderService tbOrderService;
    @RequestMapping("/addorder")
    public String addOrder(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam Integer uno,@RequestParam Integer bno, Model model) {
        TbOrder tbOrder = new TbOrder(null,uno,bno,1);
        tbOrderService.addOrder(tbOrder);
        return "redirect:/allbook?uno="+uno.toString();
    }
}
