package net.gdut.mapper;

import net.gdut.bean.tools.Paging;
import net.gdut.bean.Book;
import net.gdut.bean.Order;
import net.gdut.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //添加普通用户
    public void addUser(User user);
    //查询用户
    public User getUser(String uname);
    //查询用户权限
    public List<String> getRole(String uname);

    void deleteUser(Integer uno);

    List<User> getAllUsers();
}
