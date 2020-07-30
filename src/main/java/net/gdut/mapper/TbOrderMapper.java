package net.gdut.mapper;

import net.gdut.bean.TbOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbOrderMapper {
    //查询所有订单
    List<TbOrder> getAllOrder(int uno);
    //插入订单
    void addOrder(TbOrder tbOrder);
}
