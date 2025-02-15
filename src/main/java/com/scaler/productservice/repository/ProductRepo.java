package com.scaler.productservice.repository;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
  // Select * from products where id = id;
  Optional<Product> findById(Integer id);

  Product save(Product p);

  Optional<Product> findByCategory(Category c);

  // Select * from products where id = id and category = c;
  Optional<Product> findByIdAndCategory(Integer id, Category c);

  Optional<List<Product>> findAllByCategory(Category c);

  void deleteById(Integer id);

  void deleteAllByCategory(Category c);
}
