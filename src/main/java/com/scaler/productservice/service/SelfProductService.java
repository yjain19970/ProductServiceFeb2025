package com.scaler.productservice.service;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.repository.CategoryRepo;
import com.scaler.productservice.repository.ProductRepo;
import com.scaler.productservice.repository.projection.ProductProjection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service("selfProductService")
public class SelfProductService implements ProductService {

  private ProductRepo productRepo;
  private CategoryRepo categoryRepo;

  public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
    this.productRepo = productRepo;
    this.categoryRepo = categoryRepo;
  }

  @Override
  public Product getProductById(Integer id) {
    Optional<Product> response = productRepo.findById(id);
    if (!response.isPresent()) {
      throw new IllegalArgumentException("Product not found");
    }
    System.out.println("Fetched product : " + response);
    return response.get();
  }

  @Override
  public List<Product> getAllProducts() {
    ProductProjection response = productRepo.getProductNameByTitle("phone samsung");
    System.out.println("Fetched product : " + response.getDescription() + " " + response.getTitle());
    return productRepo.findAll();
  }

  @Override
  public Product createProduct(String title, String imageURL, String catTitle, String description) {
    //Step1:
    validateInputRequest(title, imageURL, catTitle, description);

    // Step2:
    Product product = new Product();
    Category category = new Category();
    product.setImageURL(imageURL);
    product.setTitle(title);
    product.setCreatedAt(new Date());
    product.setUpdatedAt(new Date());
    product.setDescription(description);

    // Step3: check if cat exists in the DB
    Category existingCategory = categoryRepo.findByTitle(catTitle).get();
    if (existingCategory == null) {
      category.setTitle(catTitle);
    }
    // saved category also.
    product.setCategory(category);

    // Finally save to the DB.
    Product response = productRepo.save(product);
    return response;
  }

  private void validateInputRequest(String title, String imageURL, String catTitle, String description) {
    if (title == null || title.isEmpty()) {
      throw new IllegalArgumentException("Title cannot be null");
    }
    /**
     * Add other validations here.
     */
  }
}
