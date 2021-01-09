import java.util.*;


public class Shop{
    String name;
    String shop_manager;
    String address;
    String city;

    public Shop(String name, Stirng shop_manager, String address, String city){
        this.name = name;
        this.shop_manager = shop_manager;
        this.address = address;
        this.city = city;
    }

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

    public Sting getName(){
        return name;
    }
    public Sting getShop_manager(){
        return shop_manager;
    }
    public Sting getAddress(){
        return address;
    }
    public Sting getCity(){
        return city;
    }
}