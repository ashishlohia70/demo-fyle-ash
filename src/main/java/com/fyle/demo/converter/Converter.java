package com.fyle.demo.converter;

import static org.springframework.beans.BeanUtils.copyProperties;
import com.fyle.demo.dto.BankDto;
import com.fyle.demo.entity.Bank;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Converter {
  public static BankDto convert(Bank bank) {
    BankDto dto = new BankDto();
    copyProperties(bank, dto);
    return dto;
  }
}