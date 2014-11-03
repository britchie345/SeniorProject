//package restauto.manager.menu.levelc.view;
//
//import org.controlsfx.dialog.Dialogs;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import restauto.manager.menu.levelc.MainApp;
//import restauto.manager.menu.levelc.model.Levelc;
//
//@SuppressWarnings("deprecation")
//public class LevelbOverviewController {
//    @FXML
//    private TableView<Levelc> personTable;
//    @FXML
//    private TableColumn<Levelc, String> lastNameColumn;
//
//    @FXML
//    private Label lastNameLabel;
//    @FXML
//    private Label streetLabel;
//    @FXML
//    private Label birthdayLabel;
//
//    // Reference to the main application.
//    private MainApp mainApp;
//
//    /**
//     * The constructor.
//     * The constructor is called before the initialize() method.
//     */
//    public LevelbOverviewController() {
//    }
//
//    /**
//     * Initializes the controller class. This method is automatically called
//     * after the fxml file has been loaded.
//     */
//    @FXML
//    private void initialize() {
//        // Initialize the type table with the two columns.
//        lastNameColumn.setCellValueFactory(
//                cellData -> cellData.getValue().lastNameProperty());
//
//        // Clear type details.
//        showPersonDetails(null);
//
//        // Listen for selection changes and show the type details when changed.
//        personTable.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> showPersonDetails(newValue));
//    }
//
//    /**
//     * Is called by the main application to give a reference back to itself.
//     * 
//     * @param mainApp
//     */
//    public void setMainApp(MainApp mainApp) {
//        this.mainApp = mainApp;
//
//        // Add observable list data to the table
//        personTable.setItems(mainApp.getLevelcData());
//    }
//    
//    /**
//     * Fills all text fields to show details about the type.
//     * If the specified type is null, all text fields are cleared.
//     * 
//     * @param type the type or null
//     */
//	private void showPersonDetails(Levelc c) {
////        if (c != null) {
////            // Fill the labels with info from the type object.
////            lastNameLabel.setText(c.getLastName());
////            streetLabel.setText(c.getStreet());
////            birthdayLabel.setText(c.getBirthday());
////        } else {
////            // type is null, remove all the text.
////            lastNameLabel.setText("");
////            streetLabel.setText("");
////            birthdayLabel.setText("");
////        }
//    }
//	
//	/**
//	 * Called when the user clicks on the delete button.
//	 */
//	@FXML
//	private void handleDeletePerson() {
////	    int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
////	    if (selectedIndex >= 0) {
////	        personTable.getItems().remove(selectedIndex);
////	    } else {
////	        // Nothing selected.
////	        Dialogs.create()
////	            .title("No Selection")
////	            .masthead("No Type Selected")
////	            .message("Please select a Type in the table.")
////	            .showWarning();
////	    }
//	}
//	
//	/**
//	 * Called when the user clicks the new button. Opens a dialog to edit
//	 * details for a new type.
//	 */
//	@FXML
//	private void handleNewPerson() {
////	    Levelc tempPerson = new Levelc();
////	    boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
////	    if (okClicked) {
////	        mainApp.getLevelcData().add(tempPerson);
////	    }
//	}
//
//	/**
//	 * Called when the user clicks the edit button. Opens a dialog to edit
//	 * details for the selected type.
//	 */
//	@FXML
//	private void handleEditPerson() {
////		Levelc selectedPerson = personTable.getSelectionModel().getSelectedItem();
////	    if (selectedPerson != null) {
////	        boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
////	        if (okClicked) {
////	            showPersonDetails(selectedPerson);
////	        }
////
////	    } else {
////	        // Nothing selected.
////	        Dialogs.create()
////	            .title("No Selection")
////	            .masthead("No Type Selected")
////	            .message("Please select a Type in the table.")
////	            .showWarning();
////	    }
//	}
//	
//	/**
//	 * Called when the user clicks the back button.
//	 */
//	@FXML
//	private void handleBackward() {
//		
//		mainApp.showLevelaOverview();
//	}
//	
//	/**
//	 * Called when the user clicks the forward button.
//	 */
//	@FXML
//	private void handleForward() {
//	    
//		//mainApp.showLevelcOverview();
//	}
//    
//}