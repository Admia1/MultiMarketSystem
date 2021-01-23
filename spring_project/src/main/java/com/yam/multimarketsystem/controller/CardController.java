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
import com.yam.multimarketsystem.repository.CardGenerationRepository;

import com.yam.multimarketsystem.model.Card;
import com.yam.multimarketsystem.model.CardGeneration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.yam.multimarketsystem.util.CardCodeGenerator;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/card")
public class CardController {
  @Autowired
  private CardGenerationRepository cardGenerationRepository;
  @Autowired
  private CardRepository cardRepository;

  @PostMapping(path="/generate")
  public @ResponseBody CardGeneration registerNewCardGeneration (@RequestParam String name, @RequestParam Integer number){

    CardGeneration n_cardGeneration = new CardGeneration();

    n_cardGeneration.setName(name);

    cardGenerationRepository.save(n_cardGeneration);
    Integer n_cardGeneration_id = n_cardGeneration.getId();


    for(Integer i=0; i<number; i++){
      Card n_card = new Card();
      n_card.setCardGeneration(n_cardGeneration);
      n_card.setCode(CardCodeGenerator.generateCode(n_cardGeneration_id, i));
      cardRepository.save(n_card);
    }

    return n_cardGeneration;
  }


  @GetMapping(path="/allcards")
  public @ResponseBody Iterable<Card> getCards() {
    return cardRepository.findAll();
  }

  @GetMapping(path="/allgens")
  public @ResponseBody Iterable<CardGeneration> getCardGenerations() {
    return cardGenerationRepository.findAll();
  }

  @GetMapping(path="/gen/{id}/activate")
  public @ResponseBody String activateCardGeneration(@PathVariable(value = "id") Integer id) {
    Optional<CardGeneration> cardGeneration = cardGenerationRepository.findById(id);
    if (cardGeneration.isEmpty())
      return "bad generation id";

    CardGeneration cg = cardGeneration.get();
    cg.activate();
    cardGenerationRepository.save(cg);

    return "generation " + id.toString() + " activated";
  }

  @GetMapping(path="/gen/{id}")
  public @ResponseBody List<Card> getCardGeneration(@PathVariable(value = "id") Integer id) {
    Optional<CardGeneration> cardGeneration = cardGenerationRepository.findById(id);
    if (cardGeneration.isEmpty())
      return null;

    return cardRepository.findByCardGeneration(cardGeneration.get());
  }

  @GetMapping(path="/card/{id}/discard")
  public @ResponseBody String discardCard(@PathVariable(value = "id") Integer id) {
    Optional<Card> o_card = cardRepository.findById(id);
    if (o_card.isEmpty())
      return "bad card id";

    Card card = o_card.get();
    card.discard();
    cardRepository.save(card);

    return "card " + id.toString() + " discarded";
  }

  @GetMapping(path="/card/{id}")
  public @ResponseBody Optional<Card> getCard(@PathVariable(value = "id") Integer id) {
    Optional<Card> o_card = cardRepository.findById(id);
    if (o_card.isEmpty())
      return null;

    return o_card;
  }


}
