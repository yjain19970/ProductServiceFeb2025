package com.scaler.productservice.repository;

import com.scaler.productservice.model.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
  Optional<Product> findById(Integer id);
}
