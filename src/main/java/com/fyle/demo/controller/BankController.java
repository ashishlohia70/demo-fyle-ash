package com.fyle.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fyle.demo.dto.GenericResponse;
import com.fyle.demo.service.BankService;

@RequestMapping("/banks")
@RestController
public class BankController {
  @Autowired
  private BankService bankService;

  /**
   * find data By City
   * 
   * @param city
   * @return
   */
  @GetMapping("/findByCity")
  public ResponseEntity<GenericResponse> findByCity(@RequestParam String city) {
    return ResponseEntity.ok(bankService.findByCity(city));
  }

  /**
   * get all Cities
   * 
   * @return
   */
  @GetMapping("/getCities")
  public ResponseEntity<GenericResponse> getCities() {
    return ResponseEntity.ok(bankService.getCities());
  }

  /**
   * generic method to handle exception
   * 
   * @param ex
   * @return
   */
  @ExceptionHandler
  public ResponseEntity<GenericResponse> handleException(RuntimeException ex) {
    return ResponseEntity.ok(new GenericResponse(ex.getMessage()));
  }
}
