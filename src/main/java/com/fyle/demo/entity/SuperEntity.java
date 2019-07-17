package com.fyle.demo.entity;

import java.security.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fyle.demo.utils.Constants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuperEntity {
  @CreationTimestamp
  private Timestamp createdAt;
  @UpdateTimestamp
  private Timestamp updatedAt;
  private String createdBy = Constants.SYSTEM;
  private String updatedBy = Constants.SYSTEM;
}
