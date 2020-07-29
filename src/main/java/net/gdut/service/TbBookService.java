package net.gdut.service;

import net.gdut.bean.TbBook;
import java.util.List;

public interface TbBookService {
    //增加书籍
    public void addBook(TbBook tbBook);
    //删除书籍
    public void deleteBook(int bno);
    //得到书
    public TbBook getBook(int bno);
    //
    List<TbBook> getAllBook();

    List<TbBook> getAllBookByPriceDESC();

    List<TbBook> getAllBookByPriceASC();

    List<TbBook> getAllBookByName(String bookName);
}
