package com.exe101work.etherealshops.repository;

import com.exe101work.etherealshops.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByName(String name);
    Optional<Category> findByName(String name);

}
