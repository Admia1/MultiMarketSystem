package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Person;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person, Integer> {
  Optional<Person> findByContact(String firstName);
}
