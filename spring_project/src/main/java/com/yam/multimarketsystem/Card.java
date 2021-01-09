package com.yam.multimarketsystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Card{
    int code;


    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
