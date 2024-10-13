package com.exe101work.etherealshops.service.productVariant;

import com.exe101work.etherealshops.domain.request.AddProductVariantRequest;
import com.exe101work.etherealshops.entity.ProductVariant;

import java.util.List;

public interface IProductVariantService {
    ProductVariant addProductVariant(AddProductVariantRequest productVariant);
    List<ProductVariant> getAllProductVariants();
    ProductVariant getProductVariantById(Long id);
    void deleteProductVariant(Long id);
    void updateProductVariant(ProductVariant product, Long id);
    List<ProductVariant> getProductVariantsByName(String name);
    List<ProductVariant> getProductVariantsByCategory(String categoryName);
    List<ProductVariant> getProductVariantsByBrand(String brandName);
    List<ProductVariant> getProductVariantsByCategoryAndBrand(String categoryName, String brandName);
    List<ProductVariant> getProductVariantsByBrandAndName(String brandName, String name);
}
