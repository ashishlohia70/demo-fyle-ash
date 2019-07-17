package com.fyle.demo.dto;

import lombok.Data;

@Data
public class BankDto {
  private long id;
  private String bank_name;
  private String branch;
  private String ifsc;
  private String address;
  private String city;
  private String district;
  private String state;
}
