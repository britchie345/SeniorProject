package database.items;


import java.util.ArrayList;


public class MenuItem extends Table {
	
	@SuppressWarnings("serial")
	public MenuItem() {
		
		items.put("ITEM_ID",
				new ArrayList<String>(){{ add(""); add("int"); }});
		items.put("CALORIES",
				new ArrayList<String>(){{ add(""); add("int"); }});
		items.put("ONMENU",
				new ArrayList<String>(){{ add(""); add("int"); }});
		items.put("SPICY",
				new ArrayList<String>(){{ add(""); add("int"); }});
		items.put("RECOMMENDED",
				new ArrayList<String>(){{ add(""); add("int"); }});
		items.put("PRICE",
				new ArrayList<String>(){{ add(""); add("Double"); }});
		items.put("NAME",
				new ArrayList<String>(){{ add(""); add("String"); }});
		items.put("MENU_DESC",
				new ArrayList<String>(){{ add(""); add("String"); }});
		items.put("DESCRIPTION",
				new ArrayList<String>(){{ add(""); add("String"); }});
		items.put("COOKTIME",
				new ArrayList<String>(){{ add(""); add("String"); }});
	}
	
}