package database.test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import database.tools.MySQLDatabase;


public class TestClass {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		MySQLDatabase database = new MySQLDatabase();
		
		Map<String, String> items = new HashMap<String, String>();
		
		items.put("ITEM_ID", "int");
		items.put("NAME", "String");
		items.put("MENU_DESC", "String");
		items.put("PRICE", "Double");
		
		//items.put("ITEM_ID", "int");
		//items.put("TYPE_ID", "String");

	    //boolean all, List<Integer> idNumber, String itemType, Map<String, String> item
		
		try {
			
			
			HashMap<String, ArrayList<String>> item = new HashMap<String, ArrayList<String>>();
				
			item.put("ITEM_ID", new ArrayList<String>(){{ add("1"); add("int"); }});
			item.put("PRICE", new ArrayList<String>(){{ add("200.59"); add("Double"); }});
			item.put("NAME", new ArrayList<String>(){{ add("MyAwesomeCOKE"); add("String"); }});
			
			
			ArrayList<String> x = item.get("ITEM_ID");
			System.out.println(x.get(0) + ", " + x.get(1));
			
			database.updateItems(item, "MENU_ITEM");
			//database.insertItem(item, "MENU_ITEM");
			//database.deleteItem("MENU_ITEM", 1);
			
			
			System.out.println("\n************\n\n");
			
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
		
		
		System.out.println("Finished");
	}
	
}
