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
import restauto.manager.menu.levelc.model.Employee;
import restauto.manager.menu.levelc.model.LocationGoogle;
//import restauto.manager.menu.levelc.model.Levelc;
import restauto.manager.menu.levelc.model.Menu_Item;
import restauto.manager.menu.levelc.model.Type;

@SuppressWarnings("deprecation")
public class EmployeeOverviewController {
    @FXML
    private TableView<Employee> menuItemTable;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> idColumn;

    @FXML
    private Label idLabel;
    @FXML
    private Label userLabel;
    @FXML
    private Label passLabel;
    @FXML
    private Label fnameLabel;
    @FXML
    private Label lnameLabel;
    
    // Reference to the main application.
    private MainApp mainApp;
    
    // Hold the Type ID from Home Page
    String clickedID;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public EmployeeOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
        // Initialize the Menu Item table with the two columns.
        nameColumn.setCellValueFactory(
                cellData -> cellData.getValue().getUsernameProperty());
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
        menuItemTable.setItems(mainApp.getEmployee());
    }
    
    /**
     * Fills all text fields to show details about the Locations.
     * If the specified Menu Item is null, all text fields are cleared.
     * 
     * @param The Menu Item or null
     */
    private void showPersonDetails(Employee c) {
        if (c != null) {
        	
            // Fill the labels with info from the Menu_Item object.
        	idLabel.setText         (c.getItemID());
        	userLabel.setText       (c.getUsername());
        	passLabel.setText      (c.getPassword());
        	fnameLabel.setText   (c.getFname());
        	lnameLabel.setText     (c.getLname());
        	
        } else {
	
            // Menu Item is null, remove all the text.
        	idLabel.setText         ("");
        	userLabel.setText       ("");
        	passLabel.setText      ("");
        	fnameLabel.setText   ("");
        	lnameLabel.setText     ("");
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
		
	    Employee tempMenuItem = new Employee();
	    boolean okClicked = mainApp.showEmployeeEditDialog(tempMenuItem);
	    if (okClicked) {
	        mainApp.getEmployee().add(tempMenuItem);
	        
	        /***************************************/
	        //Add new Menu Item to database Menu_Item table
			LinkedHashMap<String, ArrayList<String>> item = new LinkedHashMap<String, ArrayList<String>>();
			item.put("EMP_ID",     new ArrayList<String>(){{ add(tempMenuItem.getItemID());      add("int"); }});
			item.put("USERNAME",    new ArrayList<String>(){{ add(tempMenuItem.getUsername());    add("String"); }});
			item.put("PASSWORD",      new ArrayList<String>(){{ add(tempMenuItem.getPassword());      add("String"); }});
			item.put("FIRSTNAME",       new ArrayList<String>(){{ add(tempMenuItem.getFname());       add("String"); }});
			item.put("LASTNAME", new ArrayList<String>(){{ add(tempMenuItem.getLname());  add("String"); }});
			
			
			MySQLDatabase database = new MySQLDatabase();
			try {
				database.insertItem(item, "EMPLOYEE");
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
		Employee tempMenuItem = menuItemTable.getSelectionModel().getSelectedItem();
	    if (tempMenuItem != null) {
	        boolean okClicked = mainApp.showEmployeeEditDialog(tempMenuItem);
	        if (okClicked) {
	            showPersonDetails(tempMenuItem);
	            
		        /***************************************/
		        //Add new Menu Item to database Menu_Item table
				LinkedHashMap<String, ArrayList<String>> item = new LinkedHashMap<String, ArrayList<String>>();
				item.put("EMP_ID",     new ArrayList<String>(){{ add(tempMenuItem.getItemID());      add("int"); }});
				item.put("USERNAME",    new ArrayList<String>(){{ add(tempMenuItem.getUsername());    add("String"); }});
				item.put("PASSWORD",      new ArrayList<String>(){{ add(tempMenuItem.getPassword());      add("String"); }});
				item.put("FIRSTNAME",       new ArrayList<String>(){{ add(tempMenuItem.getFname());       add("String"); }});
				item.put("LASTNAME", new ArrayList<String>(){{ add(tempMenuItem.getLname());  add("String"); }});
				
				
				MySQLDatabase database = new MySQLDatabase();
				try {
					database.updateEmployees(item, "EMPLOYEE");
				} catch (NumberFormatException | SQLException e) {
					e.printStackTrace();
				//}
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
	}}
    
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
	    int selectedIndex = menuItemTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	    	
	    	Employee selectedMenuItem = menuItemTable.getSelectionModel().getSelectedItem();
	    	MySQLDatabase database = new MySQLDatabase();
			try {
				database.deleteEmployee("EMPLOYEE", Integer.parseInt(selectedMenuItem.getItemID()));
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
	    	
	    	menuItemTable.getItems().remove(selectedIndex);
	    	
	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Employee Selected")
	            .message("Please select an Employee in the table.")
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