import java.util.Scanner; 
import java.util.*;

public class Menu
{ 
    public static void main(String args[]) 
    { 
        System.out.println("Menu:"); 
        System.out.println("1.Salesperson"); 
        System.out.println("2.Customer"); 
        Scanner scan = new Scanner(System.in);
        int user_type = scan.nextInt();

        if (user_type == 1){
            System.out.println("Hello dude!"); 
            System.out.println("1.Add new item"); 
            int admin_command = scan.nextInt();
            if (admin_command == 1){
                System.out.println("Please enter item's name:"); 
                String name = scan.next();
                System.out.println("Please enter item's brand:"); 
                String brand = scan.next();
                System.out.println("Please enter item's expiration_year:"); 
                int expiration_year = scan.nextInt();
                System.out.println("Please enter item's weight:"); 
                int weight = scan.nextInt();
                System.out.println("Please enter item's type:"); 
                String type = scan.next();
                Item new_item = new Item();
                new_item.setName(name);
                new_item.setBrand(brand);
                new_item.setExpirationYear(expiration_year);
                new_item.setWeight(weight);
                new_item.setType(type);
                System.out.println(new_item.toString()); 
            }

        }    
        else{
            System.out.println("Welcome to our supermarket!"); 
        }

    } 
} 