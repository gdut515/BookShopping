package net.gdut.mapper;

import net.gdut.bean.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserMapper {

    //注普通用户
    public void addUser(TbUser tbUser);

    //注册管理员
    public void addAdmin(TbUser tbUser);
}
