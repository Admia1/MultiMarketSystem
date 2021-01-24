package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.ScoreStrategy;

import java.util.List;
import java.util.Optional;

public interface ScoreStrategyRepository extends CrudRepository<ScoreStrategy, Integer> {
  List<ScoreStrategy> findAllByOrderByIdDesc();
}
