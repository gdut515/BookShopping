package net.gdut.service;

import net.gdut.bean.Order;

import java.util.List;

public interface OrderService {
    //查询订单列表
    List<Order> getAllOrder(int uno);
    //查询订单
    Order getOrder(int ono);
    //添加订单
    void addOrder(Order order);
}
