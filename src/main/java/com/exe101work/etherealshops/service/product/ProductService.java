package com.exe101work.etherealshops.service.product;

import com.exe101work.etherealshops.entity.Product;
import com.exe101work.etherealshops.exception.ProductNotFoundException;
import com.exe101work.etherealshops.repository.ProductRepository;
import com.exe101work.etherealshops.domain.request.AddProductVariantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(AddProductVariantRequest request) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete,
                () -> new ProductNotFoundException("Product not found!"));
    }

    @Override
    public void updateProduct(Product product, Long id) {

    }

    @Override
    public List<Product> getProductsByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrand(String brandName) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String categoryName, String brandName) {
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brandName, String name) {
        return List.of();
    }
}
