package restauto.manager.database.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import restauto.manager.database.tools.Table;
import restauto.manager.menu.levelc.model.Employee;
import restauto.manager.menu.levelc.model.LocationGoogle;


public class MySQLDatabase {

//	//Location of database we are accessing
//	private static final String DB_URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql554700" ;
//   
//	//Password and user name for database
//	private static final String USER = "sql554700";
//	private static final String PASS = "kI3!hS8!";
   
	//Location of database we are accessing
	
	//private static final String DB_URL = "jdbc:mysql://54.165.67.15:3306/Restaurant" ;
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
    
    /**
     * New
     * 
     * Queries for the chart data
     */
    public double getSales(String startDate, String endDate) {
    	
    	//final String query = "SELECT NAME, ORDERS_ARCHIVE.ITEM_ID, COUNT(ORDERS_ARCHIVE.ITEM_ID) AS NUMBER_SOLD FROM `ORDERS_ARCHIVE`, MENU_ITEM WHERE SALE_ID IN (SELECT SALE_ID FROM SALE_ARCHIVE WHERE DATE BETWEEN '2014-01-01' AND '2015-12-20') AND MENU_ITEM.ITEM_ID = ORDERS_ARCHIVE.ITEM_ID GROUP BY NAME";
    	String query = "SELECT SUM(PRICE) AS TOTAL_SALES FROM ORDERS_ARCHIVE, MENU_ITEM WHERE SALE_ID IN (SELECT SALE_ID FROM SALE_ARCHIVE WHERE DATE BETWEEN '" + startDate + "' AND '" + endDate + "') AND ORDERS_ARCHIVE.ITEM_ID = MENU_ITEM.ITEM_ID";
    	//List<Map<String, String>> result = new ArrayList<Map<String, String>>();
    	double result = 0;
    	
    	connection();
    	Statement statement;
    	
		try {
			
			statement = connection.createStatement();
	  	  	ResultSet rs = statement.executeQuery(query);
	  	  	
	    	  //LinkedHashMap<String, String> rowMap = null;
	    	  
			  while(rs.next()) {
				  
				 //rowMap = new LinkedHashMap<String, String>();
				  
				 //rowMap.put("NAME", rs.getString("NAME"));
				 //rowMap.put("NUMBER_SOLD", rs.getString("NUMBER_SOLD"));
				  
				 //result.add(rowMap);
				  
				  result = rs.getDouble("TOTAL_SALES");
				  System.out.println("\n\ndouble: " + result + "\n");
				  
				  int integer = rs.getInt("TOTAL_SALES");
				  System.out.println("ninteger: " + integer + "\n");
				  
				  String string = rs.getString("TOTAL_SALES");
				  System.out.println("string: " + string + "\n");
				  
				  float myfloat = rs.getFloat("TOTAL_SALES");
				  System.out.println("myfloat: " + myfloat + "\n\n");
			  }
			  
	    	  closeResources(statement, connection);
	  	  	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
		return result;
    }
    
    /**
     * New
     * 
     * Queries for the chart data
     */
    public List<Map<String, String>> getItemsBought(boolean all, String typesIncluded) {
    	
    	//final String query = "SELECT NAME, ORDERS_ARCHIVE.ITEM_ID, COUNT(ORDERS_ARCHIVE.ITEM_ID) AS NUMBER_SOLD FROM `ORDERS_ARCHIVE`, MENU_ITEM WHERE SALE_ID IN (SELECT SALE_ID FROM SALE_ARCHIVE WHERE DATE BETWEEN '2014-01-01' AND '2015-12-20') AND MENU_ITEM.ITEM_ID = ORDERS_ARCHIVE.ITEM_ID GROUP BY NAME";
    	
    	String query = "";
    	
    	if(all)
    		query = "SELECT NAME, ORDERS_ARCHIVE.ITEM_ID, COUNT(ORDERS_ARCHIVE.ITEM_ID) AS NUMBER_SOLD FROM `ORDERS_ARCHIVE`, MENU_ITEM WHERE SALE_ID IN (SELECT SALE_ID FROM SALE_ARCHIVE WHERE DATE BETWEEN '2014-01-01' AND '2015-12-20') AND MENU_ITEM.ITEM_ID = ORDERS_ARCHIVE.ITEM_ID AND MENU_ITEM.ITEM_ID IN (SELECT ITEM_TYPE.ITEM_ID FROM TYPE, ITEM_TYPE WHERE TYPE.TYPE_ID = ITEM_TYPE.TYPE_ID) GROUP BY NAME";
    	else
    		query = "SELECT NAME, ORDERS_ARCHIVE.ITEM_ID, COUNT(ORDERS_ARCHIVE.ITEM_ID) AS NUMBER_SOLD FROM `ORDERS_ARCHIVE`, MENU_ITEM WHERE SALE_ID IN (SELECT SALE_ID FROM SALE_ARCHIVE WHERE DATE BETWEEN '2014-01-01' AND '2015-12-20') AND MENU_ITEM.ITEM_ID = ORDERS_ARCHIVE.ITEM_ID AND MENU_ITEM.ITEM_ID IN (SELECT ITEM_TYPE.ITEM_ID FROM TYPE, ITEM_TYPE WHERE TYPE.TYPE_ID = ITEM_TYPE.TYPE_ID AND TYPE.TYPE_ID IN (" + typesIncluded + ")) GROUP BY NAME";
    	List<Map<String, String>> result = new ArrayList<Map<String, String>>();
    	
    	connection();
    	Statement statement;
    	
		try {
			
			statement = connection.createStatement();
	  	  	ResultSet rs = statement.executeQuery(query);
	  	  	
	    	  LinkedHashMap<String, String> rowMap = null;
	    	  
			  while(rs.next()) {
				  
				 rowMap = new LinkedHashMap<String, String>();
				  
				 rowMap.put("NAME", rs.getString("NAME"));
				 rowMap.put("NUMBER_SOLD", rs.getString("NUMBER_SOLD"));
				  
				 result.add(rowMap);
			  }
			  
	    	  closeResources(statement, connection);
	  	  	
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
		return result;
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
//      else {
//    	  
//    	  for(String index: keys) {
//    			
//    		  if(firstValue) {
//  				
//    			  query += index;
//    			  firstValue=false;
//    		  } else 
//    			  query += ", " + index;
//    	  }
//    	  
//    	  query += " FROM " + itemType + " WHERE ITEM_ID=?";
//
//		  PreparedStatement statement = connection.prepareStatement(query);
//
//    	  for(int index: idNumber) {
//    		  
//    		  statement.setInt(1, index);
//    		  ResultSet rs = statement.executeQuery();
// 
//    		  while(rs.next()) {
//    			  
//    			  for(String index2: keys) {
//    				  
//    				  String dataType = item.get(index2);
//    				  
//    				  if( dataType.equals("int") || dataType.equals("Integer") )
//    					  queryResults.add(Integer.toString(rs.getInt(index2)));
//    				  
//    				  else if( dataType.equals("Double") )
//    					  queryResults.add(Double.toString(rs.getDouble(index2)));
//    				  
//    				  else if( dataType.equals("String") )
//    					  queryResults.add(rs.getString(index2));
//    			  } 
//    			  
//				  queryResults.add("\n");
//    		  }
//    	  }
//    	  
//		  closeResources(statement, connection);
//      }
//      
      //return queryResults;
      
      //New
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
    	String query = "DELETE FROM " + itemType + " WHERE ITEM_ID=?";
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
    
public void insertImage(String pictureName, File pictureFile, String itemID) throws SQLException, FileNotFoundException {
    	
    	connection();
    	String query = "INSERT INTO IMAGE (IMAGE,FILENAME) VALUES (?,?)";
    	PreparedStatement statement = connection.prepareStatement(query);
        
    	InputStream file=new FileInputStream(pictureFile);
    	statement.setBinaryStream(1,file);
    	statement.setString(2, pictureName);
    	statement.executeUpdate();
    	

    	closeResources(statement, connection); 
    	
    	
    	connection();
    	
    	Statement stmt = connection.createStatement();
    	String sql = "SELECT IMAGE_ID, FILENAME FROM IMAGE WHERE FILENAME='"+pictureName+"'";
        ResultSet rs = stmt.executeQuery(sql);

        int id=0;
        while(rs.next()){
    	id  = rs.getInt("IMAGE_ID");
        }
    	closeResources(stmt, connection);
    	
    	
    	connection();
    	String query2 = "INSERT INTO ITEM_IMAGE (ITEM_ID,IMAGE_ID) VALUES (?,?)";
    	PreparedStatement statement2 = connection.prepareStatement(query2);
        
    	
    	statement2.setString(1,itemID);
    	statement2.setInt(2, id);
    	statement2.executeUpdate();
    	

    	closeResources(statement2, connection); 
    }
public void deleteImage(String idValue, String imgID) throws SQLException {
	
	connection();
	String query = "DELETE FROM ITEM_IMAGE WHERE ITEM_ID=?";
	PreparedStatement statement = connection.prepareStatement(query);
        
	statement.setString(1, idValue);
	statement.executeUpdate();
	
    query = "DELETE FROM IMAGE WHERE FILENAME=?";
	statement = connection.prepareStatement(query);
        
	statement.setString(1, imgID);
	statement.executeUpdate();

	closeResources(statement, connection); 
}

public void deleteLocation(String itemType, int idValue)
		throws SQLException {

	connection();
	String query = "DELETE FROM " + itemType + " WHERE LOCATIONS_ID=?";
	PreparedStatement statement = connection.prepareStatement(query);

	statement.setInt(1, idValue);
	statement.executeUpdate();

	closeResources(statement, connection);
}

public void deleteEmployee(String itemType, int idValue)
		throws SQLException {

	connection();
	String query = "DELETE FROM " + itemType + " WHERE EMP_ID=?";
	PreparedStatement statement = connection.prepareStatement(query);

	statement.setInt(1, idValue);
	statement.executeUpdate();

	closeResources(statement, connection);
}


public ArrayList<LocationGoogle> locationAttempt() throws SQLException {
	ArrayList<LocationGoogle> tempArray = new ArrayList<LocationGoogle>();
	connection();

	String query = "SELECT * FROM LOCATIONS";
	Statement statement = connection.createStatement();

	ResultSet rs = statement.executeQuery(query);

	while (rs.next()) {
		LocationGoogle Holder = new LocationGoogle();
		Holder.setItemID(rs.getString("LOCATIONS_ID"));
		Holder.setLatitude(rs.getString("LAT"));
		Holder.setLongitude(rs.getString("LONG"));
		Holder.setTitle(rs.getString("TITLE"));
		Holder.setDescription(rs.getString("DESCRIPTION"));
		Holder.setStreet(rs.getString("STREET"));
		Holder.setCity(rs.getString("CITY"));
		Holder.setState(rs.getString("STATE"));
		Holder.setZip(rs.getString("ZIP"));

		tempArray.add(Holder);
	}

	return tempArray;

}

public ArrayList<Employee> employeeAttempt() throws SQLException {
	ArrayList<Employee> tempArray = new ArrayList<Employee>();
	connection();

	String query = "SELECT * FROM EMPLOYEE";
	Statement statement = connection.createStatement();

	ResultSet rs = statement.executeQuery(query);

	while (rs.next()) {
		Employee Holder = new Employee();
		Holder.setItemID(rs.getString("EMP_ID"));
		Holder.setUsername(rs.getString("USERNAME"));
		Holder.setPassword(rs.getString("PASSWORD"));
		Holder.setFname(rs.getString("FIRSTNAME"));
		Holder.setLname(rs.getString("LASTNAME"));

		tempArray.add(Holder);
	}

	return tempArray;

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

public void updateLocation(Map<String, ArrayList<String>> item,
		String itemType) throws SQLException {

	Set<String> keys = item.keySet();
	String query = "UPDATE " + itemType + " SET ";
	boolean firstValue = true;

	for (String index : keys) {

		if (firstValue) {
			query += index + "=?";
			firstValue = false;
		} else
			query += "," + index + "=?";
	}

	query += " WHERE LOCATIONS_ID=?";

	connection();
	PreparedStatement statement = connection.prepareStatement(query);

	int itemID = 0;
	int count = 0;
	for (String index : keys) {
		count++;

		ArrayList<String> hold = item.get(index);

		if (index.equals("LOCATIONS_ID"))
			itemID = Integer.parseInt(hold.get(0));

		if (hold.get(1).equals("int") || hold.get(1).equals("Integer"))
			statement.setInt(count, Integer.parseInt(hold.get(0)));

		else if (hold.get(1).equals("Double"))
			statement.setDouble(count, Double.parseDouble(hold.get(0)));

		else if (hold.get(1).equals("String"))
			statement.setString(count, hold.get(0));

		else
			System.out.println("Insert Error - Datatype Unknown");

	}

	statement.setInt(count + 1, itemID);

	statement.executeUpdate();

	closeResources(statement, connection);
}

public void updateEmployees(Map<String, ArrayList<String>> item,
		String itemType) throws SQLException {

	Set<String> keys = item.keySet();
	String query = "UPDATE " + itemType + " SET ";
	boolean firstValue = true;

	for (String index : keys) {

		if (firstValue) {
			query += index + "=?";
			firstValue = false;
		} else
			query += "," + index + "=?";
	}

	query += " WHERE EMP_ID=?";

	connection();
	PreparedStatement statement = connection.prepareStatement(query);

	int itemID = 0;
	int count = 0;
	for (String index : keys) {
		count++;

		ArrayList<String> hold = item.get(index);

		if (index.equals("EMP_ID"))
			itemID = Integer.parseInt(hold.get(0));

		if (hold.get(1).equals("int") || hold.get(1).equals("Integer"))
			statement.setInt(count, Integer.parseInt(hold.get(0)));

		else if (hold.get(1).equals("Double"))
			statement.setDouble(count, Double.parseDouble(hold.get(0)));

		else if (hold.get(1).equals("String"))
			statement.setString(count, hold.get(0));

		else
			System.out.println("Insert Error - Datatype Unknown");

	}

	statement.setInt(count + 1, itemID);

	statement.executeUpdate();

	closeResources(statement, connection);
}

public void insertLoc(String itemType,LocationGoogle locGoogle) throws SQLException {

	connection();
	String query = "INSERT INTO " + itemType + " VALUES (?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement statement = connection.prepareStatement(query);
	statement.setString(1, locGoogle.getItemID());
	statement.setString(2, locGoogle.getLatitude());
	statement.setString(3, locGoogle.getLongitude());
	statement.setString(4, locGoogle.getTitle());
	statement.setString(5, locGoogle.getDescription());
	statement.setString(6, locGoogle.getStreet());
	statement.setString(7, locGoogle.getCity());
	statement.setString(8, locGoogle.getState());
	statement.setString(9, locGoogle.getZip());
	statement.setString(10, "4444444444");
	statement.executeUpdate();

	closeResources(statement, connection);
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