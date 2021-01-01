import java.util.*; 

public class FoodShopAddress
{ 
    String text;
    int city_id;
    int user_id;
    float geo_x;
    float geo_y;

    public FoodShopAddress(String text, int city_id, int user_id, float geo_x, float geo_y){
        this.text = text;
        this.city_id = city_id;
        this.user_id = user_id;
        this.geo_x = geo_x;
        this.geo_y = geo_y;
    }


} 