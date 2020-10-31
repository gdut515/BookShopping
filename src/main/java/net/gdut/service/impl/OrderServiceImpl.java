package net.gdut.service.impl;

import net.gdut.bean.Book;
import net.gdut.bean.Order;
import net.gdut.bean.OrderItem;
import net.gdut.bean.OrderItemWithBook;
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
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderMapper.addOrderItem(orderItem);
    }

    @Override
    public Order getOrder(int ono) {
        Order order = orderMapper.getOrder(ono);
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

    @Override
    public List<OrderItemWithBook> getOrderItemWithBookByOrder(int ono) {
        List<OrderItemWithBook> items = orderMapper.getOrderItemWithBookByOrder(ono);
        System.out.println("获得订单相关书籍数量："+items.size());
        return items;
    }

}
