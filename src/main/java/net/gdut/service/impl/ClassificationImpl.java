package net.gdut.service.impl;

import net.gdut.bean.classification.AgeItem;
import net.gdut.bean.classification.CategoryItem;
import net.gdut.bean.classification.PublisherItem;
import net.gdut.mapper.OrderMapper;
import net.gdut.service.ClassificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassificationImpl implements ClassificationService {
    @Resource
    ClassificationService service;

    @Override
    public void addCategoryItem(CategoryItem categoryItem) {
        service.addCategoryItem(categoryItem);
    }

    @Override
    public void addPublisherItem(PublisherItem publisherItem) {
        service.addPublisherItem(publisherItem);
    }

    @Override
    public void addAgeItem(AgeItem ageItem) {
        service.addAgeItem(ageItem);
    }

    @Override
    public void deleteCategoryItem(int no) {
        service.deleteCategoryItem(no);
    }

    @Override
    public void deletePublisherItem(int no) {
        service.deletePublisherItem(no);
    }

    @Override
    public void deleteAgeItem(int no) {
        service.deleteAgeItem(no);
    }

    @Override
    public List<CategoryItem> getAllCategoryItem() {
        return service.getAllCategoryItem();
    }

    @Override
    public List<PublisherItem> getAllPublisherItem() {
        return service.getAllPublisherItem();
    }

    @Override
    public List<AgeItem> getAllAgeItem() {
        return service.getAllAgeItem();
    }
}
