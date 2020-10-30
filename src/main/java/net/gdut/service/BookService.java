package net.gdut.service;

import net.gdut.bean.Book;
import net.gdut.bean.Order;
import net.gdut.bean.tools.Paging;

import java.util.List;

public interface BookService {
    //添加书籍
    public void addBook(Book book);

    //删除书籍
    public void deleteBook(int bno);

    //查询书籍
    public Book getBook(int bno);
    //查询书籍列表
    public List<Book> getAllBook();
    //查询书籍列表
    List<Book> getAllBook(Paging paging);
    //查询书籍列表（根据书名模糊查询）
    public List<Book> getAllBookByName(String name);
}
