package com.example.commands;

import com.example.model.Customer;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Introspected
public class UpdateCustomerCommand {
  @Id @NotNull @NotBlank
  private final Long id;
  private String firstname;
  private String lastname;
  private String emailAddress;
  private int age;

  public UpdateCustomerCommand(Long id) {
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

  public Long getId() {
    return id;
  }

  public Customer customerToUpdate() {
    Customer customer = new Customer(
      getFirstname(),
      getLastname(),
      getEmailAddress(),
      getAge()
    );

    customer.setId(getId());

    return customer;
  }
}
