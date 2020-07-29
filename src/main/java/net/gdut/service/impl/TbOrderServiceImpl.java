package net.gdut.service.impl;

import net.gdut.bean.TbOrder;
import net.gdut.mapper.TbOrderMapper;
import net.gdut.service.TbOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbOrderServiceImpl implements TbOrderService {
    @Resource
    TbOrderMapper tbOrderMapper;
    @Override
    public void addOrder(TbOrder tbOrder) {
        tbOrderMapper.addOrder(tbOrder);
    }
}
