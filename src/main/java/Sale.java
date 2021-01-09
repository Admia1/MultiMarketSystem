import java.util.*;
import java.math.BigDecimal;

public class Sale{

    String sale_type;
    String sale_description;
    String sale_amount;

    public Sale(String type, String description, String amount){
        this.sale_type = type;
        this.sale_description = description;
        this.sale_amount = amount;
        
    }

    public void setType(String type){
        this.sale_type = type;
    }

    public void setDescription(String description){
        this.sale_description = description;
    }

    public void setAmount(String amount){
        this.sale_amount = amount;
    }

    public String getType(){
        return this.sale_type;
    }

    public String getDescription(){
        return this.sale_description;
    }

    public String getAmount(){
        return this.sale_amount;
    }


    public boolean addSales(){
        return true;
    }

    public boolean deleteSales(){
        return true;
    }

    public boolean updateSales(){
        return true;
    }

    public boolean searchSales(){
        return true;
    }

    public boolean saveSales(){
        return true;
    }

}

