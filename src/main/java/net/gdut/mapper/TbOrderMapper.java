package net.gdut.mapper;

import net.gdut.bean.TbOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface TbOrderMapper {
    void addOrder(TbOrder tbOrder);
}
