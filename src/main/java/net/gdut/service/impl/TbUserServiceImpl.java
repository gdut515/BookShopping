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
}
