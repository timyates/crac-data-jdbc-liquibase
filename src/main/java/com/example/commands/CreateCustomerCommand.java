package com.example.commands;

import com.example.model.Customer;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Introspected
public class CreateCustomerCommand {
  @NotNull @NotBlank
  private final String firstname;
  @NotNull @NotBlank
  private final String lastname;
  @NotNull @NotBlank
  private final String emailAddress;
  private final int age;

  public CreateCustomerCommand(@NonNull String firstname, @NonNull String lastname, @NonNull String emailAddress, int age) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.emailAddress = emailAddress;
    this.age = age;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public int getAge() {
    return age;
  }

  public Customer createCustomer() {
    return new Customer(
      getFirstname(),
      getLastname(),
      getEmailAddress(),
      getAge()
    );
  }
}
