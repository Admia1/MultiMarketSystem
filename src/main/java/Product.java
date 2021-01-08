import java.util.*;
import java.math.BigDecimal;

public class Product{

    String product_name;
    String product_type;
    String product_items;
    String product_brand;
    String product_date;
    String product_barcode;
    BigDecimal product_price;


    public Product(String name, String brand, String date, Sting barcode, BigDecimal price){
        this.product_name = name;
        this.product_brand = brand;
        this.product_date = date;
        this.product_barcode = barcode;
        this.product_price = price;
    }


    public void setName(String name){
        this.product_name = name;
    }

    public void setType(String type){
        this.product_type = type;
    }

    public void setItems(String items){
        this.product_items = items;
    }

    public void setBrand(String brand){
        this.product_brand = brand;
    }

    public void setDate(String date){
        this.product_date = date;
    }

    public void setBarcode(String barcode){
        this.product_barcode = barcode;
    }

    public void setPrice(BigDecimal price){
        this.product_price = price;
    }

    public String getName(){
        return this.product_name;
    }

    public String getType(){
        return this.product_type;
    }

    public void getItems(){
        this.product_items;
    }

    public String getBrand(){
        return this.product_brand;
    }

    public String getDate(){
        return this.product_date;
    }

    public String getBarcode(){
        return this.product_barcode;
    }

    public BigDecimal getPrice(){
        return product_price;
    }

    public boolean addProducts(){
        return true;
    }

    public boolean deleteProducts(){
        return true;
    }

    public boolean updateProducts(){
        return true;
    }

    public boolean searchSProducts(){
        return true;
    }

    public boolean saveProducts(){
        return true;
    }

}

