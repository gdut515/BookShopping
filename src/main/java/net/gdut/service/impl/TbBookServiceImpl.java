package net.gdut.service.impl;

import net.gdut.bean.TbBook;
import net.gdut.mapper.TbBookMapper;
import net.gdut.service.TbBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbBookServiceImpl implements TbBookService {
    @Resource
    TbBookMapper tbBookMapper;
    @Override
    public void addBook(TbBook tbBook) {
        tbBookMapper.addBook(tbBook);
    }
    @Override
    public void deleteBook(int bno) {
        tbBookMapper.deleteBook(bno);
    }
    @Override
    public TbBook getBook(int bno){
        TbBook book = tbBookMapper.getBook(bno);
        if(book!=null) System.out.println("根据bno"+bno+" 搜索到书：" + book);
        else System.out.println("不存在该书");
        return book;
    }

    @Override
    public List<TbBook> getAllBook() {
        List<TbBook> books = tbBookMapper.getAllBook();
        System.out.println("尝试获取所有书列表");
        for (TbBook book: books) {
            System.out.println(book);
        }
        return books;
    }

    @Override
    public List<TbBook> getAllBookByName(String bookName) {
        return null;
    }
}
