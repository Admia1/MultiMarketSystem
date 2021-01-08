import java.util.*;
import java.math.BigDecimal;

public class Permission{

    String permission_title;
    String permission_description;;
    

    public void setTitle(String title){
        this.permission_title = title;
    }

    public void setDescription(String description){
        this.permission_title = description;
    }

    public String getTtitle(){
        return this.permission_title;
    }

    public String getDescription(){
        return this.permission_description;
    }

    public boolean addPayment(){
        return true;
    }

    public boolean deletePermission(){
        return true;
    }

    public boolean updatePermission(){
        return true;
    }

    public boolean searchPermission(){
        return true;
    }

    public boolean savePermission(){
        return true;
    }

}

