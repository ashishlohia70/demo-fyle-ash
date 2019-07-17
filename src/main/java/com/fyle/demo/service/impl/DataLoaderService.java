package com.fyle.demo.service.impl;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static java.lang.Boolean.FALSE;
import static java.util.Arrays.asList;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fyle.demo.entity.Bank;
import com.fyle.demo.repository.BankRepository;

@Service
public class DataLoaderService {
  @Autowired
  private BankRepository bankRepository;
  @Value("classpath:data/bank-data.json")
  Resource resource;
  
  @PostConstruct
  public void loadData() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper om= new ObjectMapper();
    om.configure(FAIL_ON_UNKNOWN_PROPERTIES, FALSE);
    bankRepository.saveAll(asList(om.readValue(resource.getInputStream(), Bank[].class)));
  }
}
