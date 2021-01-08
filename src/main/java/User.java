import java.util.*;
import java.sql.*;


public class User{
    
    String user_name;
    String user_family_name;
    String user_phone_number;
    String user_email;
    String user_address;
    String user_username;
    String user_password;

    
    public void setName(String name){
        this.user_name = name;
    }

    public void setFamilyName(String family_name){
        this.user_family_name = family_name;
    }

    public void setPhoneNumber(String phone_number){
        this.user_phone_number = phone_number;
    }

    public void setEmail(String email){
        this.user_email = email;
    }

    public void setAddress(String address){
        this.user_address = address;
    }

    public void setUsername(String username){
        this.user_username = username;
    }

    public void setPassword(String password){
        this.user_password = password;
    }

    public String getName(){
        return this.user_name;
    }

    public String getFamilyName(){
        return this.user_family_name;
    }

    public String getPhoneNumber(){
        return this.user_phone_number;
    }

    public String getEmail(){
        return this.user_email;
    }

    public String setAddress(){
        return this.user_address;
    }

    public String setUsername(){
        return this.user_username;
    }

    public String setPassword(){
        return this.user_password;
    }


    public boolean addUser(){
        return true;
    }

    public boolean deleteUser(){
        return true;
    }

    public boolean updateUser(){
        return true;
    }

    public boolean searchUser(){
        return true;
    }

}
