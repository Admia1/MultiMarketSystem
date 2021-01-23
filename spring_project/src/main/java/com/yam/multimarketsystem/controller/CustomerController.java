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

@Controller
@RequestMapping(path="/cus")
public class CustomerController {
  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private CardRepository cardRepository;

  @PostMapping(path="/reg")
  public @ResponseBody String registerNewCustomer (@RequestParam String contact, @RequestParam String cardCode) {

    Optional<Person> o_person = personRepository.findByContact(contact);
    if(o_person.isEmpty()){
      return "Register yourself using contact first";
    }

    Optional<Card> o_card = cardRepository.findByCode(cardCode);
    if(o_card.isEmpty()){
      return "Bad card code";
    }

    if(customerRepository.findByCard(o_card.get()).isPresent()){
      return "This card is belonged to someone else";
    }

    Customer n_customer = new Customer();

    n_customer.setPerson(o_person.get());
    n_customer.setCard(o_card.get());

    customerRepository.save(n_customer);

    return "Registered";
  }

  @GetMapping("/{id}/info")
  public @ResponseBody Optional<Customer> getCustomerInfoById(@PathVariable(value = "id") Integer id){
    return customerRepository.findById(id);
  }


  @GetMapping(path="/all")
  public @ResponseBody Iterable<Customer> getCustomers() {
    return customerRepository.findAll();
  }
}
