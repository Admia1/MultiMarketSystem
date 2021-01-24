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

import com.yam.multimarketsystem.repository.ScoreStrategyRepository;


import com.yam.multimarketsystem.model.ScoreStrategy;



import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/scr")
public class ScoreStrategyController {
  @Autowired
  private ScoreStrategyRepository scoreStrategyRepository;

  @PostMapping(path="/changeStrategy")
  public @ResponseBody String changeStrategy(@RequestParam Integer fee,@RequestParam Integer scorePerUnit,@RequestParam Integer minimumPurchaseUnit){
    ScoreStrategy n_scoreStrategy = new ScoreStrategy();
    n_scoreStrategy.setFee(fee);
    n_scoreStrategy.setScorePerUnit(scorePerUnit);
    n_scoreStrategy.setMinimumPurchaseUnit(minimumPurchaseUnit);
    scoreStrategyRepository.save(n_scoreStrategy);

    return "score strategy changed";
  }

}
