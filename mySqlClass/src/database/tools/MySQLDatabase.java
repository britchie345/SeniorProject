package database.tools;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import database.items.ItemType;
import database.items.MenuItem;
import database.items.Type;
import database.items.TypeIncluded;


public class MySQLDatabase {

	//Location of database we are accessing
	private static final String DB_URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql554700" ;
   
	//Password and user name for database
	private static final String USER = "sql554700";
	private static final String PASS = "kI3!hS8!";
   
	private Connection connection = null;
    
    public void connection()
    {
   
        //Try to establish connection
         try{
            //Register JDBC driver i.e. what type of database
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
   
        }catch(SQLException e){
        	
            e.printStackTrace();
        }catch(Exception e){
        	
            e.printStackTrace();
        }
    }

    /*
     *    all:      Do you want all of the items?
     *    idNumber: Pass "null" if "all=true".
     *              Otherwise pass as many idNumbers
     *              as you want to extract.
     *    itemType: Pass the Items enumeration value
     *              of what database item you want.
     *    item:     Map<k,v>: "k=item", "v=data type"
     *              e.g., "k="DESCRIPTION"", "v="String""         
     */
    public List<String> getItems(boolean all, List<Integer> idNumber, String itemType, Map<String, String> item) throws SQLException
    {
      //Initialize arrayList and statement for use
      ArrayList<String> queryResults = new ArrayList<String>();

      connection();
	  Set<String> keys = item.keySet();
	  boolean firstValue=true;
      String query = "SELECT ";
      
      //Create the MySQL query
      if( all ) {
  		
    	  for(String index: keys) {
  			
    		  if(firstValue) {
  				
    			  query += index;
    			  firstValue=false;
    		  }
    		  else
    			  query += ", " + index;
    	  }
    	  
    	  query += " FROM " + itemType;
    	  
    	  Statement statement = connection.createStatement();
    	  ResultSet rs = statement.executeQuery(query);
    	  
		  while(rs.next()) {
			  
			  for(String index2: keys) {
				  
				  String dataType = item.get(index2);
				  
				  if( dataType.equals("int") || dataType.equals("Integer") )
					  queryResults.add(Integer.toString(getInt(rs, index2)));
				  
				  else if( dataType.equals("Double") )
					  queryResults.add(Double.toString(getDouble(rs, index2)));
				  
				  else if( dataType.equals("String") )
					  queryResults.add(getString(rs, index2));
			  }
			  
			  queryResults.add("\n");
		  }
    	  
    	  closeResources(statement, connection);
      }
      else {
    	  
    	  for(String index: keys) {
    			
    		  if(firstValue) {
  				
    			  query += index;
    			  firstValue=false;
    		  }
    		  else
    			  query += ", " + index;
    	  }
    	  
    	  query += " FROM " + itemType + " WHERE ITEM_ID=?";

		  PreparedStatement statement = connection.prepareStatement(query);

    	  for(int index: idNumber) {
    		  
    		  statement.setInt(1, index);
    		  ResultSet rs = statement.executeQuery();
 
    		  while(rs.next()) {
    			  
    			  for(String index2: keys) {
    				  
    				  String dataType = item.get(index2);
    				  
    				  if( dataType.equals("int") || dataType.equals("Integer") )
    					  queryResults.add(Integer.toString(getInt(rs, index2)));
    				  
    				  else if( dataType.equals("Double") )
    					  queryResults.add(Double.toString(getDouble(rs, index2)));
    				  
    				  else if( dataType.equals("String") )
    					  queryResults.add(getString(rs, index2));
    			  } 
    			  
				  queryResults.add("\n");
    		  }
    	  }
    	  
		  closeResources(statement, connection);
      }
      
      return queryResults;
    }
    
    private int getInt(ResultSet rs, String item) throws SQLException {
    	
    	return rs.getInt(item);
    }
    
    private Double getDouble(ResultSet rs, String item) throws SQLException {
    	
    	return rs.getDouble(item);
    }
    
    private String getString(ResultSet rs, String item) throws SQLException {
    	
    	return rs.getString(item);
    }
    
    private void closeResources(Statement statement, Connection connection) {
    	
        try {
            if(statement != null)
            	statement.close();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        try {
            if(connection != null)
            	connection.close();
        }catch(SQLException e) {
             e.printStackTrace();
        }
    }
    
    /*
	*   Insert entry into MENU_ITEM table
	*/
    public void insertIntoMenu_Item(MenuItem arg)
    {
        
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "INSERT INTO MENU_ITEM "+ "(ITEM_ID,NAME,MENU_DESC,DESCRIPTION,PRICE,CALORIES,ONMENU,COOKTIME,SPICY,RECOMMENDED) VALUES" + "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1,arg.getId());
            statement.setString(2,arg.getName());
            statement.setString(3,arg.getMenuDesc());
            statement.setString(4,arg.getDescription());
            statement.setDouble(5,arg.getPrice());
            statement.setInt(6,arg.getCalories());
            statement.setInt(7,arg.getOnMenu());
            statement.setString(8,arg.getCookTime());
            statement.setInt(9,arg.getSpicy());
            statement.setInt(10,arg.getRecommended());
            //Executes query
            statement.executeUpdate();
             
        }catch(SQLException e) { 
            e.printStackTrace();
        }catch(Exception e) { 
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      }  
    }
    
