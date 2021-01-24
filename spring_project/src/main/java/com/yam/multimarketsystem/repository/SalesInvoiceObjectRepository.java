package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.SalesInvoiceObject;
import com.yam.multimarketsystem.model.SalesInvoice;

import java.util.List;
import java.util.Optional;

public interface SalesInvoiceObjectRepository extends CrudRepository<SalesInvoiceObject, Integer> {
  List<SalesInvoiceObject> findBySalesInvoice(SalesInvoice salesInvoice);
  Optional<SalesInvoiceObject> findByIdAndSalesInvoice(Integer id, SalesInvoice salesInvoice);
}
