package net.gdut.service;

import net.gdut.bean.TbUser;

public interface TbUserService {

    //注册普通用户
    public void addUser(TbUser tbUser);

    //注册管理员
    public void addAdmin(TbUser tbUser);
}
