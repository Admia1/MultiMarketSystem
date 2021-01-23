package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.CardGeneration;

import java.util.List;
import java.util.Optional;

public interface CardGenerationRepository extends CrudRepository<CardGeneration, Integer> {
  public Optional<CardGeneration> findById(Integer Id);
  public List<CardGeneration> findAll();
}
