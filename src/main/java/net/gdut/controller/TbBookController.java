package net.gdut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.gdut.bean.TbBook;
import net.gdut.service.TbBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TbBookController {
    @Autowired
    TbBookService bookService;

    /**
     * 查询书籍并做出分页处理，并跳转到首页
     * @param pageNo
     * @param model
     * @return
     */
    @RequestMapping(value = "/toindex")
    public String toindex(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, Model model){
        PageHelper.startPage(pageNo,10);
        //startPage后面紧跟的就是一个分页查询
        List<TbBook> books= bookService.getAllBook();
        //使用PageInfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询的数据.连续显示的页数
        PageInfo pageInfo=new PageInfo(books,5);
        model.addAttribute("books", books);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("url", "toindex");
        return "buy/BookList";
    }

    @RequestMapping(value = "/Desc")
    public String Desc(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,Model model){
        PageHelper.startPage(pageNo,10);
        //startPage后面紧跟的就是一个分页查询
        List<TbBook> books= bookService.getAllBookByPriceDESC();
        //使用PageInfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询的数据.连续显示的页数
        PageInfo pageInfo=new PageInfo(books,5);
        model.addAttribute("books", books);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("url", "Desc");
        return "buy/BookList";
    }

    @RequestMapping(value = "/Asc")
    public String ASC(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,Model model) {
        PageHelper.startPage(pageNo,10);
        //startPage后面紧跟的就是一个分页查询
        List<TbBook> books= bookService.getAllBookByPriceASC();
        //使用PageInfo包装查询后的结果，只需将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询的数据.连续显示的页数
        PageInfo pageInfo=new PageInfo(books,5);
        model.addAttribute("books", books);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("url", "Asc");
        return "buy/BookList";
    }

    /**
     * 获取书籍的类别（parent_id为0，因为这里想以后能够扩展出现二级类别），返回Json格式数据
     * @param type
     * @return
     * @throws Exception
     */
    /*
    @ResponseBody
    @RequestMapping(value = "/getParentTypeList")
    public String getParentTypeList(@RequestParam(value = "type", required = true) String type) throws Exception {
        List<Category> categoryList  = categoryService.getParentTypeList();
        return JSON.toJSONString(categoryList);
    }
    */
    /**
     * 显示该类别所有图书
     * @param typeList
     * @param model
     * @return
     * @throws Exception
     */
    /*
    @RequestMapping(value = "/searchByCategory")
    public String searchByCategory(String typeList,Model model) throws Exception{
        List<Book> books=bookService.getAllBookByType(Integer.valueOf(typeList));
        model.addAttribute("books", books);
        return "buy/BookListName";
    }
     */

    /**
     * 通过书籍名模糊查询书籍
     * @param bookName
     * @param model
     * @return
     */
    @RequestMapping(value = "/checkBook")
    public String checkBook(String bookName,Model model){
        List<TbBook> books=bookService.getAllBookByName(bookName);
        model.addAttribute("books", books);
        return "buy/BookListName";
    }

    @RequestMapping(value = "/selectBookBySale")
    public String selectBookBySale(Model model) {
        List<TbBook> books = bookService.selectBookBySale();
        model.addAttribute("books", books);
        return "buy/SaleBook";
    }
}
