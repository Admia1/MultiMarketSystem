import java.util.*;
import java.math.BigDecimal;

public class Payment{

    String payment_date;
    String payment_description;;
    String payment_amount;

    public Payment(String date, String description, String amount){
        this.payment_date = date;
        this.payment_description = description;
        this.payment_amount = amount;
        
    }

    public void setDate(String date){
        this.payment_date = date;
    }

    public void setDescription(String description){
        this.payment_description = description;
    }

    public void setAmount(String amount){
        this.payment_amount = amount;
    }

    public String getDate(){
        return this.payment_date;
    }

    public String getDescription(){
        return this.payment_description;
    }

    public String getAmount(){
        return this.payment_amount;
    }


    public boolean addPayment(){
        return true;
    }

    public boolean deletePayment(){
        return true;
    }

    public boolean updatePayment(){
        return true;
    }

    public boolean searchPayment(){
        return true;
    }

}

