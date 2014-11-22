package restauto.cook.display.view;


import restauto.cook.display.Main;
import restauto.cook.display.model.Menu_Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

//@SuppressWarnings("deprecation")
public class MainDisplayController {
    @FXML
    private TableView<Menu_Item> menuItemTable;
    @FXML   
    private TableColumn<Menu_Item, String> nameColumn;
    @FXML  
    private TableColumn<Menu_Item, String> tableColumn;
    @FXML 
    private TableColumn<Menu_Item, String> timeColumn;  
    
    @FXML
    private Button completeButton;
    @FXML
    private Button backButton;
    @FXML
    private Button refreshButton;
    
    // Reference to the main application.
    private Main mainApp;
    
    //Selected Menu Item
    private Menu_Item clickedMenuItem = null;
    
    //Station name
    private String station = "";

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
    	
        //Initialize the Menu Item table with the two columns.
        nameColumn.setCellValueFactory(
               cellData -> cellData.getValue().getNameProperty());
        tableColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTableNumberProperty());
        timeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getOrderTimeProperty());

        // Listen for selection changes and show the Menu Item details when changed.
        menuItemTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> menuItemClickedListner(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp, String station) {
    	
    	//Save reference to main app
        this.mainApp = mainApp;
        
        //Station name
        this.station = station;

        // Add observable list data to the table
        menuItemTable.setItems(mainApp.getStationMenuItems());
    }
    
    /**
     * Fills all text fields to show details about the Menu Item.
     * If the specified Menu Item is null, all text fields are cleared.
     * 
     * @param The Menu Item or null
     */
    private void menuItemClickedListner(Menu_Item clickedMenuItem) {

    	this.clickedMenuItem = clickedMenuItem;
    }

    //Andrew handle displays of Columns
    public void setTable(int[] arg)
    {
        if(arg[0]==1)
            nameColumn.setVisible(true);
        else
            nameColumn.setVisible(false);
        
         if(arg[1]==1)
            tableColumn.setVisible(true);
        else
            tableColumn.setVisible(false);
         
         if(arg[2]==1)
             timeColumn.setVisible(true);
         else
             timeColumn.setVisible(false);
    }
    
    /**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleComplete() {
		
		if(clickedMenuItem != null)
			mainApp.completeMenuItem(clickedMenuItem);
	}
	
    /**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleRefresh() {
		
		mainApp.getAllOrders(station);
	}
	
	/**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleBackward() {
		
		//mainApp.showLevelbOverview();
		mainApp.showHomePageOverview();
	}
		
 
}