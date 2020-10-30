package net.gdut.service.impl;

import net.gdut.bean.tools.Paging;
import net.gdut.bean.Book;
import net.gdut.bean.User;
import net.gdut.mapper.UserMapper;
import net.gdut.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void addAdmin(User user){
        userMapper.addAdmin(user);
    }

    @Override
    public User getUser(String uname){
        //这里填写调试信息
        User user = userMapper.getUser(uname);
        if(user!=null) System.out.println("根据名字搜索到用户：" + user);
        else System.out.println("不存在该用户");
        return user;
    }

    @Override
    public List<Book> getAllBook(Paging paging){
        return userMapper.getAllBook(paging);
    }

    @Override
    public List<String> getRole(String uname) {
        return userMapper.getRole(uname);
    }
}
