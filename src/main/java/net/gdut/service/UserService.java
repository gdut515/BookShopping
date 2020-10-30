package net.gdut.service;

import net.gdut.bean.tools.Paging;
import net.gdut.bean.Book;
import net.gdut.bean.User;

import java.util.List;

public interface UserService {

    //注册普通用户
    public void addUser(User user);

    //注册管理员
    public void addAdmin(User user);

    //得到用户
    public User getUser(String uname);

    //查询所有书籍
    List<Book> getAllBook(Paging paging);

    //得到权限类型：user/admin
    public List<String> getRole(String uname);
}
