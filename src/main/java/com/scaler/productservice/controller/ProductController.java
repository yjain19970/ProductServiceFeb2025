package com.scaler.productservice.controller;

import com.scaler.productservice.model.Product;
import com.scaler.productservice.service.FakeStoreProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
  private FakeStoreProductService service;

  public ProductController(FakeStoreProductService inputService) {
    this.service = inputService;
  }

  @GetMapping("/products/{id}")
  public Product getProductById(@PathVariable("id") Integer id) {
    // validations
    if (id == null) {
      throw new IllegalArgumentException("Id cannot be null");
    }

    return service.getProductById(id);
  }

  @PostMapping("/products")
  public void createProduct() {

  }

  @GetMapping("/products")
  public void getAllProducts() {

  }

  @PutMapping("/products/{id}")
  public void UpdateProduct(@PathVariable("id") Integer id) {

  }

  @DeleteMapping("/products/{id}")
  public void deleteProductById(@PathVariable("id") Integer id) {

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
