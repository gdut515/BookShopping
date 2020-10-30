package net.gdut.controller;

import net.gdut.bean.Order;
import net.gdut.bean.User;
import net.gdut.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @PostMapping("/addOrder")
    public String addOrder(Order order, HttpSession session){
        orderService.addOrder(order);
        int uno = ((User)session.getAttribute("user")).getUno();
        return "redirect:/order/toOrder/uno="+uno;
    }

    @RequestMapping("/toOrder")
    public String getAllOrders(@RequestParam(value = "uno")Integer uno, Model model){
        System.out.println("用户"+uno+"查询所有订单");
        List<Order> orders = orderService.getAllOrder(uno);
        model.addAttribute("orders", orders);
        return "order/order";
    }
}
