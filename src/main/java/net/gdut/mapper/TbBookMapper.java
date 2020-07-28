package net.gdut.mapper;

import net.gdut.bean.TbBook;
import org.springframework.stereotype.Repository;

@Repository
public interface TbBookMapper {
   //增加书籍
    public void addBook(TbBook tbBook);
    //删除书籍
    public void deleteBook(String bname);

}
