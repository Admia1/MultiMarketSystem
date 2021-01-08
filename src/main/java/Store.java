import java.util.*;

public class Store{
    String store_name;
    String store_type;
    String store_description;

    public Store(String store_name, String store_type){
        this.store_name = store_name;
        this.store_type = store_type;
        
    }


    public void setName(String name){
        this.store_name = name;
    }

    public String getName(){
        return this.store_name;
    }


    public void setType(String type){
        this.store_name = type;
    }

    public String getType(){
        return this.store_type;
    }


    public void setDescription(String description){
        this.store_description = description;
    }

    public String getDescription(){
        return this.store_description;
    }

    public boolean addStores(){
        return true;
    }

    public boolean deleteStores(){
        return true;
    }

    public boolean updateStores(){
        return true;
    }

    public boolean searchStores(){
        return true;
    }
}    