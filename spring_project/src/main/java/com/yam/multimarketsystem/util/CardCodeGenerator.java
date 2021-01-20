package com.yam.multimarketsystem.util;

public class CardCodeGenerator{
  public static String generateCode(Integer generationId, Integer order){
    return generationId.toString() + "_" + order.toString();
  }
}
