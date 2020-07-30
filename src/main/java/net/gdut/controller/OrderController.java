package net.gdut.controller;

import com.github.pagehelper.PageInfo;
import net.gdut.bean.TbBook;
import net.gdut.bean.TbOrder;
import net.gdut.service.TbOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    TbOrderService tbOrderService;

    @PostMapping("/addorder")
    public String addOrder(TbOrder tbOrder) {
        tbOrderService.addOrder(tbOrder);
        return "redirect:/order/toOrder";
    }

    @RequestMapping("/toOrder")
    public String getAllOrders(Model model){
        //tbOrderService;
        //model.addAttribute("orders", orders);
        return "order/order";
    }
}
