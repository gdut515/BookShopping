package net.gdut.service.impl;

import net.gdut.bean.CartItem;
import net.gdut.bean.Msg;
import net.gdut.bean.TbBook;
import net.gdut.service.CartService;
import net.gdut.service.TbBookService;
import net.gdut.utils.CookieUtil;
import net.gdut.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    TbBookService bookService;

    //添加购物车商品
    @Override
    public Msg addCartItem(Integer itemId, HttpServletRequest request, HttpServletResponse response) {
        //取商品信息
        CartItem cartItem = null;
        //收取购物车商品列表
        List<CartItem> itemList = getCartItemList(request);
        //判断购物车商品列表是否存在此商品
        for (CartItem item : itemList) {
            //如果存在此商品
            if (item.getId() == itemId) {
                //增加商品数量
                item.setQuantity(item.getQuantity() + 1);
                cartItem = item;
                break;
            }
        }
        if (cartItem == null) {
            cartItem = new CartItem();
            TbBook book = bookService.getBook(itemId);
            cartItem.setQuantity(1);
            cartItem.setId(book.getBno());
            cartItem.setAuthor(book.getAuthor());
            cartItem.setBook_image(book.getCover());
            cartItem.setBook_name(book.getBname());
            cartItem.setPrice(book.getPrice());
            //添加到购物车列表
            itemList.add(cartItem);
        }
        CookieUtil.setCookie(request, response, "Cart", JsonUtils.objectToJson(itemList), true);
        return Msg.success();
    }

    //获取购物车信息
    @Override
    public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
        //从cookies中取得商品列表
        String cartJson = CookieUtil.getCookieValue(request, "Cart", true);
        if (cartJson == null) {
            return new ArrayList<>();
        }
        //把json转换成商品列表
        try {
            List<CartItem> list = JsonUtils.jsonToList(cartJson, CartItem.class);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //清空购物车
    @Override
    public void clear(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(request,response,"Cart");
    }

    //删除购物车商品
    @Override
    public Msg deleteCartItem(Integer itemId, HttpServletRequest request, HttpServletResponse response) {
        //从cookies中获取购物车列表
        List<CartItem> itemList = getCartItemList(request);
        //从列表中找到此商品
        for (CartItem cartItem : itemList) {
            if (cartItem.getId() == itemId) {
                itemList.remove(cartItem);
                break;
            }
        }
        //把购物车列表重新写入cookies
        CookieUtil.setCookie(request, response, "Cart", JsonUtils.objectToJson(itemList), true);
        return Msg.success();
    }

    //更新购物车数据
    @Override
    public Msg updateItem(Integer itemId,Integer quantity, HttpServletRequest request, HttpServletResponse response) {
        List<CartItem> itemList = getCartItemList(request);
        for (CartItem cartItem : itemList) {
            if (cartItem.getId() == itemId) {
                cartItem.setQuantity(quantity);
                break;
            }
        }
        CookieUtil.setCookie(request, response, "Cart", JsonUtils.objectToJson(itemList), true);
        return Msg.success();
    }

    //从cookies中取商品列表
    private List<CartItem> getCartItemList(HttpServletRequest request) {
        //从cookie中取商品列表
        String cartJson = CookieUtil.getCookieValue(request, "Cart", true);
        if (cartJson == null) {
            return new ArrayList<>();
        }
        //把json转换成商品列表
        try {
            List<CartItem> list = JsonUtils.jsonToList(cartJson, CartItem.class);
            if(list==null){
                list = new ArrayList<>();
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
