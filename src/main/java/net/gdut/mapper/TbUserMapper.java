package net.gdut.mapper;

import net.gdut.bean.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserMapper {

    //注普通用户
    public void addUser(TbUser tbUser);

    //注册管理员
    public void addAdmin(TbUser tbUser);
<<<<<<< Updated upstream
=======

    //得到用户
    public TbUser getUser(String uname);

        //查询所有书籍
    List<TbBook> getAllBook();
>>>>>>> Stashed changes
}
