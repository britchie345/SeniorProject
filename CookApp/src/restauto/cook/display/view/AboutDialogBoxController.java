package restauto.cook.display.view;

import restauto.cook.display.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;

public class AboutDialogBoxController {

	 // Reference to the main application.
    private Main main;
	
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public AboutDialogBoxController() {
     
     
    }
    
       /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {   
        
    }
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main main) {
        this.main = main;
            
       
    }
	
}
