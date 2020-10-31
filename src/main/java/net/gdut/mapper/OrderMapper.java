package net.gdut.mapper;

import net.gdut.bean.Book;
import net.gdut.bean.Order;
import net.gdut.bean.OrderItem;
import net.gdut.bean.OrderItemWithBook;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    //添加订单，返还订单号
    int addOrder(Order order);
    //添加订单项目
    void addOrderItem(OrderItem orderItem);
    //查询订单
    Order getOrder(int ono);
    //查询订单列表
    List<Order> getAllOrder(int uno);
    //查询订单项目列表（根据订单）
    List<OrderItem> getOrderItemByOrder(int ono);
    //查询订单项目包含书籍属性列表（根据订单）
    List<OrderItemWithBook> getOrderItemWithBookByOrder(int ono);
}
