package database.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public abstract class Table {
	
	protected Map<String, ArrayList<String>> items = new HashMap<String, ArrayList<String>>();
	
	public Object getItemValue(int index) {
		
		ArrayList<String> item = items.get(index);
		
		if(item.get(1).equals("int"))
			return getInt(item.get(0));
		
		else if(item.get(1).equals("Double"))
			return getDouble(item.get(0));
		
		else if(item.get(1).equals("String"))
			return item.get(0);
		else
			return null;
	}
	
    private int getInt(String item) {
    	
    	return Integer.parseInt(item);
    }
    
    private Double getDouble(String item) {
    	
    	return Double.parseDouble(item);
    }

}
