package com.example.services;

import com.example.commands.CreateCustomerCommand;
import com.example.commands.UpdateCustomerCommand;
import com.example.dto.CustomerNameDTO;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Singleton
public class CustomerService {
  private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Optional<Long> saveCustomer(CreateCustomerCommand customerCommand) {
    log.info("Saving Customer");
    Customer customer = customerCommand.createCustomer();
    customerRepository.save(customer);

    return Optional.of(customer.getId());
  }

  public List<Customer> getAllCustomers(Pageable pageable) {
    log.info("Get Pages of Customers");
    return customerRepository.findAll(pageable).getContent();
  }

  public Customer getCustomer(final Long id) {
    log.info("Get customer by id: {}", id);
    return customerRepository.findById(id).orElse(null);
  }

  public Customer updateCustomer(UpdateCustomerCommand customerCommand) {
    log.info("Update existing customer with id: {}", customerCommand.getId());
    return customerRepository.update(customerCommand.customerToUpdate());
  }

  public void deleteCustomer(final Long id) {
    log.info("Delete a customer with id: {}", id);
    customerRepository.deleteById(id);
  }

  public List<CustomerNameDTO> findCustomerByAgeGreaterThan(final int age) {
    log.info("Find all customer whose age is > {}", age);
    return customerRepository.findFirstnameAndLastnameByAgeGreaterThan(age);
  }
}
