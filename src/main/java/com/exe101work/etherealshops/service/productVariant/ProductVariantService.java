package com.exe101work.etherealshops.service.productVariant;

import com.exe101work.etherealshops.domain.request.AddProductVariantRequest;
import com.exe101work.etherealshops.entity.ProductVariant;
import com.exe101work.etherealshops.exception.ResourceNotFoundException;
import com.exe101work.etherealshops.repository.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductVariantService implements IProductVariantService{

    private final ProductVariantRepository productVariantRepository;

    @Override
    public ProductVariant addProductVariant(AddProductVariantRequest productVariant) {
        return null;
    }

    @Override
    public List<ProductVariant> getAllProductVariants() {
        return List.of();
    }

    @Override
    public ProductVariant getProductVariantById(Long id) {
        return productVariantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product variant not found"));
    }

    @Override
    public void deleteProductVariant(Long id) {

    }

    @Override
    public void updateProductVariant(ProductVariant product, Long id) {

    }

    @Override
    public List<ProductVariant> getProductVariantsByName(String name) {
        return List.of();
    }

    @Override
    public List<ProductVariant> getProductVariantsByCategory(String categoryName) {
        return List.of();
    }

    @Override
    public List<ProductVariant> getProductVariantsByBrand(String brandName) {
        return List.of();
    }

    @Override
    public List<ProductVariant> getProductVariantsByCategoryAndBrand(String categoryName, String brandName) {
        return List.of();
    }

    @Override
    public List<ProductVariant> getProductVariantsByBrandAndName(String brandName, String name) {
        return List.of();
    }
}
