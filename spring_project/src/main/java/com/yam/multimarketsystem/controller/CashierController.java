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


import com.yam.multimarketsystem.repository.CashierRepository;
import com.yam.multimarketsystem.repository.ShopRepository;
import com.yam.multimarketsystem.repository.SalesInvoiceRepository;
import com.yam.multimarketsystem.repository.SalesInvoiceObjectRepository;
import com.yam.multimarketsystem.repository.CardRepository;
import com.yam.multimarketsystem.repository.ProductRepository;
import com.yam.multimarketsystem.repository.ProductExistInShopRepository;
import com.yam.multimarketsystem.repository.DiscountTicketRepository;


import com.yam.multimarketsystem.model.Cashier;
import com.yam.multimarketsystem.model.Shop;
import com.yam.multimarketsystem.model.SalesInvoice;
import com.yam.multimarketsystem.model.SalesInvoiceObject;
import com.yam.multimarketsystem.model.Card;
import com.yam.multimarketsystem.model.Product;
import com.yam.multimarketsystem.model.ProductExistInShop;
import com.yam.multimarketsystem.model.DiscountTicket;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/cash")
public class CashierController {
  @Autowired
  private CashierRepository cashierRepository;
  @Autowired
  private ShopRepository shopRepository;
  @Autowired
  private SalesInvoiceRepository salesInvoiceRepository;
  @Autowired
  private SalesInvoiceObjectRepository salesInvoiceObjectRepository;
  @Autowired
  private CardRepository cardRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private ProductExistInShopRepository productExistInShopRepository;
  @Autowired
  private DiscountTicketRepository discountTicketRepository;


  @PostMapping(path="/addProduct")
  public @ResponseBody String addProductToShop (@RequestParam Integer shopId, @RequestParam Integer quantity,
         @RequestParam String productName, @RequestParam String brandName, @RequestParam Integer pricePerUnit,
         @RequestParam Integer cashierId){
    Optional<Shop> o_shop = shopRepository.findById(shopId);
    if(o_shop.isEmpty())
      return "Bad shop id";

    if(cashierRepository.findByIdAndShopAndIsDeletedFalse(cashierId, o_shop.get()).isEmpty())
      return "No such cashier registered in such a shop";

    Product n_product = new Product();
    ProductExistInShop n_productExistInShop = new ProductExistInShop();

    n_product.setName(productName);
    n_product.setBrand(brandName);

    n_productExistInShop.setProduct(n_product);
    n_productExistInShop.setShop(o_shop.get());
    n_productExistInShop.setQuantity(quantity);
    n_productExistInShop.setPricePerUnit(pricePerUnit);

    productRepository.save(n_product);
    productExistInShopRepository.save(n_productExistInShop);

    return "Product added to shop";
  }

  @PostMapping(path="/addExistance")
  public @ResponseBody String addExistanceToShop(@RequestParam Integer shopId, @RequestParam Integer quantity,
         @RequestParam Integer pricePerUnit, @RequestParam Integer cashierId, @RequestParam Integer productId){

   Optional<Shop> o_shop = shopRepository.findById(shopId);
   if(o_shop.isEmpty())
     return "Bad shop id";

   if(cashierRepository.findByIdAndShopAndIsDeletedFalse(cashierId, o_shop.get()).isEmpty())
     return "No such cashier registered in such shop";

    Optional<Product> o_product = productRepository.findById(productId);
    if(o_product.isEmpty())
      return "Bad product id";

    ProductExistInShop n_productExistInShop = new ProductExistInShop();

    n_productExistInShop.setProduct(o_product.get());
    n_productExistInShop.setQuantity(quantity);
    n_productExistInShop.setPricePerUnit(pricePerUnit);
    n_productExistInShop.setShop(o_shop.get());

    productExistInShopRepository.save(n_productExistInShop);

    return "existance added";
  }

  /*
  @PostMapping(path="/changeQuantity")
  //to do later
  */

  @GetMapping("/existances")
  public @ResponseBody Iterable<ProductExistInShop> getAllExistancesOfShop(@RequestParam Integer shopId, @RequestParam Integer cashierId){
    Optional<Shop> o_shop = shopRepository.findById(shopId);
    if(o_shop.isEmpty())
      //return "Bad shop id";
      return null;

    if(cashierRepository.findByIdAndShopAndIsDeletedFalse(cashierId, o_shop.get()).isEmpty())
      //return "No such cashier registered in such shop";
      return null;

    return productExistInShopRepository.findByShopAndIsDeletedFalse(o_shop.get());
  }

