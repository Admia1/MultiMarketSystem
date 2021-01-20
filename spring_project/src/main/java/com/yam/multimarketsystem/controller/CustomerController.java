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

import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/cus") // This means URL's start with /demo (after Application path)
public class CustomerController {
  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private CardRepository cardRepository;
  @Autowired
  private NameRepository nameRepository;

  @PostMapping(path="/reg") // Map ONLY POST Requests
  public @ResponseBody String registerNewCustomer (@RequestParam String name
      , @RequestParam String contact, @RequestParam String cardCode) {

    if(personRepository.findByContact(contact) != null){
      return "This Contact Have been Registered before";
    }

    Optional<Card> card = cardRepository.findByCode(cardCode);
    if(card == null){
      return "Bad card code";
    }

    Card toSetCard = card.get();

    if(customerRepository.findByCard(toSetCard) != null){
      return "This card is belonged to someone else";
    }

    Person n_person = new Person();
    Name n_name = new Name();
    Customer n_customer = new Customer();

    n_person.setContact(contact);
    n_name.setPerson(n_person);
    n_name.setName(name);
    n_customer.setPerson(n_person);
    n_customer.setCard(toSetCard);

    personRepository.save(n_person);
    customerRepository.save(n_customer);
    nameRepository.save(n_name);

    return "Registered";
  }

  @GetMapping("/{id}/info")
  public @ResponseBody Optional<Person> getCustomerById(@PathVariable(value = "id") Integer id){
    return personRepository.findById(id);
  }


  @GetMapping(path="/all")
  public @ResponseBody Iterable<Customer> getCustomers() {
    return customerRepository.findAll();
  }
}
