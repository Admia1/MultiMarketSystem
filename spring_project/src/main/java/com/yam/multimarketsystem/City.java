package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class City{
    String name;



    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}