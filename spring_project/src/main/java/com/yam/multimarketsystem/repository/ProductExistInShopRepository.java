package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.ProductExistInShop;
import com.yam.multimarketsystem.model.Product;
import com.yam.multimarketsystem.model.Shop;

import java.util.List;
import java.util.Optional;


public interface ProductExistInShopRepository extends CrudRepository<ProductExistInShop, Integer> {
  List<ProductExistInShop> findByShopAndIsDeletedFalse(Shop shop);
  Optional<ProductExistInShop> findByIdAndShopAndIsDeletedFalse(Integer id, Shop shop);
  Optional<ProductExistInShop> findById(Integer id);
  //List<ProductExistInShop> findByProductBarcode(String barcode);
}
