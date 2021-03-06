package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Card;
import com.yam.multimarketsystem.model.CardGeneration;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Integer> {
  public Optional<Card> findById(Integer Id);
  public List<Card> findAll();
  public Optional<Card> findByCode(String code);
  public List<Card> findByCardGeneration(CardGeneration cardGeneration);
}
