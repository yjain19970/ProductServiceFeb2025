package com.scaler.productservice.repository;

import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import com.scaler.productservice.repository.projection.ProductProjection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

  /**
   * I will write a HQL Query.
   *
   * USecase: GetProductNameByTitle
   */

  @Query("select p.title, p.description from Product p where p.title =:title")
  ProductProjection getProductNameByTitle(@Param("title") String title);

  @Query("select p from Product p where p.title =:title and p.id =:id")
  Product getProductByTitleAndByProductId(@Param("title") String title, @Param("id") Integer id);

  @Query("select p.title, p.description from Product p where p.id>10")
  List<ProductProjection> getProductNameGreaterThanIDValue(@Param("id") Integer id);
}
