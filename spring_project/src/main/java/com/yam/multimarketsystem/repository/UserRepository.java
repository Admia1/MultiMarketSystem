package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}