  @PostMapping("/startSalesInvoice")
  public @ResponseBody String startNewSalesInvoice(@RequestParam Integer shopId, @RequestParam Integer cashierId){
    Optional<Shop> o_shop = shopRepository.findById(shopId);
    if(o_shop.isEmpty())
      return "Bad shop id";

    Optional<Cashier> o_cashier = cashierRepository.findByIdAndShopAndIsDeletedFalse(cashierId, o_shop.get());
    if(o_cashier.isEmpty())
      return "No such cashier registered in such shop";

    SalesInvoice n_salesInvoice = new SalesInvoice();
    n_salesInvoice.setShop(o_shop.get());
    n_salesInvoice.setCashier(o_cashier.get());
    salesInvoiceRepository.save(n_salesInvoice);

    return "SalesInvoice created with id " + n_salesInvoice.getId().toString();
  }

  @PostMapping("/addSalesInvoiceObject")
  public @ResponseBody String addSalesInvoiceObject(@RequestParam  Integer shopId, @RequestParam Integer cashierId, @RequestParam Integer salesInvoiceId,
         @RequestParam Integer productExistInShopId, @RequestParam Integer quantity, @RequestParam Integer overallPrice){


    Optional<Shop> o_shop = shopRepository.findById(shopId);
    if(o_shop.isEmpty())
      return "Bad shop id";

    Optional<Cashier> o_cashier = cashierRepository.findByIdAndShopAndIsDeletedFalse(cashierId, o_shop.get());
    if(o_cashier.isEmpty())
      return "No such cashier registered in such shop";

    Optional<SalesInvoice> o_salesInvoice = salesInvoiceRepository.findByIdAndIsDeletedFalseAndIsFinishedFalse(salesInvoiceId);
    if(o_salesInvoice.isEmpty())
      return "Not such sales invoice available";

    Optional<ProductExistInShop> o_productExistInShop = productExistInShopRepository.findByIdAndShopAndIsDeletedFalse(productExistInShopId, o_shop.get());
    if(o_productExistInShop.isEmpty())
      return "Not such existance available";

    SalesInvoiceObject n_salesInvoiceObject = new SalesInvoiceObject();
    n_salesInvoiceObject.setQuantity(quantity);
    n_salesInvoiceObject.setSalesInvoice(o_salesInvoice.get());
    n_salesInvoiceObject.setProductExistInShop(o_productExistInShop.get());
    n_salesInvoiceObject.setOverAllPrice(overallPrice);

    salesInvoiceObjectRepository.save(n_salesInvoiceObject);

    return "sales inovice object created with id " + n_salesInvoiceObject.getId().toString();
  }

  @PostMapping("/deleteSalesInvoiceObject")
  public @ResponseBody String deleteSalesInvoiceObject(@RequestParam  Integer shopId, @RequestParam Integer cashierId, @RequestParam Integer salesInvoiceId,
         @RequestParam Integer salesInvoiceObjectId){


    Optional<Shop> o_shop = shopRepository.findById(shopId);
    if(o_shop.isEmpty())
      return "Bad shop id";

    Optional<Cashier> o_cashier = cashierRepository.findByIdAndShopAndIsDeletedFalse(cashierId, o_shop.get());
    if(o_cashier.isEmpty())
      return "No such cashier registered in such shop";

    Optional<SalesInvoice> o_salesInvoice = salesInvoiceRepository.findByIdAndIsDeletedFalseAndIsFinishedFalse(salesInvoiceId);
    if(o_salesInvoice.isEmpty())
      return "Not such sales invoice available";

    Optional<SalesInvoiceObject> o_salesInvoiceObject = salesInvoiceObjectRepository.findByIdAndSalesInvoice(salesInvoiceObjectId, o_salesInvoice.get());
    if(o_salesInvoiceObject.isEmpty())
      return "Not such sales invoice object available";

    SalesInvoiceObject salesInvoiceObject = o_salesInvoiceObject.get();
    salesInvoiceObject.delete();
    salesInvoiceObjectRepository.save(salesInvoiceObject);

    return "sales inovice object deleted";
  }




}
