package restauto.cook.database;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import restauto.cook.database.Table;


public class MySQLDatabase {

//	//Location of database we are accessing
//	private static final String DB_URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql554700" ;
//   
//	//Password and user name for database
//	private static final String USER = "sql554700";
//	private static final String PASS = "kI3!hS8!";
   
private static final String DB_URL = "jdbc:mysql://mysql.surestaurantapp.com:3306/restaurantapp" ;
	
	//Password and user name for database
	
	//private static final String USER = "bob";
	private static final String USER = "restaurantapp";
	
	//private static final String PASS = "changemenow";
	private static final String PASS = "changemenow";
   
	private Connection connection = null;
    private Table table = new Table();
    
    public void connection() {
   
        //Try to establish connection
         try {
        	 
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
     *    itemType: Pass the Items table name.     
     */
    public ArrayList<LinkedHashMap<String, ArrayList<String>>> getItems(boolean all, List<Integer> idNumber, String itemType) throws SQLException {
      
    	LinkedHashMap<String, String> item = table.getTableAttributeValuePair(itemType);
    
 	  //New
      ArrayList<LinkedHashMap<String, ArrayList<String>>> results
      		= new ArrayList<LinkedHashMap<String, ArrayList<String>>>();

      connection();
	  Set<String> keys = item.keySet();
	  boolean firstValue=true;
      String query = "SELECT ";
      
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
    	  
    	  //New
    	  LinkedHashMap<String, ArrayList<String>> temp2 = null;
    	  
		  while(rs.next()) {
			 
			  //New
			  temp2 = new LinkedHashMap<String, ArrayList<String>>();
			  ArrayList<String> temp1 = null;
			  
			  for(String index2: keys) {
				  
				  //New
				  temp1 = new ArrayList<String>();
				 
				  String dataType = item.get(index2);
				  
				  if( dataType.equals("int") || dataType.equals("Integer") )
					  temp1.add(Integer.toString(rs.getInt(index2)));
				  else if( dataType.equals("Double") )
					  temp1.add(Double.toString(rs.getDouble(index2)));
				  else if( dataType.equals("String") )
					  try {
						  temp1.add(rs.getString(index2));
					  } catch(Exception e) {
						  temp1.add("");
					  }
				  else
					  temp1.add("Read Error");
				  
				  temp1.add(dataType);
				  temp2.put(index2, temp1);
			  }
			  
			  results.add(temp2);
		  }
		  
    	  closeResources(statement, connection);
      }
//
      else {
    	  
    	  for(String index: keys) {
    			
    		  if(firstValue) {
  				
    			  query += index;
    			  firstValue=false;
    		  } else 
    			  query += ", " + index;
    	  }
    	  
    	  query += " FROM " + itemType + " WHERE ITEM_ID=?";

		  PreparedStatement statement = connection.prepareStatement(query);

    	  for(int index: idNumber) {
    		  
    		  statement.setInt(1, index);
    		  ResultSet rs = statement.executeQuery();
    		  
    		  //New
    		  LinkedHashMap<String, ArrayList<String>> temp2 = null;
 
    		  while(rs.next()) {
    			  
    			  //New
    			  temp2 = new LinkedHashMap<String, ArrayList<String>>();
    			  ArrayList<String> temp1 = null;
    			  
    			  for(String index2: keys) {
    				  
    				  //New
    				  temp1 = new ArrayList<String>();
    				 
    				  String dataType = item.get(index2);
    				  
    				  if( dataType.equals("int") || dataType.equals("Integer") )
    					  //queryResults.add(Integer.toString(rs.getInt(index2)));
    					  temp1.add(Integer.toString(rs.getInt(index2)));
    				  
    				  else if( dataType.equals("Double") )
    					  //queryResults.add(Double.toString(rs.getDouble(index2)));
    					  temp1.add(Double.toString(rs.getDouble(index2)));
    					  
    				  else if( dataType.equals("String") )
    					  //queryResults.add(rs.getString(index2));
    					  try {
    						  temp1.add(rs.getString(index2));
    					  } catch(Exception e) {
    						  temp1.add("");
    					  }
    				  else
    					  temp1.add("Read Error");
    				  
    				  temp1.add(dataType);
    				  temp2.put(index2, temp1);
    			  }
    			  
    			  results.add(temp2);
    		  }
    	  }
    	  
		  closeResources(statement, connection);
      }

      return results;
    }
    
    /**
     * OVERLOADED FUNCTION
     * @param idNumber
     * @param itemType
     * @param idValue
     * @return
     * @throws SQLException
     */
    public ArrayList<LinkedHashMap<String, ArrayList<String>>> getItems(List<Integer> idNumber, String itemType, String idValue) throws SQLException {
        
      	LinkedHashMap<String, String> item = table.getTableAttributeValuePair(itemType);
      
        ArrayList<LinkedHashMap<String, ArrayList<String>>> results
        		= new ArrayList<LinkedHashMap<String, ArrayList<String>>>();

        connection();
  	  	Set<String> keys = item.keySet();
  	  	boolean firstValue=true;
        String query = "SELECT ";
      	  
      	  for(String index: keys) {
      			
      		  if(firstValue) {
    				
      			  query += index;
      			  firstValue=false;
      		  } else 
      			  query += ", " + index;
      	  }
      	  
      	  query += " FROM " + itemType + " WHERE " + idValue + "=?";

  		  PreparedStatement statement = connection.prepareStatement(query);

      	  for(int index: idNumber) {
      		  
      		  statement.setInt(1, index);
      		  ResultSet rs = statement.executeQuery();
      		  
      		  //New
      		  LinkedHashMap<String, ArrayList<String>> temp2 = null;
   
      		  while(rs.next()) {
      			  
      			  //New
      			  temp2 = new LinkedHashMap<String, ArrayList<String>>();
      			  ArrayList<String> temp1 = null;
      			  
      			  for(String index2: keys) {
      				  
      				  //New
      				  temp1 = new ArrayList<String>();
      				 
      				  String dataType = item.get(index2);
      				  
      				  if( dataType.equals("int") || dataType.equals("Integer") )
      					  //queryResults.add(Integer.toString(rs.getInt(index2)));
      					  temp1.add(Integer.toString(rs.getInt(index2)));
      				  
      				  else if( dataType.equals("Double") )
      					  //queryResults.add(Double.toString(rs.getDouble(index2)));
      					  temp1.add(Double.toString(rs.getDouble(index2)));
      					  
      				  else if( dataType.equals("String") )
      					  //queryResults.add(rs.getString(index2));
      					  try {
      						  temp1.add(rs.getString(index2));
      					  } catch(Exception e) {
      						  temp1.add("");
      					  }
      				  else
      					  temp1.add("Read Error");
      				  
      				  temp1.add(dataType);
      				  temp2.put(index2, temp1);
      			  }
      			  
      			  results.add(temp2);
      		  }
      	  }
      	  
  		  closeResources(statement, connection);

        return results;
      }
    
    
    
    public void insertItem(Map<String, ArrayList<String>> item, String itemType) throws NumberFormatException, SQLException {   	
    	
    	Set<String> keys = item.keySet();
    	String query = "INSERT INTO " + itemType + " (";
    	boolean firstValue = true;
        
    	for(String index: keys) {
			
    		if(firstValue) {
    			query += index;
    			firstValue=false;
    		} else
    			query += "," + index;
    	}
	  
    	query += ") VALUES ( ";
    	firstValue = true;
    	
    	for(@SuppressWarnings("unused") String index: keys) {
    		if(firstValue) {
				
    			query += "?";
    			firstValue=false;
    		} else
    			query += ", ?";	
    	}
    	
    	query += ")";
        
    	connection();
    	PreparedStatement statement = connection.prepareStatement(query);
            
    	int count=0;
    	for(String index: keys) { count++;
            	
    		ArrayList<String> hold = item.get(index);
            	
    		if(hold.get(1).equals("int") || hold.get(1).equals("Integer"))
    			statement.setInt(count, Integer.parseInt(hold.get(0)));
            	
            else if(hold.get(1).equals("Double"))
            	statement.setDouble(count, Double.parseDouble(hold.get(0)));
            	
            else if(hold.get(1).equals("String"))
            	statement.setString(count, hold.get(0));
            	
            else
				System.out.println("Insert Error - Datatype Unknown");
    	}

        statement.executeUpdate();
         
        closeResources(statement, connection);	  
    }
    
    public void deleteItem(String itemType, int idValue) throws SQLException {
    	
    	connection();
    	//String query = "DELETE FROM " + itemType + " WHERE ITEM_ID=?";
    	String query = "DELETE FROM " + itemType + " WHERE " + itemType + "_ID=?";
    	PreparedStatement statement = connection.prepareStatement(query);
            
    	statement.setInt(1, idValue);
    	statement.executeUpdate();

    	closeResources(statement, connection); 
    }
    
    public void deleteItem(String itemType, int idValue, String idName) throws SQLException {
    	
    	connection();
    	//String query = "DELETE FROM " + itemType + " WHERE ITEM_ID=?";
    	String query = "DELETE FROM " + itemType + " WHERE " + idName + "=?";
    	PreparedStatement statement = connection.prepareStatement(query);
            
    	statement.setInt(1, idValue);
    	statement.executeUpdate();

    	closeResources(statement, connection); 
    }
    
    public void updateItems(Map<String, ArrayList<String>> item, String itemType) throws SQLException {
    	
    	Set<String> keys = item.keySet();
    	String query = "UPDATE " + itemType + " SET ";
    	boolean firstValue = true;
        
    	for(String index: keys) {
			
    		if(firstValue) {
    			query += index + "=?";
    			firstValue=false;
    		} else
    			query += "," + index + "=?";
    	}
    	
    	query += " WHERE ITEM_ID=?";
        
    	connection();
    	PreparedStatement statement = connection.prepareStatement(query);
        
    	int itemID = 0;
    	int count=0;
    	for(String index: keys) { count++;
            	
    		ArrayList<String> hold = item.get(index);
    		
			if(index.equals("ITEM_ID"))
				itemID = Integer.parseInt(hold.get(0));
            	
    		if(hold.get(1).equals("int") || hold.get(1).equals("Integer"))
    			statement.setInt(count, Integer.parseInt(hold.get(0)));
            	
            else if(hold.get(1).equals("Double"))
            	statement.setDouble(count, Double.parseDouble(hold.get(0)));
            	
            else if(hold.get(1).equals("String"))
            	statement.setString(count, hold.get(0));
            	
            else
				System.out.println("Insert Error - Datatype Unknown");

    	}
    	
    	statement.setInt(count+1, itemID);

        statement.executeUpdate();
         
        closeResources(statement, connection);
    }
    
public LinkedHashMap<String,BufferedImage> getCookPictures(String typeID) throws SQLException, IOException {
    	
    	connection();
    	//String query = "DELETE FROM " + itemType + " WHERE ITEM_ID=?";
    	String query = "SELECT NAME, IMAGE FROM MENU_ITEM, ITEM_TYPE,IMAGE, ITEM_IMAGE WHERE ITEM_TYPE.TYPE_ID=? "
    			+ "AND ITEM_TYPE.ITEM_ID=ITEM_IMAGE.ITEM_ID AND ITEM_TYPE.ITEM_ID=MENU_ITEM.ITEM_ID AND "
    			+ "ITEM_IMAGE.IMAGE_ID=IMAGE.IMAGE_ID";
    	PreparedStatement statement = connection.prepareStatement(query);
            
    	statement.setString(1, typeID);
    	ResultSet rs =statement.executeQuery();
    	LinkedHashMap<String,BufferedImage> pictureList=new LinkedHashMap<String,BufferedImage>();
    	
    	while(rs.next()){
            //Retrieve by column name
            String name = rs.getString("NAME");
            Blob imageBlob = rs.getBlob("IMAGE");
            byte[] data = imageBlob.getBytes(1, (int) imageBlob.length());
            BufferedImage bufferedImg = ImageIO.read(new ByteArrayInputStream(data));
 
           
            
            pictureList.put(name,bufferedImg);
            
            

            
         }
         rs.close();

    	closeResources(statement, connection);
    	return pictureList;
    }

public boolean loginAttempt(String userName, String passWord) throws SQLException
{
	connection();
	
	String query = "SELECT * FROM EMPLOYEE WHERE USERNAME=? AND PASSWORD=?";
	PreparedStatement statement = connection.prepareStatement(query);
	
	statement.setString(1, userName);
	statement.setString(2, passWord);
	ResultSet rs =statement.executeQuery();
	
	if (!rs.next() ) {
	    return false;
	}
	else
		return true;
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
    
}