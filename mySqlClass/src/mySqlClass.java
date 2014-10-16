import java.sql.*;
import java.util.*;
import java.util.Scanner;

public class mySqlClass {
    //This is java driver tells what type of database we are accessing
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
   
   //Tells location of database we are accessing
   static final String DB_URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql554700" ;
   
   //Password and user name for database
   static final String USER = "sql554700";
   static final String PASS = "kI3!hS8!";
   
    Connection conn = null;
    
    public static void main(String[] args) {
         
        
          
     }
    
      //Connection function
    void connection()
    {
   
        //Try to establish connection
         try{
            //Register JDBC driver i.e. what type of database
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
   
    
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally{}
    }
    //------------------------MENU_ITEM table functions --------------------
    //Get all for MENU_ITEM table returns arraylist of all items in MENU_ITEM
    ArrayList getAllMenu_Item()
    {
      //Intialize arrayList and statement for use
      ArrayList queryResults = new ArrayList();  
      Statement stmt=null;
      try
      {
            connection();
            stmt = conn.createStatement();
            //Createst String that holds SQL query
            String sql;
            sql = "SELECT ITEM_ID, NAME, MENU_DESC, PRICE FROM MENU_ITEM";
      
            //Returns the results of query in a special class
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next())
            {
                //Retrieves values by column name
                int id  = rs.getInt("ITEM_ID");
                String name = rs.getString("NAME");
                String menu = rs.getString("MENU_DESC");
                double price = rs.getDouble("PRICE");
                //Adds results to queryList to be returned
                queryResults.add(id);
                queryResults.add(name);
                queryResults.add(menu);
                queryResults.add(price);
            }
      
      }catch(SQLException se)
      {
            //Handle errors for JDBC
            se.printStackTrace();
      }catch(Exception e)
      {
            //Handle errors for Class.forName
            e.printStackTrace();
      }finally
      {
            //finally block used to close resources
            try
            {
                if(stmt!=null)
                stmt.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
      return queryResults;
    }
    
    //function gets single record from MENU_ITEM table
    ArrayList getSingleMenu_Item(int id)
    {
        ArrayList queryResults = new ArrayList();
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "SELECT ITEM_ID, NAME, MENU_DESC, PRICE FROM MENU_ITEM WHERE ITEM_ID=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1, id);
            //Executes query
             ResultSet rs2 = stmt2.executeQuery();
             
             while(rs2.next())
             {
                //Retrieve by column name
                int itemId  = rs2.getInt("ITEM_ID");
                String name = rs2.getString("NAME");
                String menu = rs2.getString("MENU_DESC");
                double price = rs2.getDouble("PRICE");
                
                queryResults.add(itemId);
                queryResults.add(name);
                queryResults.add(menu);
                queryResults.add(price);
             }
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
      return queryResults;
    }
    
    
    //Insert entry into MENU_ITEM table
    void insertIntoMenu_Item(Menu_Item arg)
    {
        
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "INSERT INTO MENU_ITEM "+ "(ITEM_ID,NAME,MENU_DESC,DESCRIPTION,PRICE,CALORIES,ONMENU,COOKTIME,SPICY,RECOMMENDED) VALUES" + "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1,arg.getId());
            stmt2.setString(2,arg.getName());
            stmt2.setString(3,arg.getMenuDesc());
            stmt2.setString(4,arg.getDescription());
            stmt2.setDouble(5,arg.getPrice());
            stmt2.setInt(6,arg.getCalories());
            stmt2.setInt(7,arg.getOnMenu());
            stmt2.setString(8,arg.getCookTime());
            stmt2.setInt(9,arg.getSpicy());
            stmt2.setInt(10,arg.getRecommended());
            //Executes query
            stmt2.executeUpdate();
             
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try  
    }
    
    void deleteMenu_Item(int id)
    {
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "DELETE FROM MENU_ITEM WHERE ITEM_ID=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1, id);
            //Executes query
             stmt2.executeUpdate();
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
    }
    void updateMenu_Item(Menu_Item arg)
    {
      //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "UPDATE MENU_ITEM "+ "SET ITEM_ID=?,NAME=?,MENU_DESC=?,DESCRIPTION=?,PRICE=?,CALORIES=?,ONMENU=?,COOKTIME=?,SPICY=?,RECOMMENDED=? WHERE ITEM_ID=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1,arg.getId());
            stmt2.setString(2,arg.getName());
            stmt2.setString(3,arg.getMenuDesc());
            stmt2.setString(4,arg.getDescription());
            stmt2.setDouble(5,arg.getPrice());
            stmt2.setInt(6,arg.getCalories());
            stmt2.setInt(7,arg.getOnMenu());
            stmt2.setString(8,arg.getCookTime());
            stmt2.setInt(9,arg.getSpicy());
            stmt2.setInt(10,arg.getRecommended());
            stmt2.setInt(11,arg.getId());
            //Executes query
            stmt2.executeUpdate();
             
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
    }
    
    //--------------------TYPE Table Functions -----------------------
    //Returns the whoel table for TYPES
    ArrayList getAllType()
    {
      //Intialize arrayList and statement for use
      ArrayList queryResults = new ArrayList();  
      Statement stmt=null;
      try
      {
            connection();
            stmt = conn.createStatement();
            //Createst String that holds SQL query
            String sql;
            sql = "SELECT TYPE_ID, NAME, DESCRIPTION FROM TYPE";
      
            //Returns the results of query in a special class
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next())
            {
                //Retrieves values by column name
                int id  = rs.getInt("TYPE_ID");
                String name = rs.getString("NAME");
                String description = rs.getString("DESCRIPTION");
                //Adds results to queryList to be returned
                queryResults.add(id);
                queryResults.add(name);
                queryResults.add(description);
            }
      
      }catch(SQLException se)
      {
            //Handle errors for JDBC
            se.printStackTrace();
      }catch(Exception e)
      {
            //Handle errors for Class.forName
            e.printStackTrace();
      }finally
      {
            //finally block used to close resources
            try
            {
                if(stmt!=null)
                stmt.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
      return queryResults;
    }
    
ArrayList getSingleType(int id)
    {
        ArrayList queryResults = new ArrayList();
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "SELECT TYPE_ID, NAME, DESCRIPTION FROM TYPE WHERE TYPE_ID=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1, id);
            //Executes query
             ResultSet rs2 = stmt2.executeQuery();
             
             while(rs2.next())
             {
                //Retrieve by column name
                int typeId  = rs2.getInt("TYPE_ID");
                String name = rs2.getString("NAME");
                String description = rs2.getString("DESCRIPTION");
               
                
                queryResults.add(typeId);
                queryResults.add(name);
                queryResults.add(description);
             }
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
      return queryResults;
    }

 //Insert entry into MENU_ITEM table
    void insertIntoType(Type arg)
    {
        
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "INSERT INTO TYPE "+ "(TYPE_ID,NAME,DESCRIPTION) VALUES" + "( ?, ?, ?)";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1,arg.getTypeId());
            stmt2.setString(2,arg.getName());
            stmt2.setString(3,arg.getDescription());
            //Executes query
            stmt2.executeUpdate();
             
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try  
    }
    
    void deleteType(int id)
    {
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "DELETE FROM TYPE WHERE TYPE_ID=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1, id);
            //Executes query
             stmt2.executeUpdate();
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
    }
    void updateType(Type arg)
    {
      //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "UPDATE TYPE "+ "SET TYPE_ID=?,NAME=?,DESCRIPTION=? WHERE TYPE_ID=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1,arg.getTypeId());
            stmt2.setString(2,arg.getName());
            stmt2.setString(4,arg.getDescription());
            //Executes query
            stmt2.executeUpdate();
             
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
    }
    
    
    ArrayList getAllType_Included()
    {
      //Intialize arrayList and statement for use
      ArrayList queryResults = new ArrayList();  
      Statement stmt=null;
      try
      {
            connection();
            stmt = conn.createStatement();
            //Createst String that holds SQL query
            String sql;
            sql = "SELECT * FROM TYPE_INCLUDED";
      
            //Returns the results of query in a special class
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next())
            {
                //Retrieves values by column name
                int typeOne  = rs.getInt("TYPE_ONE");
                int typeTwo = rs.getInt("TYPE_TWO");
                int number = rs.getInt("NUMBER");
               
                //Adds results to queryList to be returned
                queryResults.add(typeOne);
                queryResults.add(typeTwo);
                queryResults.add(number);
            }
      
      }catch(SQLException se)
      {
            //Handle errors for JDBC
            se.printStackTrace();
      }catch(Exception e)
      {
            //Handle errors for Class.forName
            e.printStackTrace();
      }finally
      {
            //finally block used to close resources
            try
            {
                if(stmt!=null)
                stmt.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
      return queryResults;
    }
    
    //function gets single record from MENU_ITEM table
    ArrayList getSingleTypeIncluded(int id)
    {
        ArrayList queryResults = new ArrayList();
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "SELECT * FROM TYPE_INCLUDED WHERE TYPE_ONE=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1, id);
            //Executes query
             ResultSet rs2 = stmt2.executeQuery();
             
             while(rs2.next())
             {
                //Retrieves values by column name
                int typeOne  = rs2.getInt("TYPE_ONE");
                int typeTwo = rs2.getInt("TYPE_TWO");
                int number = rs2.getInt("NUMBER");
               
                //Adds results to queryList to be returned
                queryResults.add(typeOne);
                queryResults.add(typeTwo);
                queryResults.add(number);
             }
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
      return queryResults;
    }
    
    
    //Insert entry into MENU_ITEM table
    void insertIntoType_Included(typeIncluded arg)
    {
        
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "INSERT INTO TYPE_INCLUDED "+ "(TYPE_ONE,TYPE_TWO,NUMBER) VALUES" + "( ?, ?, ?)";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1,arg.getTypeOne());
            stmt2.setInt(2,arg.getTypeTwo());
            stmt2.setInt(3,arg.getNumber());
            //Executes query
            stmt2.executeUpdate();
             
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try  
    }
    
    void deleteType_Included(int id,int id2)
    {
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "DELETE FROM TYPE_INCLUDED WHERE TYPE_ONE=? AND TYPE_TWO=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1, id);
            stmt2.setInt(2, id2);
            //Executes query
             stmt2.executeUpdate();
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
    } 
   //Get all for MENU_ITEM table returns arraylist of all items in MENU_ITEM
    ArrayList getAllItemType()
    {
      //Intialize arrayList and statement for use
      ArrayList queryResults = new ArrayList();  
      Statement stmt=null;
      try
      {
            connection();
            stmt = conn.createStatement();
            //Createst String that holds SQL query
            String sql;
            sql = "SELECT * FROM MENU_ITEM";
      
            //Returns the results of query in a special class
            ResultSet rs = stmt.executeQuery(sql);
      
            while(rs.next())
            {
                //Retrieves values by column name
                int id  = rs.getInt("ITEM_ID");
                int  typeID = rs.getInt("TYPE_ID");
               
                //Adds results to queryList to be returned
                queryResults.add(id);
                queryResults.add(typeID);
               
            }
      
      }catch(SQLException se)
      {
            //Handle errors for JDBC
            se.printStackTrace();
      }catch(Exception e)
      {
            //Handle errors for Class.forName
            e.printStackTrace();
      }finally
      {
            //finally block used to close resources
            try
            {
                if(stmt!=null)
                stmt.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
      return queryResults;
    }
    
    //function gets single record from MENU_ITEM table
    ArrayList getSingleItem_Type(int id)
    {
        ArrayList queryResults = new ArrayList();
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "SELECT * FROM ITEM_TYPE WHERE ITEM_ID=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1, id);
            //Executes query
             ResultSet rs2 = stmt2.executeQuery();
             
             while(rs2.next())
             {
                //Retrieve by column name
                int itemId  = rs2.getInt("ITEM_ID");
                int typeID = rs2.getInt("TYPE_ID");
          
                
                queryResults.add(itemId);
                queryResults.add(typeID);
                
             }
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
      return queryResults;
    }
    
    
    //Insert entry into MENU_ITEM table
    void insertIntoItem_Type(Item_Type arg)
    {
        
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "INSERT INTO ITEM_TYPE "+ "(ITEM_ID,TYPE_ID) VALUES" + "( ?, ?)";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1,arg.getItemId());
            stmt2.setInt(2,arg.getTypeId());
   
            //Executes query
            stmt2.executeUpdate();
             
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try  
    }
    
    void deleteItem_Type(int id, int id2)
    {
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement stmt2= null;
         try
        {
            connection();
            String sql2;
            sql2 = "DELETE FROM ITEM_TYPE WHERE ITEM_ID=? AND TYPE_ID=?";
            stmt2 = conn.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            stmt2.setInt(1, id);
            stmt2.setInt(2, id2);
            //Executes query
             stmt2.executeUpdate();
        }catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally
        {
            //finally block used to close resources
            try
            {
                if(stmt2!=null)
                stmt2.close();
            }catch(SQLException se2)
            {
            }// nothing we can do
            try
            {
                if(conn!=null)
                conn.close();
            }catch(SQLException se)
            {
                 se.printStackTrace();
            }//end finally try
      }//end try    
    }
    
}