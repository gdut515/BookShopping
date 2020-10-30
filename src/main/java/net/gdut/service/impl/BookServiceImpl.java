package net.gdut.service.impl;

import net.gdut.bean.Book;
import net.gdut.bean.Order;
import net.gdut.bean.tools.Paging;
import net.gdut.mapper.BookMapper;
import net.gdut.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void deleteBook(int bno) {
        bookMapper.deleteBook(bno);
    }

    @Override
    public Book getBook(int bno){
        Book book = bookMapper.getBook(bno);
        if(book!=null) System.out.println("根据bno"+bno+" 搜索到书：" + book);
        else System.out.println("不存在该书");
        return book;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = bookMapper.getAllBook();
        System.out.println("尝试获取所有书列表");
        for (Book book: books) {
            System.out.println(book);
        }
        return books;
    }

    @Override
    public List<Book> getAllBook(Paging paging){
        return bookMapper.getAllBook(paging);
    }

    @Override
    public List<Book> getAllBookByName(String bookName) {
        return bookMapper.getAllBookByName(bookName);
    }
}
