package net.gdut.service;

import net.gdut.bean.Book;
import net.gdut.bean.Order;
import net.gdut.bean.OrderItem;

import java.util.List;

public interface OrderService {
    //添加订单
    void addOrder(Order order);
    //添加订单项目
    void addOrderItem(OrderItem orderItem);
    //查询订单
    Order getOrder(int ono);
    //查询订单列表
    List<Order> getAllOrder(int uno);
    //查询订单项目列表（根据订单）
    List<OrderItem> getOrderItemByOrder(int ono);
}
