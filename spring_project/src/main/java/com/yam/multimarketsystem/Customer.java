import java.util.*;

public class Customer{
    String name;
    String family;
    int phone_number;

    public Customer(String name, String family, int phone_number){
        this.name = name;
        this.family = family;
        this.phone_number = phone_number;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setFamily(String family){
        this.family = family;
    }
    public void setPhone_number(int phone_number){
        this.phone_number = phone_number;
    }

    public String getName(){
        return name;
    }
    public String getFamily(){
        return family;
    }
    public int getPhone_number(){
        return phone_number;
    }
}