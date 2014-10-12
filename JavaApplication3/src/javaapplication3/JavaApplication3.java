//Andrew Coulbourne
package javaapplication3;
//Imports 
import java.sql.*;
import java.util.Scanner;
public class JavaApplication3 {
    
  
//This is java driver tells what type of database we are accessing
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   
//Tells location of database we are accessing
   static final String DB_URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql554700" ;
   
//Password and user name for database
   static final String USER = "sql554700";
   static final String PASS = "kI3!hS8!";

   
   public static void main(String[] args) {
   //Scanner for user input
   Scanner scan = new Scanner(System.in);
   
   Connection conn = null;
   //Statement variable for regular SQL statements 
   Statement stmt = null;
   //Prepared Statement variable for Prepared SQL statements
   PreparedStatement stmt2= null;
   
   
   try{
      //Register JDBC driver i.e. what type of database
      Class.forName("com.mysql.jdbc.Driver");

      //Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      
      //Creates statement for sending over connection
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //Gets user Input no error checking in gettign input
      System.out.println("Enter a ID or 0 for ALL");
      int ID=scan.nextInt();
      
      //If user wishs to see whole table
      if(ID==0)
      {
      //Creates String that holds SQL query
      String sql;
      sql = "SELECT ITEM_ID, NAME, MENU_DESC, PRICE FROM MENU_ITEM";
      
      //Returns the results of query in a special class
      ResultSet rs = stmt.executeQuery(sql);
      
      //While loop that gets results and prints them out one table entry at time 
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("ITEM_ID");
         String name = rs.getString("NAME");
         String menu = rs.getString("MENU_DESC");
         double price = rs.getDouble("PRICE");

         //Display values
         System.out.println("MENU_ID: " + id);
         System.out.println("NAME: " + name);
         System.out.println("MENU_DECS: " + menu);
         System.out.println("PRICE: " + price);
         System.out.println("----------------------------------------");
      }
      }
      //If user enters a ID print single table entry
      else
      {
      //Creates Prepared Statement ? in SQL query is where variable will be input
      String sql2;
      sql2 = "SELECT ITEM_ID, NAME, MENU_DESC, PRICE FROM MENU_ITEM WHERE ITEM_ID=?";
      //Prepares a prepared statement to be sent
      stmt2 = conn.prepareStatement(sql2);
      //Inserts value into SQL query for ?
      stmt2.setInt(1, ID);
      //Executes query
      ResultSet rs2 = stmt2.executeQuery();
      
      //While loop that prints infomation from query 
      while(rs2.next()){
         //Retrieve by column name
         int id  = rs2.getInt("ITEM_ID");
         String age = rs2.getString("NAME");
         String first = rs2.getString("MENU_DESC");
         double last = rs2.getDouble("PRICE");

         //Display values
         System.out.println("MENU_ID: " + id);
         System.out.println("NAME: " + age);
         System.out.println("MENU_DECS: " + first);
         System.out.println("PRICE: " + last);
         System.out.println("----------------------------------------");
      }

       }       
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");

}}
