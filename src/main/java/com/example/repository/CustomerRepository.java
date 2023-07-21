package com.example.repository;

import com.example.dto.CustomerNameDTO;
import com.example.model.Customer;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface CustomerRepository extends PageableRepository<Customer, Long> {
  List<CustomerNameDTO> findFirstnameAndLastnameByAgeGreaterThan(final int age);
}
