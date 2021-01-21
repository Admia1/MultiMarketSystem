package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.DiscountStrategy;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DiscountStrategyRepository extends CrudRepository<DiscountStrategy, Integer> {

}