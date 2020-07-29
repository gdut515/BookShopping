package net.gdut.controller;

import net.gdut.bean.TbBook;
import net.gdut.bean.TbOrder;
import net.gdut.service.TbOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

@Controller
public class TbOrderController {
    @Resource
    TbOrderService tbOrderService;
    @PostMapping("/addorder")
    public String addOrder(TbOrder tbOrder) {
        tbOrderService.addOrder(tbOrder);
        return "admin";
    }
}
