package com.yam.multimarketsystem;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.DiscountStrategy;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DiscountStrategyRepository extends CrudRepository<DiscountStrategy, Integer> {

}
