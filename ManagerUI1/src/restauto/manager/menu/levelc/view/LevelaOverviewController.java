package restauto.manager.menu.levelc.view;

import restauto.manager.menu.levelc.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LevelaOverviewController {
    
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
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleDatabase() {
	    
		mainApp.showLevelbOverview();
		System.out.println("Database Clicked");
	}
	
	/**
	 * Called when the user clicks the reports button.
	 */
	@FXML
	private void handleReports() {
	    
		System.out.println("Reports Clicked");
	}

}
