import java.util.*; 

public class Item
{ 
    String name;
    String brand;
    int expiration_year;
    int weight;
    String type;

    void setName(String name){
        this.name = name;
    }

    void setBrand(String brand){
        this.brand = brand;
    }

    void setExpirationYear(int year){
        this.expiration_year = year;
    }

    void setWeight(int weight){
        this.weight = weight;
    }

    void setType(String type){
        this.type = type;
    }

    @Override
    public String toString() 
    {
        return 
        "\n**************************************\n"
        +"Name: " + name
        + "\nBrand: " + brand
        + "\nExpiration Year: " + expiration_year
        + "\nWeight: " + weight
        + "\nType: "+ type
        + "\n**************************************\n";
    }
} 