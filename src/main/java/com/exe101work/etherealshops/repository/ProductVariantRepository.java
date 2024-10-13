package com.exe101work.etherealshops.repository;

import com.exe101work.etherealshops.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}
