package net.gdut.service;

import net.gdut.bean.Paging;
import net.gdut.bean.TbBook;
import net.gdut.bean.TbUser;

import java.util.List;

public interface TbUserService {

    //注册普通用户
    public void addUser(TbUser tbUser);

    //注册管理员
    public void addAdmin(TbUser tbUser);

    //得到用户
    public TbUser getUser(String uname);

    //查询所有书籍
    List<TbBook> getAllBook(Paging paging);
}
