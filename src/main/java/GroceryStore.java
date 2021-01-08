//package Connection;
//package

import java.util.*;
import java.sql.*;

public class GroceryStore {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MysqlConnection mysql_conn=new MysqlConnection();
        Connection con=mysql_conn.conn("root", "rootpass");
        
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("**************************************************************");
        System.out.println("                  WELCOME TO GROCERY PORTAL");
        System.out.println("**************************************************************");
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.println("Press 1 to continue as Admin \nPress 2 to continue as Customer \n");
        System.out.println("Press 0 to exit");
        System.out.println();

        int input1=sc.nextInt();
        int flag=0;
        if(input1==1) flag=1;
        if(input1==2) flag=2; //Consumer
        
        /// global variables
        ///takes care of continuous work flow
        // Admin
        Admin ad=new Admin();   
        int adminlogged=0;
        int t=0;
        //consumer
        boolean loggedin=false;
        Consumer customer=new Consumer();
        
        while(true && flag!=0) {
            //admin left
            if(flag==1)
                {
            if(adminlogged==0) {
                t=ad.admin_login(con);
                adminlogged=1;
            }

                if(t==1) 
                {
                    int choice=1;
                    System.out.println(" __________________________________________________");
                    System.out.println("|===================================================|");
                    System.out.println("|                                                   |");
                    System.out.println("|        Welcome to the Admin Menu                  |");
                    System.out.println("|                                                   |");
                    System.out.println("|===================================================|");
                    System.out.println("|                                                   |");
                    System.out.println("|1. View/Update/Delete Consumer                     |");
                    System.out.println("|2. View/Update/Delete Supplier (not ready)         |");
                    System.out.println("|3. View/Update/Delete Products                     |");
                    System.out.println("|4. View/Update/Delete Delievery(not ready)         |");
                    System.out.println("|5. View/Update/Delete Categories                   |");
                    System.out.println("|6. View Feedback                                   |");
                    System.out.println("|7. Exit                                            |");
                    System.out.println("|___________________________________________________|");
                    System.out.println("Please choose your option: ");
                    choice=sc.nextInt();
                    if(choice==1)
                    {
                        ad.edit_customer(con);
                        continue;
                    }
                    else if(choice==2)
                    {
                        ad.edit_supplier(con);
                        continue;
                    }
                    else if(choice==3) {
                        ad.edit_products(con);
                        continue;
                    }
                    else if(choice==4)
                    {
                        
                        continue;
                    }
                    else if(choice==5) {
                        ad.edit_categories(con);continue;}
                    else if(choice==6) {
                        ad.view_feedback(con); continue;}
                    else {
                        System.out.println("===================================================");
                        System.out.println("                Logout successfull                  ");
                        System.out.println("===================================================");
                        break;
                    }
                
                
                }
                else
                {   System.out.println("===================================================");
                    System.out.println(" OOPS!! Login Unsuccessfull!! :( Please try again");
                    System.out.println("===================================================");
                    System.out.println("Press 0 to exit and press 1 to try again");
                    int w=sc.nextInt();
                    if(w==1)
                        continue;
                    else
                        break;
                    
                }
            }

            //consumer part
            if(flag==2) {
                
                
                try {
                    if(!loggedin) {
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("**************************************************************");
                        System.out.println("                 Welcome to Consumer Portal");
                        System.out.println("**************************************************************");
                        System.out.println("--------------------------------------------------------------");   
                        System.out.println();
                        
                        System.out.println("Press 1 to register to our portal as a new user");
                        System.out.println("Press 2 to log in");
                        System.out.println("Press 0 to exit");
                        System.out.println();
                        System.out.println("--------------------------------------------------------------");
                        int flag1=sc.nextInt();
                        if(flag1==1) { //register
                            int reg=customer.customer_register(con);
                            if(reg==0) {
                                System.out.println("Error: You have already registered in our portal or have entered faulty inputs");
                                System.out.println();
                                System.out.println("--------------------------------------------------------------");
                                continue;
                            }
                            else {
                                flag1=2; // login
                            }
                        }
                        if(flag1==2) { //login
                            int log=customer.customer_login(con);
                            if(log==1) {
                                loggedin=true;
                                System.out.println("Login Successful");
                                System.out.println();
                                System.out.println("--------------------------------------------------------------");
                                continue;
                            }
                            else {
                                loggedin=false;
                                System.out.println("Wrong credentials");
                                System.out.println("Press 0 to exit or 1 to try again");
                                System.out.println();
                                System.out.println("--------------------------------------------------------------");
                                int ex=sc.nextInt();
                                if(ex==0) break;
                                else continue; 
                            }
                        }
                        if(flag1==0) break;
                    }
                    if(loggedin) {
                        System.out.println();
                        System.out.println("--------------------------------------------------------------");
                        System.out.println();
                        System.out.println("Press 1 to display all items");
                        System.out.println("Press 2 to see products by category");
                        System.out.println("Press 3 to search and add product to cart");
                        System.out.println("Press 4 to checkout");
                        System.out.println("Press 5 to rate previously ordered products");
                        System.out.println("Press 0 to exit");
                        System.out.println();
                        System.out.println("--------------------------------------------------------------");
                        System.out.println();


                        int item_flag=sc.nextInt();
                        if(item_flag==1) { //display all items
                            int noerr=customer.showresult(con, item_flag);
                            if(noerr==0) {
                                System.out.println("Wrong input");
                                continue;
                            }
                        }
                        if(item_flag==2) {
                            System.out.println();
                            System.out.println("--------------------------------------------------------------");
                            System.out.println();
                            System.out.println("Below are the available categories, please enter one");
                            System.out.println();
                            customer.showresult(con, 3); //display all available categories
                            int noerr=customer.showresult(con, item_flag); //display all products of the chosen category
                            if(noerr==0) {
                                System.out.println("Wrong input");
                                System.out.println();
                                System.out.println("--------------------------------------------------------------");
                                System.out.println();
                                continue;
                            }
                        }
                        if(item_flag==3) { //search and add product to cart
                            int noerr=customer.showresult(con, 4);
                            if(noerr==0) {
                                System.out.println("Wrong input");
                                System.out.println();
                                System.out.println("--------------------------------------------------------------");
                                System.out.println();
                                continue;
                            }
                        }
                        if(item_flag==4) { //checkout
                            int noerr=customer.showresult(con, 5);
                            if(noerr==0) {
                                System.out.println("Wrong input");
                                System.out.println();
                                System.out.println("--------------------------------------------------------------");
                                System.out.println();
                                continue;
                            }
                        }
                        if(item_flag==5) { // rate products
                            int noerr=customer.showresult(con, 7);
                            if(noerr==0) {
                                System.out.println("Wrong input");
                                System.out.println();
                                System.out.println("--------------------------------------------------------------");
                                System.out.println();
                                continue;
                            }
                        }
                        if(item_flag==0) break;
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            
            
            
            
            else {
                break;
            }
        }
        System.out.println("Exit Successful");
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println();
    }

}
