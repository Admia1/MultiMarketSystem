import java.util.*; 

public class FoodShopUser
{ 
    String first_name;
    String last_name;
    String password;
    String email;
    String phone_number;

    public FoodShopUser(String first_name, String last_name, String password, String email, String phone_number){
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;

    }

    void editFirstName(String first_name){
        this.first_name = first_name;
    }

    void editLastName(String last_name){
        this.last_name = last_name;
    }

    void editPassword(String password){
        this.password = password;
    }

    void editEmail(String email){
        this.email = email;
    }

    void editPhoneNumber(String phone_number){
        this.phone_number = phone_number;
    }

} 