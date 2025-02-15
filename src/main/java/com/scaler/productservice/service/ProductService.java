package com.scaler.productservice.service;

import com.scaler.productservice.model.Product;
import java.util.List;


/**
 * This is an interface for my ProductService.
 */
public interface ProductService {
  Product getProductById(Integer id);

  List<Product> getAllProducts();

  Product createProduct(String title, String imageURL, String catTitle, String description);

}
