package database.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import database.tools.MySQLDatabase;
import database.items.Table;


public class TestClass {
	
	private static void print(String string) {
		
		System.out.println(string);
	}

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		
//		print("Simple Test");
//		
//		ArrayList<Integer> xxx = new ArrayList<Integer>();
//		xxx.add(3);
//		xxx.add(1);
//		xxx.add(2);
//		
//		for(Integer blah: xxx)
//			print(Integer.toString(blah));
//		
//		print("\n");
	
		
		MySQLDatabase database = new MySQLDatabase();
		Table table = new Table();
		
		Map<String, String> items = new LinkedHashMap<String, String>();
		
		items = table.getTableAttributeValuePair("TYPE");
		
		Set<String> keys = items.keySet();
		for(String k: keys)
			print(k + " - " + items.get(k));
		
		//items.put("ITEM_ID", "int");
		//items.put("TYPE_ID", "String");

	    //boolean all, List<Integer> idNumber, String itemType, Map<String, String> item
		
		try {
			
			
			//HashMap<String, ArrayList<String>> item = new HashMap<String, ArrayList<String>>();
				
			//item.put("ITEM_ID", new ArrayList<String>(){{ add("1"); add("int"); }});
			//item.put("PRICE", new ArrayList<String>(){{ add("200.59"); add("Double"); }});
			//item.put("NAME", new ArrayList<String>(){{ add("MyAwesomeCOKE"); add("String"); }});
			
			
			//ArrayList<String> x = item.get("ITEM_ID");
			//System.out.println(x.get(0) + ", " + x.get(1));
			
			//database.updateItems(item, "MENU_ITEM");
			//database.insertItem(item, "MENU_ITEM");
			//database.deleteItem("MENU_ITEM", 1);
			
			
			//System.out.println("\n************\n\n");
			
			LinkedHashMap<String, String> item = new LinkedHashMap<String, String>();
			item.put("TYPE_ID",   "int");
			item.put("NAME",      "String");
			item.put("Description", "String");
			
			//ArrayList<String> test = (ArrayList<String>) database.getItems(true, null, "MENU_ITEM", items);
			//ArrayList<String> test = (ArrayList<String>) database.getItems(true, null, "TYPE", item);
			
			ArrayList<LinkedHashMap<String, ArrayList<String>>> test = (ArrayList<LinkedHashMap<String, ArrayList<String>>>) database.getItems(true, null, "TYPE");
			
			
			for(LinkedHashMap<String, ArrayList<String>> index: test) {
				
				Set<String> keys2 = index.keySet();
				
				for(String index2: keys2) {
					
					print("\nKey=" + index2 + "  Value=" + index.get(index2).get(0) + "  DataType=" + index.get(index2).get(0) + "\n");
				}
				
				print("\n\n\n");
				
			}
			
			
			
			ArrayList<Integer> IDs = new ArrayList<Integer>();
			IDs.add(1);
			IDs.add(2);
			
			//ArrayList<String> test = (ArrayList<String>) database.getItems(false, IDs, "MENU_ITEM", items);

			//ArrayList<String> test = database.getSingleMenu_Item(1);
			
			//ArrayList<String> test = (ArrayList<String>) database.getItems(false, IDs, "ITEM_TYPE", items);
			
			//for(String index: test)
			//	System.out.println(index);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		System.out.println("Finished");
	}
	
}
