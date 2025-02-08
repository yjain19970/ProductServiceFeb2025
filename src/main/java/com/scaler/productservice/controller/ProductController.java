package com.scaler.productservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

  @GetMapping("/products/{id}")
  public void getProductById(@PathVariable("id") Integer id) { // Path varible way to get params

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
