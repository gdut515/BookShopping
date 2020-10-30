package net.gdut.mapper;

import net.gdut.bean.Book;
import net.gdut.bean.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    //查询所有订单
    List<Order> getAllOrder(int uno);
    //添加订单
    void addOrder(Order order);
}
