package database.items;

import java.util.ArrayList;

public class Type extends Table {

	@SuppressWarnings("serial")
	public Type() {
		
		items.put("NAME",
				new ArrayList<String>(){{ add(""); add("String"); }});
		items.put("DESCRIPTION",
				new ArrayList<String>(){{ add(""); add("String"); }});
		items.put("TYPE_ID",
				new ArrayList<String>(){{ add(""); add("int"); }});
	}
	
}