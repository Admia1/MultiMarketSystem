package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Address;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Integer> {
  public Optional<Address> findById(Integer id);
}
