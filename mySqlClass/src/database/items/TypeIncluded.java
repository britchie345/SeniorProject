package database.items;

import java.util.ArrayList;

public class TypeIncluded extends Table {
		
	@SuppressWarnings("serial")
	public TypeIncluded() {
		
		items.put("TYPEONE",
				new ArrayList<String>(){{ add(""); add("int"); }});
		items.put("TYPETWO",
				new ArrayList<String>(){{ add(""); add("int"); }});
		items.put("NUMBER",
				new ArrayList<String>(){{ add(""); add("int"); }});
	}
    
}