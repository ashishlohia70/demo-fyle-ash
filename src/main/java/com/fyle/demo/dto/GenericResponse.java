package com.fyle.demo.dto;

import lombok.Data;

@Data
public class GenericResponse {
  private boolean success = true;
  private Object response;
  private String error;

  public GenericResponse(Object response) {
    this.response = response;
  }

  public GenericResponse(String error) {
    this.success = false;
    this.error = error;
  }
}