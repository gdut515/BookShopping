package net.gdut.service.impl;

import net.gdut.bean.Order;
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
    }

    @Override
    public List<Order> getAllOrder(int uno) {
        List<Order> orders = orderMapper.getAllOrder(uno);
        System.out.println("尝试获取所有订单列表");
        for (Order order: orders) {
            System.out.println(order);
        }
        return orders;
    }
}
