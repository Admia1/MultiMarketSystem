import java.util.Scanner; 

public class Menu
{ 
    public static void main(String args[]) 
    { 
        System.out.println("Menu:"); 
        System.out.println("1.Salespaerson"); 
        System.out.println("2.Customer"); 
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();

        if (i == 1){
            System.out.println("Hello dude!"); 
        }    
        else{
            System.out.println("Welcome to our supermarket!"); 
        }

    } 
} 