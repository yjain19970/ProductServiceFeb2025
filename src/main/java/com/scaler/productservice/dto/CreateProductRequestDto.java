package com.scaler.productservice.dto;

public class CreateProductRequestDto {
  private String title;
  private String imageURL;
  private String description;
  private CategoryRequestDTO category;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CategoryRequestDTO getCategory() {
    return category;
  }

  public void setCategory(CategoryRequestDTO category) {
    this.category = category;
  }
}
