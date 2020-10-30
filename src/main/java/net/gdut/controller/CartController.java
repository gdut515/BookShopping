package net.gdut.controller;

import net.gdut.bean.CartItem;
import net.gdut.bean.Order;
import net.gdut.bean.OrderItem;
import net.gdut.bean.User;
import net.gdut.service.CartService;
import net.gdut.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;

    @RequestMapping("/add/{itemId}")
    public String addCartItem(@PathVariable Integer itemId, HttpServletRequest request, HttpServletResponse response) {
        cartService.addCartItem(itemId, request, response);
        return "cart/success";
    }

    @RequestMapping("/cart")
    public String toCart(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<CartItem> list = cartService.getCartItemList(request, response);
        model.addAttribute("cartList", list);
        return "cart/cartList";
    }

    @RequestMapping("/delete/{itemId}")
    public String deleteCartItem(@PathVariable Integer itemId, HttpServletRequest request, HttpServletResponse response) {
        cartService.deleteCartItem(itemId, request, response);
        return "redirect:/cart/cart";
    }

    @RequestMapping("/updateQuantity/{itemId}/{itemQuantity}")
    public String updateQuantity(@PathVariable("itemId")Integer itemId, @PathVariable("itemQuantity") Integer quantity,
                                 HttpServletRequest request, HttpServletResponse response) {
        cartService.updateItem(itemId, quantity, request, response);
        return "redirect:/cart/cart";
    }

    @RequestMapping(value = "/buy")
    public String submitOrder(@RequestParam(value = "uno")Integer uno, HttpServletRequest request, HttpServletResponse response){
        List<CartItem> list = cartService.getCartItemList(request, response);
        //添加订单
        Order order = new Order();
        order.setUno(uno);
        order.setAddress("空地址");
        order.setTime(new Timestamp(System.currentTimeMillis()));
        order.setState(0);//未支付状态
        orderService.addOrder(order);
        //添加订单项目
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem item : list){
            OrderItem orderItem = new OrderItem();
            orderItem.setBno(item.getId());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setOno(order.getOno());
            orderService.addOrderItem(orderItem);
        }
        //清理购物车
        cartService.clear(request,response);
        return "redirect:/order/toOrder?uno="+uno;
    }

}
