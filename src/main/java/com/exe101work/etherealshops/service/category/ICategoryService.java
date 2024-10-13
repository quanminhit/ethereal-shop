package com.exe101work.etherealshops.service.category;

import com.exe101work.etherealshops.entity.Category;

import java.util.List;

public interface ICategoryService {

    Category addCategory(Category category);

    Category getCategoryById(Long id);

    Category getCategoryByName(String name);

    List<Category> getAllCategories();

    Category updateCategory(Category category);

    void deleteCategoryById(Long id);

}
