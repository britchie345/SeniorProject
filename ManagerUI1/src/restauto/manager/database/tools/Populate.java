package restauto.manager.database.tools;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import restauto.manager.menu.levelc.model.Type;
import restauto.manager.database.tools.MySQLDatabase;

public class Populate {

    private ObservableList<Type> type = FXCollections.observableArrayList();
    private MySQLDatabase database = new MySQLDatabase();

	public Populate() {
		
        // Add some sample data
		//type.add(new Type(1, "Drinks", "Drinks"));
		//type.add(new Type(2, "Appetizer", "Drinks"));
		//type.add(new Type(3, "Entree", "Drinks"));
	}
	
	public ObservableList<Type> getType(String key) {
		
		try {
			
			ArrayList<LinkedHashMap<String, ArrayList<String>>> table = database.getItems(true, null, key);
			
			for(LinkedHashMap<String, ArrayList<String>> index1: table) {
				type.add(new Type(
							index1.get("TYPE_ID").get(0),
							index1.get("NAME").get(0),
							//index1.get("DESCRIPTION").get(0))
							"")
						);
				
//				System.out.println("\n\n");
//				System.out.println("TYPE_ID=" + index1.get("TYPE_ID").get(0));
//				System.out.println("NAME=" + index1.get("NAME").get(0));
//				System.out.println("DESCRIPTION=" + index1.get("DESCRIPTION").get(0));
			}
			
			System.out.println("\n\n\n");
			
			return type;
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}
	
}