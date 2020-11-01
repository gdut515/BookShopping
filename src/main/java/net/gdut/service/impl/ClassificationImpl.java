package net.gdut.service.impl;

import net.gdut.bean.classification.AgeItem;
import net.gdut.bean.classification.CategoryItem;
import net.gdut.bean.classification.PublisherItem;
import net.gdut.mapper.ClassificationMapper;
import net.gdut.service.ClassificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassificationImpl implements ClassificationService {
    @Resource
    ClassificationMapper mapper;

    @Override
    public void addCategoryItem(CategoryItem categoryItem) {
        mapper.addCategoryItem(categoryItem);
    }

    @Override
    public void addPublisherItem(PublisherItem publisherItem) {
        mapper.addPublisherItem(publisherItem);
    }

    @Override
    public void addAgeItem(AgeItem ageItem) {
        mapper.addAgeItem(ageItem);
    }

    @Override
    public void deleteCategoryItem(int no) {
        mapper.deleteCategoryItem(no);
    }

    @Override
    public void deletePublisherItem(int no) {
        mapper.deletePublisherItem(no);
    }

    @Override
    public void deleteAgeItem(int no) {
        mapper.deleteAgeItem(no);
    }

    @Override
    public List<CategoryItem> getAllCategoryItem() {
        return mapper.getAllCategoryItem();
    }

    @Override
    public List<PublisherItem> getAllPublisherItem() {
        return mapper.getAllPublisherItem();
    }

    @Override
    public List<AgeItem> getAllAgeItem() {
        return mapper.getAllAgeItem();
    }
}
