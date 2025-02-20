package com.scaler.productservice.repository.projection;

import org.apache.logging.log4j.util.Strings;


public interface ProductProjection {
  // assume there are fields from Product model here.
  // so you are defining the getters here.

  String getTitle();

  Integer getId();

  Strings getDescription();

  //  String getDesc(); // THIS IS WRONG...
}
