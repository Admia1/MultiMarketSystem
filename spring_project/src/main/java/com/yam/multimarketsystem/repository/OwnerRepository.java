package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Owner;
import com.yam.multimarketsystem.model.Shop;

import java.util.List;
import java.util.Optional;


public interface OwnerRepository extends CrudRepository<Owner, Integer> {
  public Optional<Owner> findByShop(Shop shop);
}
