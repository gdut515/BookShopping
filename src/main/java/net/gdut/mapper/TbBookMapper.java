package net.gdut.mapper;

import net.gdut.bean.TbBook;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbBookMapper {
   //增加书籍
    public void addBook(TbBook tbBook);
    //删除书籍
    public void deleteBook(int bno);
    //得到书籍
    public TbBook getBook(int bno);
    //得到书籍列表
    public List<TbBook> getAllBook();
}
