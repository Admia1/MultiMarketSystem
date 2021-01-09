package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;

public class Product{
    String name;
    String brand;
    int date;
    int barcode;
    BigDecimal price;



    public void setName(String name){
        this.name = name;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setDate(int date){
        this.date = date;
    }
    public void setBarcode(int barcode){
        this.barcode = barcode;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public String getBrand(){
        return brand;
    }
    public int getDate(){
        return date;
    }
    public int getBarcode(){
        return barcode;
    }
    public BigDecimal getPrice(){
        return price;
    }
}
