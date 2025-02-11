package com.scaler.productservice.advise;

import com.scaler.productservice.dto.ErrorDTO;
import com.scaler.productservice.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdvise {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorDTO> handleIllegalArgumentException() {
    ErrorDTO errorDTO = new ErrorDTO();
    errorDTO.setErrorCode("400");
    errorDTO.setErrorMsg("Bad Request");

    return ResponseEntity.badRequest().body(errorDTO);
  }

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ErrorDTO> handleProductNotFoundException() {
    ErrorDTO errorDTO = new ErrorDTO();
    errorDTO.setErrorCode("404");
    errorDTO.setErrorMsg("Product Not found");

    return ResponseEntity.badRequest().body(errorDTO);
  }
}
