package net.gdut.service.impl;

import net.gdut.bean.TbBook;
import net.gdut.mapper.TbBookMapper;
import net.gdut.service.TbBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbBookServiceImpl implements TbBookService {
    @Resource
    TbBookMapper tbBookMapper;
    @Override
    public void addBook(TbBook tbBook) {
        tbBookMapper.addBook(tbBook);
    }
    @Override
    public void deleteBook(String bname) { tbBookMapper.deleteBook(bname); }

}
