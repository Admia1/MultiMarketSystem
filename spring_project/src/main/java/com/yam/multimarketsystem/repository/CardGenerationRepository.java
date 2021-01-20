package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.CardGeneration;

import java.util.List;
import java.util.Optional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CardGenerationRepository extends CrudRepository<CardGeneration, Integer> {
  public Optional<CardGeneration> findById(Integer Id);
  public List<CardGeneration> findAll();
}
