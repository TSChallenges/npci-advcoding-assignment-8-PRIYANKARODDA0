package com.mystore.app.repositories;

import com.mystore.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Search products by name (case-insensitive)
    List<Product> findByNameIgnoreCaseContaining(String name);

    // Filter products by category
    List<Product> findByCategory(String category);

    // Filter products by price range
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    // Filter products by stock quantity range
    List<Product> findByStockQuantityBetween(Integer minStock, Integer maxStock);

    // Pagination and Sorting (using Pageable)
    Page<Product> findAll(Pageable pageable);
}
