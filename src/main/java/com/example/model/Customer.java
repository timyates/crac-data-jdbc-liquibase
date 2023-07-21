package com.example.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotNull;

@MappedEntity
public class Customer {

  @Id
  @GeneratedValue(GeneratedValue.Type.AUTO)
  private Long id;

  @NotNull
  private String firstname;

  @NotNull
  private String lastname;

  @NotNull
  private String emailAddress;

  private int age;

  public Customer(String firstname, String lastname, String emailAddress, int age) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.emailAddress = emailAddress;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
