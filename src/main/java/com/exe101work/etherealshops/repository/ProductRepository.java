package com.exe101work.etherealshops.repository;

import com.exe101work.etherealshops.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
