package restauto.cook.display.view;

//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;

//import org.controlsfx.dialog.Dialogs;


import restauto.cook.display.Main;
//import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import restauto.manager.database.tools.MySQLDatabase;
//import restauto.manager.menu.levelc.MainApp;
//import restauto.manager.menu.levelc.model.Levelc;
//import restauto.manager.menu.levelc.model.Menu_Item;

//@SuppressWarnings("deprecation")
public class MainDisplayController {
    //@FXML
    //private TableView<Levelc> personTable;
    //private TableView<Menu_Item> menuItemTable;
    //@FXML
    //private TableColumn<Levelc, String> firstNameColumn;
    //private TableColumn<Menu_Item, String> nameColumn;
    //@FXML
    //private TableColumn<Levelc, String> lastNameColumn;
    //private TableColumn<Menu_Item, String> idColumn;

//    @FXML
//    private Label idLabel;
//    @FXML
//    private Label nameLabel;
//    @FXML
//    private Label priceLabel;
//    @FXML
//    private Label caloriesLabel;
//    @FXML
//    private Label onMenuLabel;
//    @FXML
//    private Label cookTimeLabel;
//    @FXML
//    private Label desciptionLabel;
//    @FXML
//    private Label menuDescLabel;
//    @FXML
//    private Label spicyLabel;
    @FXML
    private Button backButton;
    
    // Reference to the main application.
    private Main main;
    
