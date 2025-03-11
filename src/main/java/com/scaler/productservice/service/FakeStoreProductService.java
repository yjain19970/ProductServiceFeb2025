package com.scaler.productservice.service;

import com.scaler.productservice.dto.FakeStoreResponseDTO;
import com.scaler.productservice.model.Category;
import com.scaler.productservice.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
  private RestTemplate restTemplate;

  public FakeStoreProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public Product getProductById(Integer id) {
    Product product = new Product();

    // 1. Call Fakestore API --> Use RestTemplate.
    ResponseEntity<FakeStoreResponseDTO> fakeStoreResponse =
        restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreResponseDTO.class);

    // 2. Get the response
    FakeStoreResponseDTO response = fakeStoreResponse.getBody();
    if (response == null) {
      throw new IllegalArgumentException("FakeStoreProduct not found!!");
    }

    //3. Convert the response to product model
    product = convertFakeStoreResponseToProduct(response);
    return product;
  }

  private Product convertFakeStoreResponseToProduct(FakeStoreResponseDTO response) {
    Product product = new Product();
    Category category = new Category();
    category.setTitle(response.getCategory());

    product.setId(response.getId());
    product.setCategory(category);
    product.setDescription(response.getDescription());
    product.setImageURL(response.getImage());
    product.setTitle(response.getTitle());

    return product;
  }

  @Override
  public List<Product> getAllProducts() {
    List<Product> response = new ArrayList<>();
    ResponseEntity<FakeStoreResponseDTO[]> fakeStoreProducts =
        restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreResponseDTO[].class);

    System.out.println("Status code: " + fakeStoreProducts.getStatusCode());
    // next step:
    for (FakeStoreResponseDTO fakeStoreDTO : fakeStoreProducts.getBody()) {
      response.add(convertFakeStoreResponseToProduct(fakeStoreDTO));
    }

    return response;
  }

  @Override
  public Product createProduct(String title, String imageURL, String catTitle, String description) {
    Product response;

    FakeStoreResponseDTO requestBody = new FakeStoreResponseDTO();
    requestBody.setCategory(catTitle);
    requestBody.setDescription(description);
    requestBody.setTitle(title);
    requestBody.setImage(imageURL);

    ResponseEntity<FakeStoreResponseDTO> fakeStoreResponse =
        restTemplate.postForEntity("https://fakestoreapi.com/products", requestBody, FakeStoreResponseDTO.class);

    System.out.println("Status code: " + fakeStoreResponse.getStatusCode());

    response = convertFakeStoreResponseToProduct(fakeStoreResponse.getBody());
    return response;
  }

  @Override
  public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {
    // dummy implementation.
    return null;
  }
}

/**
 * @RestController
 * @Service
 * @Repository
 * @Component
 * @Controller
 * @Bean
 *
 *
 *
 *
 *
 * {
 * id:1,
 * title:'...',
 * price:'...', XX
 * category:'...', // String
 * description:'...',
 * image:'...'
 * }
 *
 */
