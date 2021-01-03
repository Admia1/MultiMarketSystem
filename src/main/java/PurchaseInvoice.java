import java.util.*;
import java.math.BigDecimal;

public class PurchaseInvoice{
    String name;
    String brand;
    int date;
    int barcode;
    BigDecimal price;


    public PurchaseInvoice(String name, String brand, int date, int barcode, BigDecimal price){
        this.name = name;
        this.brand = brand;
        this.date = date;
        this.barcode = barcode;
        this.price = price;
    }


    public void setName(String name){
        this.name = name;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setDate(int date){
        this.date = date;
    }
    public void setBarcode(int barcode){
        this.barcode = barcode;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getName(){
        return name;
    }
    public String getBrand(){
        return brand;
    }
    public int getDate(){
        return date;
    }
    public int getBarcode(){
        return barcode;
    }
    public BigDecimal getPrice(){
        return price;
    }