package com.exe101work.etherealshops.service.category;

import com.exe101work.etherealshops.entity.Category;
import com.exe101work.etherealshops.exception.AlreadyExistsException;
import com.exe101work.etherealshops.exception.ResourceNotFoundException;
import com.exe101work.etherealshops.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
     return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository::save)
                .orElseThrow(() -> new AlreadyExistsException(category.getName() + " have existed already!"));
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " not found!"));
    }

    @Override
    public Category getCategoryByName(String name) {
        return this.categoryRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException(name + " not found!"));
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {
        Category category = this.getCategoryById(id);
        this.categoryRepository.delete(category);
    }
}
