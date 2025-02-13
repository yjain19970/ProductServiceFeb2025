package com.scaler.productservice.model;

import jakarta.persistence.Entity;


@Entity
public class Category extends BaseModel {
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
