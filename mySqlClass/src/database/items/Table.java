package database.items;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;


public class Table {
	
	protected LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> items = 
			new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>();
	
	@SuppressWarnings("serial")
	public Table() {
		
		items.put("MENU_ITEM", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("ITEM_ID", 
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("CALORIES",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("ONMENU",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("SPICY",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("RECOMMENDED",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("PRICE",
					new ArrayList<String>(){{ add(""); add("Double"); }});
			put("NAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("MENU_DESC",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("DESCRIPTION",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("COOKTIME",
					new ArrayList<String>(){{ add(""); add("String"); }});
			}});
		
		items.put("ITEM_TYPE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("ITEM_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("TYPE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			}});
                
		items.put("CUSTOMER", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("CUSTOMER_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("FIRSTNAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("LASTNAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("DOB",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("PHONE",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("EMAIL",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("STREET",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("CITY",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("STATE",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("ZIP",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("SUBSCRIBED",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("REWARDS",
					new ArrayList<String>(){{ add(""); add("int"); }});
			}});
                
		items.put("DESTINATION", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("ITEM_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("POS_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			}});
                
        items.put("EMPLOYEE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("EMP_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("USERNAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("PASSWORD",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("FIRSTNAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("LASTNAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
            }});
                
        items.put("EMP_POS", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("EMP_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("POS_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			}});
                
        items.put("INGREDIENT", new LinkedHashMap<String, ArrayList<String>>(){{
			
            put("INGREDIENT_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("NAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("DESCRIPTION",
					new ArrayList<String>(){{ add(""); add("String"); }});
			}});
                
        items.put("INGREDIENT_CATEGORIES", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("INGREDIENT_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("I_TYPE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			}});
                
        items.put("INGREDIENT_TYPE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("I_TYPE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("NAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
			put("DESCRIPTION",
					new ArrayList<String>(){{ add(""); add("String"); }});
			}});
                
                
        items.put("LOGIN_INFO", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("CUSTOMER_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("USERNAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
            put("PASSWORD",
					new ArrayList<String>(){{ add(""); add("String"); }});
            put("ACCESS_LEVEL",
					new ArrayList<String>(){{ add(""); add("int"); }});
			}});
                
        items.put("OPTIONS", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("OPTION_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("NAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
            put("DESCRIPTION",
					new ArrayList<String>(){{ add(""); add("String"); }});
            }});
                
        items.put("OPTION_GROUPING", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("OPTION_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("OPTIONTYPE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
                }});
                
        items.put("OPTION_TYPE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("OPTIONTYPE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("DESCRIPTION",
					new ArrayList<String>(){{ add(""); add("String"); }});
            put("REQUIRED",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("PRICE",
					new ArrayList<String>(){{ add(""); add("Double"); }});
			}});
                
        items.put("ORDERS", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("ORDER_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("SALE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("ITEM_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("REQUEST",
					new ArrayList<String>(){{ add(""); add("String"); }});
			}});
                
        items.put("ORDERS_ARCHIVE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("ORDER_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("SALE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("ITEM_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("REQUEST",
					new ArrayList<String>(){{ add(""); add("String"); }});
			}});
                
                
        items.put("ORDER_OPTIONS", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("ORDER_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("OPTION_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
                     
			}});
                
        items.put("POSITIONS", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("POS_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("NAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
                     
			}});
                
        items.put("RECIPE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("INGREDIENT_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("ITEM_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
                     
			}});
                
        items.put("SALE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("SALE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("USER_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("TABLE_NUM",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("DATE",
					new ArrayList<String>(){{ add(""); add("String"); }});
            put("ARRIVE_TIME",
					new ArrayList<String>(){{ add(""); add("String"); }});
            put("SERVE_TIME",
					new ArrayList<String>(){{ add(""); add("String"); }});
            put("ifApp",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("ifCarry",
					new ArrayList<String>(){{ add(""); add("int"); }});
                     
			}});
                 
                 
        items.put("SUB_TYPE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("TYPE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("SUBTYPE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
                     
			}});
                 
        items.put("TYPE", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("TYPE_ID",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("NAME",
					new ArrayList<String>(){{ add(""); add("String"); }});
            put("DESCRIPTION",
					new ArrayList<String>(){{ add(""); add("String"); }});
                     
			}});
                 
        items.put("TYPE_INCLUDED", new LinkedHashMap<String, ArrayList<String>>(){{
			
			put("TYPE_ONE",
					new ArrayList<String>(){{ add(""); add("int"); }});
			put("TYPE_TWO",
					new ArrayList<String>(){{ add(""); add("int"); }});
            put("NUMNBER",
					new ArrayList<String>(){{ add(""); add("int"); }});
                     
			}});       
	}
	
	public LinkedHashMap<String, String> getTableAttributeValuePair(String key) {
		
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();

		Set<String> keys = items.get(key).keySet();
		for(String index: keys) {
			result.put(index, items.get(key).get(index).get(1));
		}
		
		return result;
	}
	
	public LinkedHashMap<String, ArrayList<String>> getLinkedHashMap(String key) {
		
		return items.get(key);
	}
	
	public LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> getContainer() {
		
		return items;
	}

}