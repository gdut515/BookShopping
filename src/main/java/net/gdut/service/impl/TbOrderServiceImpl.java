package net.gdut.service.impl;

import net.gdut.bean.TbBook;
import net.gdut.bean.TbOrder;
import net.gdut.mapper.TbOrderMapper;
import net.gdut.service.TbOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbOrderServiceImpl implements TbOrderService {
    @Resource
    TbOrderMapper tbOrderMapper;
    @Override
    public void addOrder(TbOrder tbOrder) {
        tbOrderMapper.addOrder(tbOrder);
    }

    @Override
    public List<TbOrder> getAllOrder(int uno) {
        List<TbOrder> orders = tbOrderMapper.getAllOrder(uno);
        System.out.println("尝试获取所有订单列表");
        for (TbOrder order: orders) {
            System.out.println(order);
        }
        return orders;
    }
}
