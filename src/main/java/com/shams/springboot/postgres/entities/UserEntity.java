package com.shams.springboot.postgres.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "SA_USER")
@Getter
@Builder
public class UserEntity implements Serializable {
  private static final long serialVersionUID = -2343243243242432341L;

  public UserEntity() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  public UserEntity(long id, String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }
}
