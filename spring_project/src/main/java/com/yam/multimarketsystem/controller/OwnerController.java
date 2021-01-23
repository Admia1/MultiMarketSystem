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

import com.yam.multimarketsystem.repository.PersonRepository;
import com.yam.multimarketsystem.repository.CashierRepository;
import com.yam.multimarketsystem.repository.OwnerRepository;
import com.yam.multimarketsystem.repository.ShopRepository;
import com.yam.multimarketsystem.repository.AddressRepository;
import com.yam.multimarketsystem.repository.CityRepository;
import com.yam.multimarketsystem.repository.NameRepository;


import com.yam.multimarketsystem.model.Person;
import com.yam.multimarketsystem.model.Cashier;
import com.yam.multimarketsystem.model.Owner;
import com.yam.multimarketsystem.model.Shop;
import com.yam.multimarketsystem.model.Address;
import com.yam.multimarketsystem.model.City;
import com.yam.multimarketsystem.model.Name;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/shop")
public class OwnerController {
  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private CashierRepository cashierRepository;
  @Autowired
  private OwnerRepository ownerRepository;
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private AddressRepository addressRepository;
  @Autowired
  private CityRepository cityRepository;


  @PostMapping(path="/reg")
  public @ResponseBody String registerNewShop (@RequestParam Integer personId, @RequestParam String shopName, @RequestParam String addressDetail, @RequestParam Integer cityId){

    Optional<Person> o_person = personRepository.findById(personId);
    if(o_person.isEmpty())
      return "Bad person id";

    Optional<City> o_city = cityRepository.findById(cityId);
    if(o_city.isEmpty())
      return "Bad city id";

    Owner n_owner = new Owner();
    Shop n_shop = new Shop();
    Address n_address = new Address();

    n_owner.setPerson(o_person.get());
    n_owner.setShop(n_shop);
    n_shop.setName(shopName);
    n_shop.setAddress(n_address);
    n_address.setDetail(addressDetail);
    n_address.setCity(o_city.get());

    addressRepository.save(n_address);
    shopRepository.save(n_shop);
    ownerRepository.save(n_owner);

    return "Shop registered";
  }

  @GetMapping("/{id}/shop")
  public @ResponseBody Optional<Shop> getShopInfoById(@PathVariable(value = "id") Integer shopId){
    return shopRepository.findById(shopId);
  }

  @GetMapping("/{id}/owner")
  public @ResponseBody Optional<Owner> getOwnerInfoById(@PathVariable(value = "id") Integer ownerId){
    return ownerRepository.findById(ownerId);
  }

  @GetMapping(path="/allowners")
  public @ResponseBody Iterable<Owner> getOwners() {
    return ownerRepository.findAll();
  }

  @GetMapping(path="/allshops")
  public @ResponseBody Iterable<Shop> getShops() {
    return shopRepository.findAll();
  }

  @PostMapping("/{id}/addCashier")
  public @ResponseBody String registereNewCashier(@RequestParam String contact , @PathVariable(value = "id") Integer shopId){
    Person person;
    Optional<Person> o_person = personRepository.findByContact(contact);
    if(o_person.isEmpty()){
      Person n_person = new Person();
      n_person.setContact(contact);
      personRepository.save(n_person);
      person = n_person;
    }

    else
      person = o_person.get();

    Optional<Shop> o_shop = shopRepository.findById(shopId);
    if(o_shop.isEmpty())
      return "Bad Shop id";

    if (cashierRepository.findByPersonAndShop(person, o_shop.get()).isPresent())
      return "Thos person is allredy registered in this shop";

    Cashier n_cashier = new Cashier();
    n_cashier.setPerson(person);
    n_cashier.setShop(o_shop.get());
    cashierRepository.save(n_cashier);

    return "Cashier registered";

  }

  @PostMapping("/{id}/allCashiers")
  public @ResponseBody Iterable<Cashier> getAllCashiersOfShop(@PathVariable(value = "id") Integer shopId){
    Optional<Shop> o_shop = shopRepository.findById(shopId);
    if(o_shop.isEmpty())
      return null;

    return cashierRepository.findByShop(o_shop.get());
  }
}
