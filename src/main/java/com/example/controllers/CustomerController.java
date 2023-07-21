package com.example.controllers;

import com.example.commands.CreateCustomerCommand;
import com.example.commands.UpdateCustomerCommand;
import com.example.dto.CreateCustomerResponse;
import com.example.dto.CustomerNameDTO;
import com.example.model.Customer;
import com.example.services.CustomerService;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Controller
public class CustomerController {
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Get
  @Status(HttpStatus.OK)
  public List<Customer> index(@Valid Pageable pageable) {
    return customerService.getAllCustomers(pageable);
  }

  @Post
  @Produces(MediaType.APPLICATION_JSON)
  public HttpResponse<CreateCustomerResponse> createCustomer(@Body @Valid CreateCustomerCommand customerCommand) {
    Long customerId = customerService.saveCustomer(customerCommand).orElse(null);
    return HttpResponse.created(new CreateCustomerResponse(customerId));
  }

  @Get("/{id}")
  public Customer getCustomer(@PathVariable @NotNull Long id) {
    return customerService.getCustomer(id);
  }

  @Put("/{id}")
  public Customer updateCustomer(@Body UpdateCustomerCommand updateCustomerCommand) {
    return customerService.updateCustomer(updateCustomerCommand);
  }

  @Delete("/{id}")
  public HttpResponse<String> deleteCustomer(@PathVariable @NotNull final Long id) {
    customerService.deleteCustomer(id);
    return HttpResponse.ok("Deleted Successfully");
  }

  @Get("/filter")
  public List<CustomerNameDTO> findCustomerNamesByAgeGreaterThan(@QueryValue final int age) {
    return customerService.findCustomerByAgeGreaterThan(age);
  }
}
