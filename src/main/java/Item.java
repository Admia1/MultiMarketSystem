import java.util.*; 

public class Item
{ 
    String name;
    String brand;
    Date expiration_date;
    int weight;
    String type;

    @Override
    public String toString() 
    {
        return 
        "\n**************************************\n"
        +"Name: " + name
        + "\nBrand: " + brand
        + "\nExpiration Date:    " + expiration_date
        + "\nWeight: " + weight
        + "\nType: "+ type
        + "\n**************************************\n";
    }
} 