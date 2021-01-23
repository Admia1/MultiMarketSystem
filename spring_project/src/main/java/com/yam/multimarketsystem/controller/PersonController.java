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
@RequestMapping(path="/per")
public class PersonController {
  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private NameRepository nameRepository;


  @PostMapping(path="/reg")
  public @ResponseBody String registerNewPerson (@RequestParam String name
       , @RequestParam String contact) {

    if(personRepository.findByContact(contact).isPresent()){
      return "This Contact Have been Registered before ";
    }


    Person n_person = new Person();
    Name n_name = new Name();

    n_person.setContact(contact);
    n_name.setPerson(n_person);
    n_name.setName(name);

    personRepository.save(n_person);
    nameRepository.save(n_name);

    return "Registered";
  }

  @GetMapping("/{id}/info")
  public @ResponseBody Optional<Person> getPersonInfoById(@PathVariable(value = "id") Integer personId){
    return personRepository.findById(personId);
  }

  @GetMapping("/{id}/name")
  public @ResponseBody String getPersonNameById(@PathVariable(value = "id") Integer personId){
    Optional<Person> o_person = personRepository.findById(personId);
    if (o_person.isEmpty())
      return null;
    List<Name> names = nameRepository.findByPerson(o_person.get());
    if (names.size() == 0)
      return null;
    return names.get(names.size()-1).getName();
  }


  @PostMapping(path="/{id}/changeName")
  public @ResponseBody String changeCustomerName (@PathVariable(value = "id") Integer personId ,@RequestParam String name) {

    Optional<Person> o_person = personRepository.findById(personId);
    if(o_person.isEmpty())
      return "person not found";

    Name n_name = new Name();

    n_name.setPerson(o_person.get());
    n_name.setName(name);

    nameRepository.save(n_name);

    return "Name Changed to " + name;
  }


  @GetMapping(path="/all")
  public @ResponseBody Iterable<Person> getAllPersons() {
    return personRepository.findAll();
  }
}
