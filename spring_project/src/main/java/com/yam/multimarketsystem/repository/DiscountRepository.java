package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Discount;

import java.util.Optional;
import java.util.List;

public interface DiscountRepository extends CrudRepository<Discount, Integer> {
  List<Discount> findAll();
}
