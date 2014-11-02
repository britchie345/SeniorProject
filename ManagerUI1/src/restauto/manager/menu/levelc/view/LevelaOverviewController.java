package restauto.manager.menu.levelc.view;

import restauto.manager.menu.levelc.MainApp;
import restauto.manager.menu.levelc.model.Type;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LevelaOverviewController {
	
	@FXML
    private TableView<Type> typebTable;
    @FXML
    private TableColumn<Type, String> nameColumn;
    
    @FXML
    private Label typeID;
    @FXML
    private Label name;
    @FXML
    private Label descripton;
    @FXML
    private Label totalSubItems;
    
    // Reference to the main application.
    private MainApp mainApp;
    
    // Save the clicked items id
    private String clickedID="";

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LevelaOverviewController() {
    }
	
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the levelb table with the one column.
        nameColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());
        
        // Clear person details.
        showTypeDetails(null);
        
        // Listen for selection changes and show the person details when changed.
        typebTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showTypeDetails(newValue));
        
        // Listen for selection changes and save clicked information
        // for when the forward button is clicked.
        typebTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> clickedID = newValue.getID());
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
     // Add observable list data to the table
        typebTable.setItems(mainApp.getTypeData());
    }
    
    /**
     * Fills all text fields to show details about the typeb item.
     * If the specified item is null, all text fields are cleared.
     * 
     * @param levelb the person or null
     */
	@SuppressWarnings("unused")
	private void showTypeDetails(Type c) {
        if (c != null) {
            // Fill the labels with info from the person object.
        	typeID.setText(c.getID());
        	name.setText(c.getName());
        	descripton.setText(c.getDescription());
            totalSubItems.setText("");
        } else {
            // Person is null, remove all the text.
        	typeID.setText("");
        	name.setText("");
        	descripton.setText("");
        	totalSubItems.setText("");
        }
    }
    
    /**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleBackward() {
	    
		mainApp.showHomePageOverview();
	}
	
	/**
	 * Called when the user clicks the delete button.
	 */
	@FXML
	private void handleDelete() {
	    
	}
	
	/**
	 * Called when the user clicks the edit button.
	 */
	@FXML
	private void handleEdit() {
	    
	}
	
	/**
	 * Called when the user clicks the forward button.
	 */
	@FXML
	private void handleForward() {
		
		//print("\n\n" + clickedID + "\n\n");
    	mainApp.clickedMenuItems(clickedID);
	    
		/**
		 *  This needs to be changed
		 *  back to showLevelbOverview
		 *  once we figure out how to
		 *  check for sub_types
		 */
		//mainApp.showLevelbOverview();
		mainApp.showLevelcOverview(clickedID);
	}
	
	/**
	 * Called when the user clicks the new button.
	 */
	@FXML
	private void handleNew() {
	    
	}
	
    static void print(String string) {
    	System.out.println(string);
    }

}























