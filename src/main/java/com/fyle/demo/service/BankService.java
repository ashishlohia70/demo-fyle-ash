package com.fyle.demo.service;

import com.fyle.demo.dto.GenericResponse;

public interface BankService {
  /**
   * find data By City
   * 
   * @param city
   * @return
   * @throws RuntimeException
   */
  GenericResponse findByCity(String city) throws RuntimeException;

  /**
   * get all Cities
   * 
   * @return
   * @throws RuntimeException
   */
  GenericResponse getCities() throws RuntimeException;
}
