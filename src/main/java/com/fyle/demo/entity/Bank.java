package com.fyle.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bank extends SuperEntity {
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private long id;
  private String bank_name;
  private String branch;
  private String ifsc;
  private String address;
  private String city;
  private String district;
  private String state;
}
