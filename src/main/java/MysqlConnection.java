//package Connection;
import java.sql.*; 
import java.util.*;
    class MysqlConnection{  
    public static void main(String args[]){ 
    	//MysqlConnection co=new MysqlConnection();
    	//Connection kk=co.conn("root", "rootpass");
    }
    Connection connect() {
    	Connection con=null;
    	try{  
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/online_grocerystore_management_system","root","rootpass"); 
    	    return con;
    	    }catch(Exception e){ System.out.println(e);
    	    	return null;
    	    }
    	
    	    } 
    
    }
    