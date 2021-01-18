package com.yam.multimarketsystem;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.DiscountTicket;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DiscountTicketRepository extends CrudRepository<DiscountTicket, Integer> {

}
