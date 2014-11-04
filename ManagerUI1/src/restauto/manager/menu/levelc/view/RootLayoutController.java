
package restauto.manager.menu.levelc.view;


import restauto.manager.menu.levelc.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class RootLayoutController {
    
    
    // Reference to the main application.
    private MainApp mainApp;
    @FXML
    private Menu file;
    @FXML
    private Menu edit;
    @FXML
    private MenuItem returnHome;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public RootLayoutController() {
     
     
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
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
            
       
    }
   public void fadeOut(boolean fadeOut)
   {
       if(fadeOut==true)
       {
           file.setDisable(true);
           edit.setDisable(true);
       }
       else
       {
           file.setDisable(false);
           edit.setDisable(false);
       }
   }
   public void setReturnHome(boolean arg)
   {
       if(arg==true)
           returnHome.setVisible(true);
       else
           returnHome.setVisible(false);
       
   }
   @FXML
   private void handleLogOut() 
   {	    
		mainApp.showManagerLoginOverview();
   }
   @FXML
   private void handleReturnHome()
   {
                mainApp.showHomePageOverview();
   }
   @FXML
   private void handleAbout()
   {
                mainApp.showAboutDialog();
   }
        
    
}
