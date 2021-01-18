package com.yam.multimarketsystem;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.Name;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NameRepository extends CrudRepository<Name, Integer> {

}
