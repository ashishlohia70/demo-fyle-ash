package com.fyle.demo.service.impl;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.fyle.demo.dto.BankDto;
import com.fyle.demo.dto.GenericResponse;
import com.fyle.demo.entity.Bank;
import com.fyle.demo.repository.BankRepository;

@RunWith(MockitoJUnitRunner.class)
public class BankServiceimplTest {

  private static final String TEST = "test";
  @Mock
  private BankRepository bankRepository;
  @InjectMocks
  private BankServiceimpl bankService;

  @Test
  public final void testFindByCity() {
    Bank bank = new Bank();
    bank.setCity(TEST);
    when(bankRepository.findByCity(TEST)).thenReturn(Stream.of(bank));
    GenericResponse genericResponse = bankService.findByCity(TEST);
    List<BankDto> response = (List<BankDto>) genericResponse.getResponse();
    assert genericResponse.isSuccess();
    assertEquals(response.iterator().next().getCity(), TEST);
  }

  @Test
  public final void testGetCities() {
    when(bankRepository.getCities()).thenReturn(asList(TEST));
    GenericResponse genericResponse = bankService.getCities();
    List<String> response = (List<String>) genericResponse.getResponse();
    assert genericResponse.isSuccess();
    assertEquals(response.iterator().next(), TEST);

  }

}
