package net.gdut.service;

import net.gdut.bean.CartItem;
import net.gdut.bean.tools.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService {
    Msg deleteCartItem(Integer itemId, HttpServletRequest request, HttpServletResponse response);

    Msg updateItem(Integer itemId, Integer quantity, HttpServletRequest request, HttpServletResponse response);

    Msg addCartItem(Integer itemId, HttpServletRequest request, HttpServletResponse response);

    List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);

    void clear(HttpServletRequest request, HttpServletResponse response);
}
