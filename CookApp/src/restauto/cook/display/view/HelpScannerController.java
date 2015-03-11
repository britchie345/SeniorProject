package restauto.cook.display.view;

import javafx.util.Duration;
import restauto.cook.display.Main;
import restauto.cook.display.model.HelpTable;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class HelpScannerController {

	 	@FXML
	    private TableView<HelpTable> menuItemTable;
	    @FXML   
	    private TableColumn<HelpTable, String> nameColumn;
	    @FXML  
	    private TableColumn<HelpTable, String> tableColumn;
	    @FXML 
	    private TableColumn<HelpTable, String> timeColumn;
	    @FXML
	    private Button completeButton;
	    
	    // Reference to the main application.
	    private Main mainApp;
	    
	    //Selected Menu Item
	    private HelpTable clickedHelpTable = null;
	    Timeline timeline;
	
	
	public HelpScannerController() {
    	//getItemCount();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     * @throws InterruptedException 
     */
    @FXML
    private void initialize() {
    	
        //Initialize the Menu Item table with the two columns.
        nameColumn.setCellValueFactory(
               cellData -> cellData.getValue().getCustIDProperty());
        tableColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTableIDProperty());
        timeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTimeProperty());
       
        menuItemTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> menuItemClickedListner(newValue));

        
     
        
         timeline = new Timeline(new KeyFrame(
                Duration.millis(2500),
                ae -> upDate()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
    }
public void setMainApp(Main mainApp, String station) {
    	
    	//Save reference to main app
        this.mainApp = mainApp;
        
        this.mainApp.clearHelp();
        menuItemTable.setItems(mainApp.getHelpRequest());
        menuItemTable.getSelectionModel().selectFirst();
        
        
        
    }
    
    /**
     * Fills all text fields to show details about the Menu Item.
     * If the specified Menu Item is null, all text fields are cleared.
     * 
     * @param The Menu Item or null
     */
    private void menuItemClickedListner(HelpTable clickedMenuItem) {

    	this.clickedHelpTable = clickedMenuItem;
    }
    public void upDate()
    {
    	mainApp.clearHelp();
    	mainApp.setHelpRequest();
    	menuItemTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> menuItemClickedListner(newValue));
    	menuItemTable.getSelectionModel().selectFirst();
    	
    	
    }
    public Timeline getTimeLine()
    {
    	return timeline;
    }
    
    @FXML
    public void handleComplete()
    {
    	mainApp.deleteHelp(clickedHelpTable);
    }
    
}
