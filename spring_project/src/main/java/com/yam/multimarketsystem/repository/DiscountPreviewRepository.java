package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.DiscountPreview;

import java.util.Optional;
import java.util.List;

public interface DiscountPreviewRepository extends CrudRepository<DiscountPreview, Integer> {
  Optional<DiscountPreview> findById(Integer id);
  List<DiscountPreview> findAll();
}
