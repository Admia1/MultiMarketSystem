package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.DiscountStrategy;

import java.util.List;
import java.util.Optional;

public interface DiscountStrategyRepository extends CrudRepository<DiscountStrategy, Integer> {
  List<DiscountStrategy> findAll();
}
