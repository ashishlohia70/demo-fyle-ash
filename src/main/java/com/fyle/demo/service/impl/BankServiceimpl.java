package com.fyle.demo.service.impl;

import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fyle.demo.converter.Converter;
import com.fyle.demo.dto.GenericResponse;
import com.fyle.demo.entity.Bank;
import com.fyle.demo.repository.BankRepository;
import com.fyle.demo.service.BankService;

@Service
@Transactional
public class BankServiceimpl implements BankService {

  @Autowired
  private BankRepository bankRepository;

  @Override
  public GenericResponse findByCity(String city) throws RuntimeException {
    try (Stream<Bank> findByCity = bankRepository.findByCity(city)) {
      return new GenericResponse(findByCity.map(Converter::convert).collect(toList()));
    }
  }

  @Override
  public GenericResponse getCities() throws RuntimeException {
    return new GenericResponse(bankRepository.getCities());
  }
}
