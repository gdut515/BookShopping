package net.gdut.service;

import net.gdut.bean.tools.Paging;
import net.gdut.bean.Book;
import net.gdut.bean.User;

import java.util.List;

public interface UserService {
    //添加普通用户
    public void addUser(User user);

    //查询用户
    public User getUser(String uname);
    //查询用户权限：user/admin
    public List<String> getRole(String uname);

    void deleteUser(Integer uno);

    List<User> getAllUsers();
}
