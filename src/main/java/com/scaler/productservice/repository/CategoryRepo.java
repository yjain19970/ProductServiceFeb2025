package com.scaler.productservice.repository;

import com.scaler.productservice.model.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

  // JPA Query.
  Optional<Category> findByTitle(String title);

  Optional<Category> findById(Integer id);
}
