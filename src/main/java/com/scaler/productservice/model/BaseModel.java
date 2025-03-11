package com.scaler.productservice.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


/**
 * @author yashjain
 */
@MappedSuperclass
@Getter
@Setter
public class BaseModel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) // AutoIncreament part
  private Integer id;

  private Date createdAt;
  private Date updatedAt;
  private boolean isDeleted;
  private String createdByUserName;
}