    public void deleteMenu_Item(int id)
    {
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "DELETE FROM MENU_ITEM WHERE ITEM_ID=?";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1, id);
            //Executes query
             statement.executeUpdate();
             
        }catch(SQLException e) { 
            e.printStackTrace();
        }catch(Exception e) { 
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      }   
    }
		
    public void updateMenu_Item(MenuItem arg)
    {
      //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "UPDATE MENU_ITEM "+ "SET ITEM_ID=?,NAME=?,MENU_DESC=?,DESCRIPTION=?,PRICE=?,CALORIES=?,ONMENU=?,COOKTIME=?,SPICY=?,RECOMMENDED=? WHERE ITEM_ID=?";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1,arg.getId());
            statement.setString(2,arg.getName());
            statement.setString(3,arg.getMenuDesc());
            statement.setString(4,arg.getDescription());
            statement.setDouble(5,arg.getPrice());
            statement.setInt(6,arg.getCalories());
            statement.setInt(7,arg.getOnMenu());
            statement.setString(8,arg.getCookTime());
            statement.setInt(9,arg.getSpicy());
            statement.setInt(10,arg.getRecommended());
            statement.setInt(11,arg.getId());
            //Executes query
            statement.executeUpdate();
             
        }catch(SQLException e) { 
            e.printStackTrace();
        }catch(Exception e) { 
            e.printStackTrace();
        }finally
        {
        	  closeResources(statement, connection);
      }   
    }

	/*
	*   Insert entry into MENU_ITEM table
	*/
	public void insertIntoType(Type arg)
    {
        
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "INSERT INTO TYPE "+ "(TYPE_ID,NAME,DESCRIPTION) VALUES" + "( ?, ?, ?)";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1,arg.getTypeId());
            statement.setString(2,arg.getName());
            statement.setString(3,arg.getDescription());
            //Executes query
            statement.executeUpdate();
             
        }catch(SQLException e) { 
            e.printStackTrace();
        }catch(Exception e) { 
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      } 
    }
    
    public void deleteType(int id)
    {
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "DELETE FROM TYPE WHERE TYPE_ID=?";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1, id);
            //Executes query
             statement.executeUpdate();
             
        }catch(SQLException e) { 
            e.printStackTrace();
        }catch(Exception e) { 
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      }    
    }
		
    public void updateType(Type arg)
    {
      //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "UPDATE TYPE "+ "SET TYPE_ID=?,NAME=?,DESCRIPTION=? WHERE TYPE_ID=?";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1,arg.getTypeId());
            statement.setString(2,arg.getName());
            statement.setString(4,arg.getDescription());
            //Executes query
            statement.executeUpdate();
             
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      }  
    }
    
    
    public ArrayList<String> getAllType_Included()
    {
      //Intialize arrayList and statement for use
      ArrayList<String> queryResults = new ArrayList<String>();  
      Statement statement=null;
      try
      {
            connection();
            statement = connection.createStatement();
            //Createst String that holds SQL query
            String sql;
            sql = "SELECT * FROM TYPE_INCLUDED";
      
            //Returns the results of query in a special class
            ResultSet rs = statement.executeQuery(sql);
      
            while(rs.next())
            {
                //Retrieves values by column name
                int typeOne  = rs.getInt("TYPE_ONE");
                int typeTwo = rs.getInt("TYPE_TWO");
                int number = rs.getInt("NUMBER");
               
                //Adds results to queryList to be returned
                queryResults.add(Integer.toString(typeOne));
                queryResults.add(Integer.toString(typeTwo));
                queryResults.add(Integer.toString(number));
            }
      
      }catch(SQLException e) {
            e.printStackTrace();
      }catch(Exception e) {
            e.printStackTrace();
      }finally {
      	  closeResources(statement, connection);
      }
      return queryResults;
    }
    
    /*
	*   function gets single record from MENU_ITEM table
	*/
    public ArrayList getSingleTypeIncluded(int id)
    {
        ArrayList queryResults = new ArrayList();
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "SELECT * FROM TYPE_INCLUDED WHERE TYPE_ONE=?";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1, id);
            //Executes query
             ResultSet rs2 = statement.executeQuery();
             
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
             
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      }  
      return queryResults;
    }
    
    
    /*
	*   Insert entry into MENU_ITEM table
	*/
    public void insertIntoType_Included(TypeIncluded arg)
    {
        
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "INSERT INTO TYPE_INCLUDED "+ "(TYPE_ONE,TYPE_TWO,NUMBER) VALUES" + "( ?, ?, ?)";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1,arg.getTypeOne());
            statement.setInt(2,arg.getTypeTwo());
            statement.setInt(3,arg.getNumber());
            //Executes query
            statement.executeUpdate();
             
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      }
    }
    
    public void deleteType_Included(int id,int id2)
    {
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "DELETE FROM TYPE_INCLUDED WHERE TYPE_ONE=? AND TYPE_TWO=?";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1, id);
            statement.setInt(2, id2);
            //Executes query
             statement.executeUpdate();
             
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      }   
    }
    
    //Insert entry into MENU_ITEM table
    public void insertIntoItem_Type(ItemType arg)
    {
        
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "INSERT INTO ITEM_TYPE "+ "(ITEM_ID,TYPE_ID) VALUES" + "( ?, ?)";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1,arg.getItemId());
            statement.setInt(2,arg.getTypeId());
   
            //Executes query
            statement.executeUpdate();
             
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
        	  closeResources(statement, connection);
      } 
    }
    
    public void deleteItem_Type(int id, int id2)
    {
        //Prepared Statement variable for Prepared SQL statements
        PreparedStatement statement= null;
         try
        {
            connection();
            String sql2;
            sql2 = "DELETE FROM ITEM_TYPE WHERE ITEM_ID=? AND TYPE_ID=?";
            statement = connection.prepareStatement(sql2);
            
            //Inserts value into SQL query for ?
            statement.setInt(1, id);
            statement.setInt(2, id2);
            //Executes query
             statement.executeUpdate();
             
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
      	  closeResources(statement, connection);
        }    
    }
    
}