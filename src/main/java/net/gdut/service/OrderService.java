package net.gdut.service;

import net.gdut.bean.Order;

import java.util.List;

public interface OrderService {
    public void addOrder(Order order);

    public List<Order> getAllOrder(int uno);
}
