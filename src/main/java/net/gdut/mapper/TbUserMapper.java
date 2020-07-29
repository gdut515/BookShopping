package net.gdut.mapper;

import net.gdut.bean.TbBook;
import net.gdut.bean.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserMapper {

    //注普通用户
    public void addUser(TbUser tbUser);

    //注册管理员
    public void addAdmin(TbUser tbUser);

    //得到用户
    public TbUser getUser(String uname);

        //查询所有书籍
    List<TbBook> getAllBook();

    //展示订单
    List<TbBook> showOrder(TbOrder tbOrder);
}
