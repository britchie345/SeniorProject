package restauto.manager.menu.levelc.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import restauto.manager.database.tools.MySQLDatabase;
import restauto.manager.menu.levelc.MainApp;
import restauto.manager.menu.levelc.model.LocationGoogle;
//import restauto.manager.menu.levelc.model.Levelc;
import restauto.manager.menu.levelc.model.Menu_Item;

@SuppressWarnings("deprecation")
public class LocationOverviewController {
    @FXML
    private TableView<LocationGoogle> menuItemTable;
    @FXML
    private TableColumn<LocationGoogle, String> nameColumn;
    @FXML
    private TableColumn<LocationGoogle, String> idColumn;

    @FXML
    private Label idLabel;
    @FXML
    private Label latLabel;
    @FXML
    private Label longLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label stateLabel;
    @FXML
    private Label zipLabel;
    
    // Reference to the main application.
    private MainApp mainApp;
    
    // Hold the Type ID from Home Page
    String clickedID;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LocationOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
        // Initialize the Menu Item table with the two columns.
        nameColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTitleProperty());
        idColumn.setCellValueFactory(
                cellData -> cellData.getValue().getItemIDProperty());

        // Clear Menu Item details.
        showPersonDetails(null);

        // Listen for selection changes and show the Menu Item details when changed.
        menuItemTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    //public void setMainApp(MainApp mainApp) {
    public void setMainApp(MainApp mainApp, String clickedID) {
    	
    	//Save reference to main app
        this.mainApp = mainApp;
        
        //Initiate clickedID from main
        this.clickedID = clickedID;

        // Add observable list data to the table
        menuItemTable.setItems(mainApp.getLocation());
    }
    
    /**
     * Fills all text fields to show details about the Locations.
     * If the specified Menu Item is null, all text fields are cleared.
     * 
     * @param The Menu Item or null
     */
    private void showPersonDetails(LocationGoogle c) {
        if (c != null) {
        	
            // Fill the labels with info from the Menu_Item object.
        	idLabel.setText         (c.getItemID());
        	titleLabel.setText       (c.getTitle());
        	latLabel.setText      (c.getLatitude());
        	longLabel.setText   (c.getLongitude());
        	descLabel.setText     (c.getDescription());
        	streetLabel.setText   (c.getStreet());
        	cityLabel.setText (c.getCity());
        	stateLabel.setText   (c.getState());
        	zipLabel.setText      (c.getZip());
        	
        } else {
	
            // Menu Item is null, remove all the text.
        	idLabel.setText         ("");
        	titleLabel.setText       ("");
        	latLabel.setText      ("");
        	longLabel.setText   ("");
        	descLabel.setText     ("");
        	streetLabel.setText   ("");
        	cityLabel.setText ("");
        	stateLabel.setText   ("");
        	zipLabel.setText      ("");
        }
    }
    
	
    /**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new Menu_Item.
	 */
	@SuppressWarnings("serial")
	//@SuppressWarnings("serial")
	@FXML
	private void handleNewMenuItem() {
		
	    LocationGoogle tempMenuItem = new LocationGoogle();
	    boolean okClicked = mainApp.showLocationEditDialog(tempMenuItem);
	    if (okClicked) {
	        mainApp.getLocation().add(tempMenuItem);
	        
	        /***************************************/
	        //Add new Menu Item to database Menu_Item table
			LinkedHashMap<String, ArrayList<String>> item = new LinkedHashMap<String, ArrayList<String>>();
			item.put("LOCATIONS_ID",     new ArrayList<String>(){{ add(tempMenuItem.getItemID());      add("int"); }});
			item.put("LAT",    new ArrayList<String>(){{ add(tempMenuItem.getLatitude());    add("String"); }});
			item.put("LONG",    new ArrayList<String>(){{ add(tempMenuItem.getLongitude());    add("String"); }});
			item.put("TITLE",       new ArrayList<String>(){{ add(tempMenuItem.getTitle());       add("String"); }});
			item.put("DESCRIPTION", new ArrayList<String>(){{ add(tempMenuItem.getDescription());  add("String"); }});
			item.put("STREET",       new ArrayList<String>(){{ add(tempMenuItem.getStreet());       add("String"); }});
			item.put("CITY",        new ArrayList<String>(){{ add(tempMenuItem.getCity());        add("String"); }});
			item.put("STATE",   new ArrayList<String>(){{ add(tempMenuItem.getState());    add("String"); }});
			item.put("ZIP", new ArrayList<String>(){{ add(tempMenuItem.getZip()); add("int"); }});
			
			
			MySQLDatabase database = new MySQLDatabase();
			try {
				database.insertLoc("LOCATIONS",tempMenuItem);
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			/***************************************/
	    }	
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected Menu_Item.
	 */
	@SuppressWarnings("serial")
	@FXML
	private void handleEditPerson() {
		LocationGoogle tempMenuItem = menuItemTable.getSelectionModel().getSelectedItem();
	    if (tempMenuItem != null) {
	        boolean okClicked = mainApp.showLocationEditDialog(tempMenuItem);
	        if (okClicked) {
	            showPersonDetails(tempMenuItem);
	            
		        /***************************************/
		        //Add new Menu Item to database Menu_Item table
				LinkedHashMap<String, ArrayList<String>> item = new LinkedHashMap<String, ArrayList<String>>();
				item.put("LOCATIONS_ID",     new ArrayList<String>(){{ add(tempMenuItem.getItemID());      add("int"); }});
				item.put("LAT",    new ArrayList<String>(){{ add(tempMenuItem.getLatitude());    add("String"); }});
				item.put("LONG",      new ArrayList<String>(){{ add(tempMenuItem.getLongitude());      add("String"); }});
				item.put("TITLE",       new ArrayList<String>(){{ add(tempMenuItem.getTitle());       add("String"); }});
				item.put("DESCRIPTION", new ArrayList<String>(){{ add(tempMenuItem.getDescription());  add("String"); }});
				item.put("STREET",       new ArrayList<String>(){{ add(tempMenuItem.getStreet());       add("String"); }});
				item.put("CITY",        new ArrayList<String>(){{ add(tempMenuItem.getCity());        add("String"); }});
				item.put("STATE",   new ArrayList<String>(){{ add(tempMenuItem.getState());    add("String"); }});
				item.put("ZIP", new ArrayList<String>(){{ add(tempMenuItem.getZip()); add("int"); }});
				
				MySQLDatabase database = new MySQLDatabase();
				try {
					database.deleteLocation("LOCATIONS", Integer.parseInt(tempMenuItem.getItemID()));
					database.insertLoc("LOCATIONS", tempMenuItem);
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				}
				/***************************************/   
	            
	        }

	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Location Selected")
	            .message("Please select a Location in the table.")
	            .showWarning();
	    }
	}
    
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
	    int selectedIndex = menuItemTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	    	
	    	LocationGoogle selectedMenuItem = menuItemTable.getSelectionModel().getSelectedItem();
	    	MySQLDatabase database = new MySQLDatabase();
			try {
				database.deleteLocation("LOCATIONS", Integer.parseInt(selectedMenuItem.getItemID()));
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
	    	
	    	menuItemTable.getItems().remove(selectedIndex);
	    	
	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Location Selected")
	            .message("Please select a Location in the table.")
	            .showWarning();
	    }
	}
	
	
	
	
	/**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleBackward() {
		
		//mainApp.showLevelbOverview();			
		//mainApp.showLevelaOverviewBack();
		mainApp.showHomePageOverview();
	}
 
}