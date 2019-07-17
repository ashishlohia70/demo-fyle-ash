package com.fyle.demo.repository;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.fyle.demo.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
  Stream<Bank> findByCity(String city);

  @Query("select distinct b.city from Bank b")
  List<String> getCities();
}