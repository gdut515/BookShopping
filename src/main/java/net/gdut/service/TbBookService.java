package net.gdut.service;

import net.gdut.bean.TbBook;

public interface TbBookService {
    //增加书籍
    public void addBook(TbBook tbBook);
    //删除书籍
    public void deleteBook(TbBook tbBook);
}
