package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.CustomerSalesInvoice;
import com.yam.multimarketsystem.model.SalesInvoice;
import com.yam.multimarketsystem.model.Customer;

import java.util.Optional;
import java.util.List;

public interface CustomerSalesInvoiceRepository extends CrudRepository<CustomerSalesInvoice, Integer> {
  public List<CustomerSalesInvoice> findByCustomer(Customer customer);
  public Optional<CustomerSalesInvoice> findBySalesInvoice(SalesInvoice salesInvoice);
}
