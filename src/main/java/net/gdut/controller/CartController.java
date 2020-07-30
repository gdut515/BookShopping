package net.gdut.controller;

import net.gdut.bean.CartItem;
import net.gdut.bean.TbOrder;
import net.gdut.service.CartService;
import net.gdut.service.TbBookService;
import net.gdut.service.TbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    TbOrderService orderService;


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
    public String buyOrder(@RequestParam(value = "uno")Integer uno, HttpServletRequest request, HttpServletResponse response){
        List<CartItem> list = cartService.getCartItemList(request, response);
        for(CartItem item : list){
            orderService.addOrder(new TbOrder(item.getId(),uno,item.getId(),item.getQuantity()));
        }
        cartService.clear(request,response);
        return "redirect:/order/toOrder?uno="+uno;
    }

}
