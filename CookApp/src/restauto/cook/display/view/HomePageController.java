package restauto.cook.display.view;

import restauto.cook.display.Main;
import javafx.fxml.FXML;

public class HomePageController {
    
    // Reference to the main application.
    private Main main;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public HomePageController() {
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
    public void setMainApp(Main main) {
        this.main = main;
    }
    
    /**
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleBar() {
	    
		main.showMainDisplay("Bar");
	}
	
    /**
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleBeverage() {
	    
		main.showMainDisplay("Beverage");
	}
	
    /**
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleGrill() {
	    
		main.showMainDisplay("Grill");
	}
	
    /**
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleOven() {
	    
		main.showMainDisplay("Oven");
	}
	
    /**
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleFryer() {
	    
		main.showMainDisplay("Fryer");
	}
	
    /**
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleFlatTop() {
	    
		main.showMainDisplay("FlatTop");
	}
	
    /**
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleSalad() {
	    
		main.showMainDisplay("Salad");
	}
	
    /**
	 * Called when the user clicks the database button.
	 */
	@FXML
	private void handleExpodite() {
	    
		main.showMainDisplay("Expodite");
	}
	
	/**
	 * Called when the user clicks the reports button.
	 */
	@FXML
	private void handleReports() {

	}		 

}
