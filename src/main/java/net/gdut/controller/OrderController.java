package net.gdut.controller;

import com.github.pagehelper.PageInfo;
import net.gdut.bean.TbBook;
import net.gdut.bean.TbOrder;
import net.gdut.bean.TbUser;
import net.gdut.service.TbOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    TbOrderService tbOrderService;

    @PostMapping("/addorder")
    public String addOrder(TbOrder tbOrder,HttpSession session){
        tbOrderService.addOrder(tbOrder);
        int uno = ((TbUser)session.getAttribute("user")).getUno();
        return "redirect:/order/toOrder/uno="+uno;
    }

    @RequestMapping("/toOrder")
    public String getAllOrders(@RequestParam(value = "uno")Integer uno, Model model){
        System.out.println("用户"+uno+"查询所有订单");
        List<TbOrder> orders = tbOrderService.getAllOrder(uno);
        model.addAttribute("orders", orders);
        return "order/order";
    }
}
