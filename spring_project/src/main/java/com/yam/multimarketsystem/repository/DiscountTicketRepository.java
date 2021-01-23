package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.DiscountTicket;
import com.yam.multimarketsystem.model.Customer;

import java.util.List;
import java.util.Optional;

public interface DiscountTicketRepository extends CrudRepository<DiscountTicket, Integer> {
  List<DiscountTicket> findByCustomer(Customer customer);
}
