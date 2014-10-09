package restauto.manager.menu.levelc.view;

import restauto.manager.menu.levelc.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ManagerLoginController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ManagerLoginController() {
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
	 * Called when the user clicks the login button.
	 */
	@FXML
	private void handleLogin() {
	    
		mainApp.showLevelaOverview();
		System.out.println("Login Clicked");
	}
    
	
}



























