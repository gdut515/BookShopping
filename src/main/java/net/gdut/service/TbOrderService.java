package net.gdut.service;

import net.gdut.bean.TbOrder;

import java.util.List;

public interface TbOrderService {
    public void addOrder(TbOrder tbOrder);

    public List<TbOrder> getAllOrder(int uno);
}
