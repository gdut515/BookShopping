package net.gdut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.gdut.bean.*;
import net.gdut.service.BookService;
import net.gdut.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;
    @Resource
    BookService bookService;

    @PostMapping("/addOrder")
    public String addOrder(Order order, HttpSession session){
        orderService.addOrder(order);
        return "redirect:/order/toOrder";
    }

    @RequestMapping("/toOrder")
    public String getAllOrders(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println("用户"+user.getUno()+"查询所有订单");
        List<Order> orders = orderService.getAllOrder(user.getUno());
        model.addAttribute("orders", orders);
        return "order/order";
    }

    @RequestMapping("/openOrder")
    public String s(@RequestParam(value = "ono")Integer ono,
                    @RequestParam(value = "pageNo", required = false, defaultValue = "0") Integer pageNo,
                    Model model){
        PageHelper.startPage(pageNo,10);
        //startPage后面紧跟的就是一个分页查询
        List<OrderItemWithBook> items = orderService.getOrderItemWithBookByOrder(ono);
        //使用PageInfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询的数据.连续显示的页数
        PageInfo pageInfo=new PageInfo(items,5);
        items.forEach((orderItemWithBook)->{orderItemWithBook.setCost(orderItemWithBook.getPrice()*orderItemWithBook.getQuantity());});
        model.addAttribute("orderItems", items);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("url", "toindex");
        return "order/orderItem";
    }
}
