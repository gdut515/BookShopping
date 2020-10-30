package net.gdut.service.impl;

import net.gdut.bean.classification.AgeItem;
import net.gdut.bean.classification.CategoryItem;
import net.gdut.bean.classification.PublisherItem;
import net.gdut.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationImpl implements ClassificationService {

    @Override
    public void addCategoryItem(CategoryItem categoryItem) {

    }

    @Override
    public void addPublisherItem(PublisherItem publisherItem) {

    }

    @Override
    public void addAgeItem(AgeItem ageItem) {

    }

    @Override
    public void deleteCategoryItem(int no) {

    }

    @Override
    public void deletePublisherItem(int no) {

    }

    @Override
    public void deleteAgeItem(int no) {

    }

    @Override
    public List<CategoryItem> getAllCategoryItem() {
        return null;
    }

    @Override
    public List<PublisherItem> getAllPublisherItem() {
        return null;
    }

    @Override
    public List<AgeItem> getAllAgeItem() {
        return null;
    }
}
