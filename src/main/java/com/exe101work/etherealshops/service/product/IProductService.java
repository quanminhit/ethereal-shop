package com.exe101work.etherealshops.service.product;

import com.exe101work.etherealshops.entity.Product;
import com.exe101work.etherealshops.domain.request.AddProductVariantRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductVariantRequest product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);
    void updateProduct(Product product, Long id);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByCategory(String categoryName);
    List<Product> getProductsByBrand(String brandName);
    List<Product> getProductsByCategoryAndBrand(String categoryName, String brandName);
    List<Product> getProductsByBrandAndName(String brandName, String name);
}
