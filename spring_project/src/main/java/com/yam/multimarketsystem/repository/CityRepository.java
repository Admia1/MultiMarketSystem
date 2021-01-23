package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.City;
import java.util.List;
import java.util.Optional;



public interface CityRepository extends CrudRepository<City, Integer> {
  public List<City> findAll();
  public Optional<City> findById(Integer id);
}
