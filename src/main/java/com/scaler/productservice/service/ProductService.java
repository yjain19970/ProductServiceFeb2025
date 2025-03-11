package com.scaler.productservice.service;

import com.scaler.productservice.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;


/**
 * This is an interface for my ProductService.
 */
public interface ProductService {
  Product getProductById(Integer id);

  List<Product> getAllProducts();

  Product createProduct(String title, String imageURL, String catTitle, String description);

  Page<Product> getPaginatedProducts(int pageNo, int pageSize);
}
