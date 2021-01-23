package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Shop;

import java.util.Optional;
import java.util.List;

public interface ShopRepository extends CrudRepository<Shop, Integer> {
  public List<Shop> findAll();
}
