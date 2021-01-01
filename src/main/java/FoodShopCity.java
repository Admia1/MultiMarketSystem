import java.util.*; 

public class FoodShopCity
{ 
    String name;
    float geo_x;
    float geo_y;

    public FoodShopCity(String name, float geo_x, float geo_y){
        this.name = name;
        this.geo_x = geo_x;
        this.geo_y = geo_y;

    }

    void setName(String name){
        this.name = name;
    }

    void setPosition(float geo_x, float geo_y){
        this.geo_x = geo_x;
        this.geo_y = geo_y;
    }

} 