package net.gdut.service;

import net.gdut.bean.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService {
    void deleteCartItem(Long itemId, HttpServletRequest request, HttpServletResponse response);

    void updateItem(Long itemId, Integer quantity, HttpServletRequest request, HttpServletResponse response);

    List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);

    void addCartItem(Long itemId, HttpServletRequest request, HttpServletResponse response);
}
