package net.gdut.mapper;

import net.gdut.bean.Book;
import net.gdut.bean.classification.AgeItem;
import net.gdut.bean.classification.CategoryItem;
import net.gdut.bean.classification.PublisherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificationMapper {
    //添加书籍分类条目
    public void addCategoryItem(CategoryItem categoryItem);
    //添加出版商条目
    public void addPublisherItem(PublisherItem publisherItem);
    //添加年龄条目
    public void addAgeItem(AgeItem ageItem);
    //删除分类条目
    public void deleteCategoryItem(int no);
    //删除出版商分类条目
    public void deletePublisherItem(int no);
    //删除年龄分类条目
    public void deleteAgeItem(int no);
    //查询分类条目列表
    public List<CategoryItem> getAllCategoryItem();
    //查询出版商分类条目列表
    public List<PublisherItem> getAllPublisherItem();
    //查询年龄分类条目列表
    public List<AgeItem> getAllAgeItem();

    CategoryItem getCategoryItem(int category);

    PublisherItem getPublisherItem(int publisher);

    AgeItem getAgeItem(int age);
}
