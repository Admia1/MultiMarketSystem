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


import com.yam.multimarketsystem.repository.DiscountTicketRepository;
import com.yam.multimarketsystem.repository.DiscountRepository;
import com.yam.multimarketsystem.repository.DiscountPreviewRepository;
import com.yam.multimarketsystem.repository.DiscountStrategyRepository;
import com.yam.multimarketsystem.repository.CustomerRepository;


import com.yam.multimarketsystem.model.DiscountTicket;
import com.yam.multimarketsystem.model.Discount;
import com.yam.multimarketsystem.model.DiscountPreview;
import com.yam.multimarketsystem.model.DiscountStrategy;
import com.yam.multimarketsystem.model.Customer;




import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/dis")
public class DiscountController {
  @Autowired
  private DiscountTicketRepository discountTicketRepository;
  @Autowired
  private DiscountRepository discountRepository;
  @Autowired
  private DiscountPreviewRepository discountPreviewRepository;
  @Autowired
  private DiscountStrategyRepository discountStrategyRepository;
  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/allStrategies")
  public @ResponseBody Iterable<DiscountStrategy> getAllStrategies(){
    return discountStrategyRepository.findAll();
  }
  @GetMapping("/allPreviews")
  public @ResponseBody Iterable<DiscountPreview> getAllPreviews(){
    return discountPreviewRepository.findAll();
  }
  @GetMapping("/allDiscounts")
  public @ResponseBody Iterable<Discount> getAllDiscounts(){
    return discountRepository.findAll();
  }
  @GetMapping("/allTickets")
  public @ResponseBody Iterable<DiscountTicket> getAllTickets(){
    return discountTicketRepository.findAll();
  }




  @PostMapping("/addStrategies")
  public @ResponseBody String addStrategies(@RequestParam Integer discountPrice){

    DiscountStrategy n_discountStrategy = new DiscountStrategy();
    n_discountStrategy.setDiscountPrice(discountPrice);

    discountStrategyRepository.save(n_discountStrategy);

    return "discount strategy added";
  }



  @PostMapping("/addPreviews")
  public @ResponseBody String addPreviews(@RequestParam String name, @RequestParam Integer discountId, @RequestParam Integer limitToBuy, @RequestParam Integer price){

    Optional<Discount> o_discount= discountRepository.findById(discountId);
    if(o_discount.isEmpty())
      return "Bad discount id";

    DiscountPreview n_discountPreview = new DiscountPreview();
    n_discountPreview.setName(name);
    n_discountPreview.setDiscount(o_discount.get());
    n_discountPreview.setLimitToBuy(limitToBuy);
    n_discountPreview.setPrice(price);

    discountPreviewRepository.save(n_discountPreview);

    return "Discount preview added";
  }



  @PostMapping("/addDiscounts")
  public @ResponseBody String addDiscounts(@RequestParam String name,@RequestParam Integer discountStrategyId){
    Optional<DiscountStrategy> o_discountStrategy = discountStrategyRepository.findById(discountStrategyId);
    if(o_discountStrategy.isEmpty())
      return "Bad strategy id";

    Discount n_discount = new Discount();
    n_discount.setName(name);
    n_discount.setDiscountStrategy(o_discountStrategy.get());

    discountRepository.save(n_discount);

    return "Discount added";
  }



  @PostMapping("/buyTickets")
  public @ResponseBody String buyTickets(@RequestParam Integer customerId, @RequestParam Integer discountPreviewId){
    Optional<DiscountPreview> o_discountPreview = discountPreviewRepository.findById(discountPreviewId);
    if (o_discountPreview.isEmpty())
      return "Bad discount preview id";

    Optional<Customer> o_customer = customerRepository.findById(customerId);
    if (o_customer.isEmpty())
      return "Bad customer id";

    if (o_discountPreview.get().getLimitToBuy().equals(0))
      return "This discount preview is full";



    DiscountPreview discountPreview = o_discountPreview.get();
    Customer customer = o_customer.get();

    if (customer.getScore() < discountPreview.getPrice())
      return "Too low score to buy this discount ticket";
    DiscountTicket n_discountTicket = new DiscountTicket();

    n_discountTicket.setDiscountPreview(discountPreview);
    n_discountTicket.setCustomer(o_customer.get());

    customer.decreaseScore(discountPreview.getPrice());
    discountPreview.setLimitToBuy(discountPreview.getLimitToBuy()-1);

    discountPreviewRepository.save(discountPreview);
    discountTicketRepository.save(n_discountTicket);
    customerRepository.save(customer);

    return "Ticket bought successfuly";
  }


}
