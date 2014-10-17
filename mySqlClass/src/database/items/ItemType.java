package database.items;

import java.util.ArrayList;

public class ItemType extends Table {
	
	@SuppressWarnings("serial")
	public ItemType() {
		
		items.put("ITEM_ID",
				new ArrayList<String>(){{ add(""); add("int"); }});
		items.put("TYPE_ID",
				new ArrayList<String>(){{ add(""); add("int"); }});
	}
	
}