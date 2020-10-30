package net.gdut.service.impl;

import net.gdut.bean.Order;
import net.gdut.bean.OrderItem;
import net.gdut.mapper.OrderMapper;
import net.gdut.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
        order.getOrderItems().forEach(this::addOrderItem);
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderMapper.addOrderItem(orderItem);
    }

    @Override
    public Order getOrder(int ono) {
        Order order = orderMapper.getOrder(ono);
        order.setOrderItems(getOrderItemByOrder(order.getOno()));
        return order;
    }

    @Override
    public List<Order> getAllOrder(int uno) {
        List<Order> orders = orderMapper.getAllOrder(uno);
        return orders;
    }

    @Override
    public List<OrderItem> getOrderItemByOrder(int ono) {
        return orderMapper.getOrderItemByOrder(ono);
    }
}
