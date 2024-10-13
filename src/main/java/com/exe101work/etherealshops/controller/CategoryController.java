package com.exe101work.etherealshops.controller;

import com.exe101work.etherealshops.domain.response.ApiResponse;
import com.exe101work.etherealshops.entity.Category;
import com.exe101work.etherealshops.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category name) {
        Category category = categoryService.addCategory(name);
        return ResponseEntity.ok(ApiResponse.builder().message("Found!").data(category).build());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .data(categoryService.getCategoryById(categoryId)).build());
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(ApiResponse.builder()
                .code(HttpStatus.OK.value())
                .data(categoryService.getCategoryByName(name)).build());
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(ApiResponse.builder().data(categories).build());
    }

    @DeleteMapping("/category/{categoryId}/delete")
    public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.ok(ApiResponse.builder()
                .code(HttpStatus.OK.value()).build());
    }

}
