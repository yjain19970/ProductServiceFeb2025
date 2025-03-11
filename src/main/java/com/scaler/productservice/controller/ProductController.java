package com.scaler.productservice.controller;

import com.scaler.productservice.dto.CreateProductRequestDto;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.service.ProductService;
import java.util.List;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

  private ProductService service;

  public ProductController(@Qualifier("selfProductService") ProductService inputService) {
    this.service = inputService;
  }

  @GetMapping("/products/{id}")
  @Cacheable(value = "product", key = "#id")
  public Product getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
    if (id == 10000) {
      throw new IllegalArgumentException("Id should not be 10000");
    }

    Product product = service.getProductById(id); // service = new SelfProductService()
    if (product == null) {
      throw new ProductNotFoundException("Product not found");
    }

    return product;
  }

  @PostMapping("/products")
  @CachePut(value = "product", key = "#result.title")
  public Product createProduct(@RequestBody CreateProductRequestDto request) {
    // you can do validations
    if (request.getDescription() == null) {
      throw new IllegalArgumentException("Description cannot be null");
    }
    if (request.getTitle() == null) {
      throw new IllegalArgumentException("Title cannot be null");
    }

    return service.createProduct(request.getTitle(), request.getImageURL(), request.getCategory().getTitle(),
        request.getDescription());
  }

  /**
   * For  below APIs implement caching by own.
   * @return
   */




  @GetMapping("/products")
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = service.getAllProducts();
    //throw new RuntimeException();

    return ResponseEntity.ok(products); // HttpStatus code is 200.
  }

  @PutMapping("/products/{id}")
  public void UpdateProduct(@PathVariable("id") Integer id) {

  }

  @DeleteMapping("/products/{id}")
  public void deleteProductById(@PathVariable("id") Integer id) {

  }

  @GetMapping("/products/{pageNo}/{pageSize}")
  public ResponseEntity<Page<Product>> getPaginatedProducts(@PathVariable("pageNo") int pageNo,
      @PathVariable("pageSize") int pageSize) {
    Page<Product> products = service.getPaginatedProducts(pageNo, pageSize);
    return ResponseEntity.ok(products);
  }

  /**
   *
   *
   * {
   * 	"id" : "value",
   * 	"title" : "value",
   * 	"decription" : "descriptionv alue"
   * }
   *
   */
}
