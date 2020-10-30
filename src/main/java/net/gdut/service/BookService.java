package net.gdut.service;

import net.gdut.bean.Book;
import java.util.List;

public interface BookService {
    //添加书籍
    public void addBook(Book book);
    //删除书籍
    public void deleteBook(int bno);
    //得到书
    public Book getBook(int bno);
    //
    List<Book> getAllBook();

    List<Book> getAllBookByName(String bookName);
}
