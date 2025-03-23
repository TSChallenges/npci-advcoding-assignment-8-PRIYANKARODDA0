package com.mystore.app.service;

import com.mystore.app.entity.Product;
import com.mystore.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private Integer currentId = 1;

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        product.setId(currentId++);
        productRepository.save(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);  // Return null if the product doesn't exist
    }

    public Product updateProduct(Integer id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isEmpty()) return null;

        Product p = existingProduct.get();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setCategory(product.getCategory());
        p.setStockQuantity(product.getStockQuantity());
        productRepository.save(p);
        return p;
    }

    public String deleteProduct(Integer id) {
        Optional<Product> p = productRepository.findById(id);
        if (p.isEmpty()) return "Product Not Found";
        productRepository.delete(p.get());
        return "Product Deleted Successfully";
    }

    // Search products by name (case-insensitive)
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameIgnoreCaseContaining(name);
    }

    // Filter products by category
    public List<Product> filterProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // Filter products by price range
    public List<Product> filterProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    // Filter products by stock quantity range
    public List<Product> filterProductsByStockRange(Integer minStock, Integer maxStock) {
        return productRepository.findByStockQuantityBetween(minStock, maxStock);
    }

    // Pagination and Sorting (provided in controller, but we can leave this here as well)
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
