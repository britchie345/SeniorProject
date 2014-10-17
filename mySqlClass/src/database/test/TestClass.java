package database.test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import database.tools.MySQLDatabase;


public class TestClass {

	public static void main(String[] args) {
		
		MySQLDatabase database = new MySQLDatabase();
		
		//ArrayList<String> x = database.getAllMenu_Item();
		
		//ArrayList<String> x = database.getAllItemType();
		
		ArrayList<String> x = database.getAllType_Included();
		
		for(String i: x)
			System.out.println(i);
		
		/*
		Map<String, String> items = new HashMap<String, String>();
		
		items.put("ITEM_ID", "int");
		items.put("NAME", "String");
		items.put("MENU_DESC", "String");
		items.put("PRICE", "Double");
		
		//items.put("ITEM_ID", "int");
		//items.put("TYPE_ID", "String");

	    //boolean all, List<Integer> idNumber, String itemType, Map<String, String> item
		
		try {
			
			ArrayList<String> test = (ArrayList<String>) database.getItems(true, null, "MENU_ITEM", items);
			
			ArrayList<Integer> IDs = new ArrayList<Integer>();
			IDs.add(1);
			IDs.add(2);
			
			//ArrayList<String> test = (ArrayList<String>) database.getItems(false, IDs, "MENU_ITEM", items);

			//ArrayList<String> test = database.getSingleMenu_Item(1);
			
			//ArrayList<String> test = (ArrayList<String>) database.getItems(false, IDs, "ITEM_TYPE", items);
			
			for(String index: test)
				System.out.println(index);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		*/
		
		System.out.println("Finished");
	}
	
}
