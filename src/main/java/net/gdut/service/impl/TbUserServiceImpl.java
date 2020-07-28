package net.gdut.service.impl;

import net.gdut.bean.TbUser;
import net.gdut.mapper.TbUserMapper;
import net.gdut.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    TbUserMapper tbUserMapper;

    @Override
    public void addUser(TbUser tbUser) {
        tbUserMapper.addUser(tbUser);
    }

    @Override
    public void addAdmin(TbUser tbUser){
        tbUserMapper.addAdmin(tbUser);
    }
<<<<<<< Updated upstream
=======

    @Override
    public TbUser getUser(String uname){
        //这里填写调试信息
        TbUser user = tbUserMapper.getUser(uname);
        if(user!=null) System.out.println("根据名字搜索到用户：" + user);
        else System.out.println("不存在该用户");
        return user;
    }

    @Override
    public List<TbBook> getAllBook(){
        return tbUserMapper.getAllBook();
    }
>>>>>>> Stashed changes
}
