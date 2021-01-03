import java.util.*;
import java.math.BigDecimal;

public class SalesInvoice{
    String shop_name;
    String shop_cashier;
    String customer_name;
    int date;
    BigDecimal price;


    public Sales_invoice(String shop_name, String shop_cashier, String customer_name, int date, BigDecimal price){
        this.shop_name = shop_name;
        this.shop_cashier = shop_cashier;
        this.customer_name = customer_name;
        this.date = date;
        this.price = price;
    }

    public void setShop_name(String shop_name){
        this.shop_name = shop_name;
    }
    public void setShop_cashier(String shop_cashier){
        this.shop_cashier = shop_cashier;
    }
    public void setCustomer_name(String customer_name){
        this.customer_name = customer_name;
    }
    public void setDate(int date){
        this.date = date;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public String getShop_name(){
        return shop_name;
    }
    public String getShop_cashier(){
        return shop_cashier;
    }
    public String getCustomer_name(){
        return customer_name;
    }
    public int getDate(){
        return date;
    }
    public BigDecimal getPrice(){
        return price;
    }
}