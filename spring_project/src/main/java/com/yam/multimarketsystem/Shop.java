package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Shop{
    String name;
    String shop_manager;
    String address;
    String city;

    public void setName(String name){
        this.name = name;
    }
    public void setShop_manager(String shop_manager){
        this.shop_manager = shop_manager;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getName(){
        return name;
    }
    public String getShop_manager(){
        return shop_manager;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
}
