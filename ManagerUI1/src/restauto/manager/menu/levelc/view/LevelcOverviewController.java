package restauto.manager.menu.levelc.view;

import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import restauto.manager.menu.levelc.MainApp;
//import restauto.manager.menu.levelc.model.Levelc;
import restauto.manager.menu.levelc.model.Menu_Item;

@SuppressWarnings("deprecation")
public class LevelcOverviewController {
    @FXML
    //private TableView<Levelc> personTable;
    private TableView<Menu_Item> menuItemTable;
    @FXML
    //private TableColumn<Levelc, String> firstNameColumn;
    private TableColumn<Menu_Item, String> nameColumn;
    @FXML
    //private TableColumn<Levelc, String> lastNameColumn;
    private TableColumn<Menu_Item, String> idColumn;

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label caloriesLabel;
    @FXML
    private Label onMenuLabel;
    @FXML
    private Label cookTimeLabel;
    @FXML
    private Label desciptionLabel;
    @FXML
    private Label menuDescLabel;
    @FXML
    private Label spicyLabel;
    @FXML
    private Label recomendedLabel;
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LevelcOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
        // Initialize the Menu Item table with the two columns.
        nameColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());
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
        this.mainApp = mainApp;

        // Add observable list data to the table
        menuItemTable.setItems(mainApp.getMenuItems());
    }
    
    /**
     * Fills all text fields to show details about the Menu Item.
     * If the specified Menu Item is null, all text fields are cleared.
     * 
     * @param The Menu Item or null
     */
    private void showPersonDetails(Menu_Item c) {
        if (c != null) {
        	
            // Fill the labels with info from the Menu_Item object.
        	idLabel.setText         (c.getItemID());
        	nameLabel.setText       (c.getName());
        	priceLabel.setText      (c.getPrice());
        	caloriesLabel.setText   (c.getCalories());
        	onMenuLabel.setText     (c.getOnMenu());
        	cookTimeLabel.setText   (c.getCookTime());
        	desciptionLabel.setText (c.getDescription());
        	menuDescLabel.setText   (c.getMenuDesc());
        	spicyLabel.setText      (c.getSpicy());
        	recomendedLabel.setText (c.getRecomended());
        	
        } else {
	
            // Menu Item is null, remove all the text.
        	idLabel.setText         ("");
        	nameLabel.setText       ("");
        	priceLabel.setText      ("");
        	caloriesLabel.setText   ("");
        	onMenuLabel.setText     ("");
        	cookTimeLabel.setText   ("");
        	desciptionLabel.setText ("");
        	menuDescLabel.setText   ("");
        	spicyLabel.setText      ("");
        	recomendedLabel.setText ("");
        }
    }
	
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
	    int selectedIndex = menuItemTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	    	menuItemTable.getItems().remove(selectedIndex);
	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Menu Item Selected")
	            .message("Please select a Menu Item in the table.")
	            .showWarning();
	    }
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new Menu_Item.
	 */
	@FXML
	private void handleNewMenuItem() {
		
	    Menu_Item tempMenuItem = new Menu_Item();
	    boolean okClicked = mainApp.showMenuItemEditDialog(tempMenuItem);
	    if (okClicked) {
	        mainApp.getMenuItems().add(tempMenuItem);
	    }	
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected Menu_Item.
	 */
	@FXML
	private void handleEditPerson() {
		Menu_Item selectedPerson = menuItemTable.getSelectionModel().getSelectedItem();
	    if (selectedPerson != null) {
	        boolean okClicked = mainApp.showMenuItemEditDialog(selectedPerson);
	        if (okClicked) {
	            showPersonDetails(selectedPerson);
	        }

	    } else {
	        // Nothing selected.
	        Dialogs.create()
	            .title("No Selection")
	            .masthead("No Menu Item Selected")
	            .message("Please select a Menu Item in the table.")
	            .showWarning();
	    }
	}
	
	/**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleBackward() {
		
		//mainApp.showLevelbOverview();
		mainApp.showLevelaOverview();
	}
 
}