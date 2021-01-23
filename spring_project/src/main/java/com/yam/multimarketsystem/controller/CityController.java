package com.yam.multimarketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import com.yam.multimarketsystem.repository.CityRepository;

import com.yam.multimarketsystem.model.City;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/city")
public class CityController {
  @Autowired
  private CityRepository cityRepository;

  @PostMapping(path="/reg")
  public @ResponseBody String registerNewCity (@RequestParam String name){

    City n_city = new City();

    n_city.setName(name);

    cityRepository.save(n_city);

    return "City registered";
  }

  @GetMapping("/{id}/info")
  public @ResponseBody Optional<City> getCityById(@PathVariable(value = "id") Integer cityId){
    return cityRepository.findById(cityId);
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<City> getCities() {
    return cityRepository.findAll();
  }

}
