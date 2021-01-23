package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Person;
import com.yam.multimarketsystem.model.Cashier;
import com.yam.multimarketsystem.model.Shop;

import java.util.Optional;
import java.util.List;


public interface CashierRepository extends CrudRepository<Cashier, Integer> {
  public Optional<Cashier> findById(Integer id);
  public List<Cashier> findByShop(Shop shop);
  public Optional<Cashier> findByPersonAndShop(Person person, Shop shop);
}
