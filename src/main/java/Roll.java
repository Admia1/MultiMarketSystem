import java.util.*;
import java.math.BigDecimal;

public class Role{

    String role_title;
    String role_description;;
    

    public void setTitle(String title){
        this.role_title = title;
    }

    public void setDescription(String description){
        this.role_description = description;
    }

    public String getTitle(){
        return this.role_title;
    }

    public String getDescription(){
        return this.role_description;
    }

    public boolean addRole(){
        return true;
    }

    public boolean deleteRole(){
        return true;
    }

    public boolean updateRole(){
        return true;
    }

    public boolean searchRole(){
        return true;
    }

    public boolean saveRole(){
        return true;
    }

    public boolean assignRole(){
        return true;
    }

}

