package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.Name;
import com.yam.multimarketsystem.model.Person;

import java.util.List;
import java.util.Optional;

public interface NameRepository extends CrudRepository<Name, Integer> {
  List<Name> findByPerson(Person person);

}
