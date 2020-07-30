package net.gdut.service;

import net.gdut.bean.TbUser;

import java.util.List;

public interface TbUserService {

    //注册普通用户
    public void addUser(TbUser tbUser);

    //注册管理员
    public void addAdmin(TbUser tbUser);

    //得到用户
    public TbUser getUser(String uname);

    //得到权限类型：user/admin
    public List<String> getRole(String uname);
}
