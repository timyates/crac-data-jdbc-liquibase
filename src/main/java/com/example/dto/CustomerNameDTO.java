package com.example.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class CustomerNameDTO {
  private final String firstname;
  private final String lastname;

  public CustomerNameDTO(String firstName, String lastName) {
    this.firstname = firstName;
    this.lastname = lastName;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }
}
