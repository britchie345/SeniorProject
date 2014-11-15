
package restauto.manager.menu.levelc.view;


import restauto.manager.menu.levelc.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;

public class RootLayoutController {
    
    
    // Reference to the main application.
    private MainApp mainApp;
    @FXML
    private Menu file;
    @FXML
    private Menu edit;
    @FXML
    private MenuItem returnHome;
    @FXML
    private CheckMenuItem id;
    @FXML
    private CheckMenuItem type;
    @FXML
    private CheckMenuItem id2;
    @FXML
    private CheckMenuItem type2;
    @FXML
    private CheckMenuItem price;
    @FXML
    private CheckMenuItem calories;
    
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
           returnHome.setVisible(false);
       else
           returnHome.setVisible(true);
       
   }
   public void hideEdit(boolean arg)
   {
       edit.setVisible(arg);
   }
   public void hideLevelCItems(boolean arg)
   {
       id2.setVisible(arg);
       type2.setVisible(arg);
       price.setVisible(arg);
       calories.setVisible(arg);     
             
   }
    public void hideLevelAItems(boolean arg)
   {
       id.setVisible(arg);
       type.setVisible(arg);     
   
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
   @FXML 
   public void handleChangeViewType()
   {
       int[] arr=new int[2];
       if(id.isSelected())
           arr[0]=1;
       else
           arr[0]=0;
       if(type.isSelected())
           arr[1]=1;
       else
           arr[1]=0;
       
       mainApp.showLevelaOverview(arr);
   }
   @FXML 
   public void handleChangeViewItem()
   {
       int[] arr=new int[4];
       if(id2.isSelected())
           arr[0]=1;
       else
           arr[0]=0;
       if(type2.isSelected())
           arr[1]=1;
       else
           arr[1]=0;
       if(price.isSelected())
           arr[2]=1;
       else
           arr[2]=0;
       if(calories.isSelected())
           arr[3]=1;
       else
           arr[3]=0;
       
       mainApp.showLevelcOverview(mainApp.getIDHolder(), arr);
   }
    
}

