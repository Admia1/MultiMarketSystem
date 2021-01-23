package com.yam.multimarketsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.yam.multimarketsystem.model.ProductExistInShop;
import com.yam.multimarketsystem.model.Product;

import java.util.List;
import java.util.Optional;


public interface ProductExistInShopRepository extends CrudRepository<ProductExistInShop, Integer> {
  List<ProductExistInShop> findByProduct(Product product);
  Optional<ProductExistInShop> findById(Integer id);
  List<ProductExistInShop> findByProductBarcode(String barcode);
}
