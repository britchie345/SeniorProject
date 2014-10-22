package restauto.manager.menu.levelc.view;

import restauto.manager.menu.levelc.MainApp;
import restauto.manager.menu.levelc.model.Levelc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LevelaOverviewController {
	
	@FXML
    private TableView<Levelc> typebTable;
    @FXML
    private TableColumn<Levelc, String> nameColumn;
    
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
//    	// Initialize the levelb table with the one column.
//        nameColumn.setCellValueFactory(
//                cellData -> cellData.getValue().firstNameProperty());
//        
//        // Listen for selection changes and show the person details when changed.
//        typebTable.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Fills all text fields to show details about the typeb item.
     * If the specified item is null, all text fields are cleared.
     * 
     * @param levelb the person or null
     */
	@SuppressWarnings("unused")
	private void showPersonDetails(Levelc c) {
        if (c != null) {
            // Fill the labels with info from the person object.
        	typeID.setText(c.getFirstName());
        	name.setText(c.getLastName());
        	descripton.setText(c.getStreet());
            totalSubItems.setText(c.getCity());
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
	    
		mainApp.showLevelbOverview();
	}
	
	/**
	 * Called when the user clicks the new button.
	 */
	@FXML
	private void handleNew() {
	    
	}

}























