package com.yam.multimarketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yam.multimarketsystem.repository.CardRepository;
import com.yam.multimarketsystem.repository.NameRepository;
import com.yam.multimarketsystem.repository.CustomerRepository;
import com.yam.multimarketsystem.repository.PersonRepository;

import com.yam.multimarketsystem.model.Card;
import com.yam.multimarketsystem.model.Name;
import com.yam.multimarketsystem.model.Customer;
import com.yam.multimarketsystem.model.Person;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;


@Controller // This means that this class is a Controller
@RequestMapping(path="/cus") // This means URL's start with /demo (after Application path)
public class CustomerController {
  @Autowired
  private PersonRepository personRepository;
  private CustomerRepository customerRepository;
  private CardRepository cardRepository;
  private NameRepository nameRepository;

  @PostMapping(path="/reg") // Map ONLY POST Requests
  public @ResponseBody String registerNewCustomer (@RequestParam String name
      , @RequestParam String Contact, @RequestParam String cardCode) {

    if(personRepository.findByContact(Contact) != null){
      return "This Contact Have been Registered before";
    }

    Card card = CardRepository.findByCode(cardcode);
    if(card == null){
      return "Bad card code";
    }

    if(customerRepository.findByCard(card) != null){
      return "This card is belonged to someone else";
    }

    Person n_person = new Person();
    Name n_name = new Name();
    Customer n_customer = new Customer();

    n_person.setContact(contact);
    n_name.setPerson(n_person);
    n_name.setName(name);
    n_customer.setPerson(n_person);
    n_customer.setCard(card);

    personRepository.save(n_person);
    customerRepository.save(n_customer);
    nameRepository.save(n_name);

  }

  @GetMapping("/{id}/info")
  public ResponseEntity<Person> getCustomerById(@PathVariable(value = "id") Integer id){
   Person person = personRepository.findById(id);
   return ResponseEntity.ok().body(employee);
  }

  @getMapping(path="/info")
  public @ResponseBody Iterable<Customer> getCustomers() {
    return CustomerRepository.findAll();
  }
}