    // Hold the Type ID from Levela
    String clickedID;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MainDisplayController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
//        // Initialize the Menu Item table with the two columns.
//        nameColumn.setCellValueFactory(
//                cellData -> cellData.getValue().getNameProperty());
//        idColumn.setCellValueFactory(
//                cellData -> cellData.getValue().getItemIDProperty());
//
//        // Clear Menu Item details.
//        showPersonDetails(null);
//
//        // Listen for selection changes and show the Menu Item details when changed.
//        menuItemTable.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    //public void setMainApp(MainApp mainApp) {
    public void setMainApp(Main main, String clickedID) {
    	
    	//Save reference to main app
        this.main = main;
        
        //Save reference to Type clicked on in Levela
        this.clickedID = clickedID;

        // Add observable list data to the table
        //menuItemTable.setItems(mainApp.getMenuItems());
    }
    
//    /**
//     * Fills all text fields to show details about the Menu Item.
//     * If the specified Menu Item is null, all text fields are cleared.
//     * 
//     * @param The Menu Item or null
//     */
//    private void showPersonDetails(Menu_Item c) {
//        if (c != null) {
//        	
//            // Fill the labels with info from the Menu_Item object.
//        	idLabel.setText         (c.getItemID());
//        	nameLabel.setText       (c.getName());
//        	priceLabel.setText      (c.getPrice());
//        	caloriesLabel.setText   (c.getCalories());
//        	onMenuLabel.setText     (c.getOnMenu());
//        	cookTimeLabel.setText   (c.getCookTime());
//        	desciptionLabel.setText (c.getDescription());
//        	menuDescLabel.setText   (c.getMenuDesc());
//        	spicyLabel.setText      (c.getSpicy());
//        	recomendedLabel.setText (c.getRecomended());
//        	
//        } else {
//	
//            // Menu Item is null, remove all the text.
//        	idLabel.setText         ("");
//        	nameLabel.setText       ("");
//        	priceLabel.setText      ("");
//        	caloriesLabel.setText   ("");
//        	onMenuLabel.setText     ("");
//        	cookTimeLabel.setText   ("");
//        	desciptionLabel.setText ("");
//        	menuDescLabel.setText   ("");
//        	spicyLabel.setText      ("");
//        	recomendedLabel.setText ("");
//        }
//    }
//	
//	/**
//	 * Called when the user clicks on the delete button.
//	 */
//	@FXML
//	private void handleDeletePerson() {
//	    int selectedIndex = menuItemTable.getSelectionModel().getSelectedIndex();
//	    if (selectedIndex >= 0) {
//	    	
//	    	Menu_Item selectedMenuItem = menuItemTable.getSelectionModel().getSelectedItem();
//	    	MySQLDatabase database = new MySQLDatabase();
//			try {
//				database.deleteItem("MENU_ITEM", Integer.parseInt(selectedMenuItem.getItemID()));
//				database.deleteItem("ITEM_TYPE", Integer.parseInt(selectedMenuItem.getItemID()));
//			} catch (NumberFormatException | SQLException e) {
//				e.printStackTrace();
//			}
//	    	
//	    	menuItemTable.getItems().remove(selectedIndex);
//	    	
//	    } else {
//	        // Nothing selected.
//	        Dialogs.create()
//	            .title("No Selection")
//	            .masthead("No Menu Item Selected")
//	            .message("Please select a Menu Item in the table.")
//	            .showWarning();
//	    }
//	}
//	
//	/**
//	 * Called when the user clicks the new button. Opens a dialog to edit
//	 * details for a new Menu_Item.
//	 */
//	@SuppressWarnings("serial")
//	@FXML
//	private void handleNewMenuItem() {
//		
//	    Menu_Item tempMenuItem = new Menu_Item();
//	    boolean okClicked = mainApp.showMenuItemEditDialog(tempMenuItem);
//	    if (okClicked) {
//	        mainApp.getMenuItems().add(tempMenuItem);
//	        
//	        /***************************************/
//	        //Add new Menu Item to database Menu_Item table
//			LinkedHashMap<String, ArrayList<String>> item = new LinkedHashMap<String, ArrayList<String>>();
//			item.put("ITEM_ID",     new ArrayList<String>(){{ add(tempMenuItem.getItemID());      add("int"); }});
//			item.put("CALORIES",    new ArrayList<String>(){{ add(tempMenuItem.getCalories());    add("int"); }});
//			item.put("ONMENU",      new ArrayList<String>(){{ add(tempMenuItem.getOnMenu());      add("int"); }});
//			item.put("SPICY",       new ArrayList<String>(){{ add(tempMenuItem.getSpicy());       add("int"); }});
//			item.put("RECOMMENDED", new ArrayList<String>(){{ add(tempMenuItem.getRecomended());  add("int"); }});
//			item.put("PRICE",       new ArrayList<String>(){{ add(tempMenuItem.getPrice());       add("Double"); }});
//			item.put("NAME",        new ArrayList<String>(){{ add(tempMenuItem.getName());        add("String"); }});
//			item.put("MENU_DESC",   new ArrayList<String>(){{ add(tempMenuItem.getMenuDesc());    add("String"); }});
//			item.put("DESCRIPTION", new ArrayList<String>(){{ add(tempMenuItem.getDescription()); add("String"); }});
//			item.put("COOKTIME",    new ArrayList<String>(){{ add(tempMenuItem.getCookTime());    add("String"); }});
//	        
//			//Add new Menu Item to database Link Table
//			LinkedHashMap<String, ArrayList<String>> link = new LinkedHashMap<String, ArrayList<String>>();
//			link.put("ITEM_ID", new ArrayList<String>(){{ add(tempMenuItem.getItemID()); add("int"); }});
//			link.put("TYPE_ID", new ArrayList<String>(){{ add(clickedID);                add("int"); }});
//			
//			MySQLDatabase database = new MySQLDatabase();
//			try {
//				database.insertItem(item, "MENU_ITEM");
//				database.insertItem(link, "ITEM_TYPE");
//			} catch (NumberFormatException | SQLException e) {
//				e.printStackTrace();
//			}
//			/***************************************/
//	    }	
//	}
//
//	/**
//	 * Called when the user clicks the edit button. Opens a dialog to edit
//	 * details for the selected Menu_Item.
//	 */
//	@SuppressWarnings("serial")
//	@FXML
//	private void handleEditPerson() {
//		Menu_Item selectedMenuItem = menuItemTable.getSelectionModel().getSelectedItem();
//	    if (selectedMenuItem != null) {
//	        boolean okClicked = mainApp.showMenuItemEditDialog(selectedMenuItem);
//	        if (okClicked) {
//	            showPersonDetails(selectedMenuItem);
//	            
//		        /***************************************/
//		        //Add new Menu Item to database Menu_Item table
//				LinkedHashMap<String, ArrayList<String>> item = new LinkedHashMap<String, ArrayList<String>>();
//				item.put("ITEM_ID",     new ArrayList<String>(){{ add(selectedMenuItem.getItemID());      add("int"); }});
//				item.put("CALORIES",    new ArrayList<String>(){{ add(selectedMenuItem.getCalories());    add("int"); }});
//				item.put("ONMENU",      new ArrayList<String>(){{ add(selectedMenuItem.getOnMenu());      add("int"); }});
//				item.put("SPICY",       new ArrayList<String>(){{ add(selectedMenuItem.getSpicy());       add("int"); }});
//				item.put("RECOMMENDED", new ArrayList<String>(){{ add(selectedMenuItem.getRecomended());  add("int"); }});
//				item.put("PRICE",       new ArrayList<String>(){{ add(selectedMenuItem.getPrice());       add("Double"); }});
//				item.put("NAME",        new ArrayList<String>(){{ add(selectedMenuItem.getName());        add("String"); }});
//				item.put("MENU_DESC",   new ArrayList<String>(){{ add(selectedMenuItem.getMenuDesc());    add("String"); }});
//				item.put("DESCRIPTION", new ArrayList<String>(){{ add(selectedMenuItem.getDescription()); add("String"); }});
//				item.put("COOKTIME",    new ArrayList<String>(){{ add(selectedMenuItem.getCookTime());    add("String"); }});
//		        
//				//Add new Menu Item to database Link Table
//				LinkedHashMap<String, ArrayList<String>> link = new LinkedHashMap<String, ArrayList<String>>();
//				link.put("ITEM_ID", new ArrayList<String>(){{ add(selectedMenuItem.getItemID()); add("int"); }});
//				link.put("TYPE_ID", new ArrayList<String>(){{ add(clickedID);                add("int"); }});
//				
//				MySQLDatabase database = new MySQLDatabase();
//				try {
//					database.updateItems(item, "MENU_ITEM");
//					database.updateItems(link, "ITEM_TYPE");
//				} catch (NumberFormatException | SQLException e) {
//					e.printStackTrace();
//				}
//				/***************************************/   
//	            
//	        }
//
//	    } else {
//	        // Nothing selected.
//	        Dialogs.create()
//	            .title("No Selection")
//	            .masthead("No Menu Item Selected")
//	            .message("Please select a Menu Item in the table.")
//	            .showWarning();
//	    }
//	}
	
	/**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleBackward() {
		
		//mainApp.showLevelbOverview();
		main.showHomePageOverview();
	}
 
}