package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Customer;
import com.yam.multimarketsystem.model.Card;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
  public List<Customer> findAll();
  public Optional<Customer> findByCard(Card card);
  public Optional<Customer> findById(Integer id);

}
