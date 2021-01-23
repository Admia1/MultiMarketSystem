package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.SalesInvoice;
import com.yam.multimarketsystem.model.Shop;
import com.yam.multimarketsystem.model.Cashier;

import java.util.List;
import java.util.Optional;

public interface SalesInvoiceRepository extends CrudRepository<SalesInvoice, Integer> {
  public Optional<SalesInvoice> findById(Integer id);
  public List<SalesInvoice> findByShop(Shop shop);
  public List<SalesInvoice> findByCashier(Cashier cashier);
}
