package net.gdut.mapper;

import net.gdut.bean.TbOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbOrderMapper {
    //插入订单
    int insert(TbOrder order);
    //查询所有订单
    List<TbOrder> getAllOrder();
    //查询订单该用户所属订单
    List<TbOrder> getAllOrderByUser(Long id);

    void addOrder(TbOrder tbOrder);
}
