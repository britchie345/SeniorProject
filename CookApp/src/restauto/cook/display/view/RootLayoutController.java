package restauto.cook.display.view;

import restauto.cook.display.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;

public class RootLayoutController {
	
	private Main main;
    @FXML
    private Menu file;
    @FXML
    private Menu edit;
    @FXML
    private MenuItem returnHome;
    @FXML
    private MenuItem logOut;
    @FXML
    private CheckMenuItem name;
    @FXML
    private CheckMenuItem table;
    @FXML
    private CheckMenuItem time;
    String pos;
    
    
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
    public void setMainApp(Main main) {
        this.main = main;
            
       
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
    //New Andrew
    public int[] getTable()
    {
    	int[] arr=new int[3];
	       if(name.isSelected())
	           arr[0]=1;
	       else
	           arr[0]=0;
	       if(table.isSelected())
	           arr[1]=1;
	       else
	           arr[1]=0;
	       if(time.isSelected())
	           arr[2]=1;
	       else
	           arr[2]=0;
	       
	       return arr;
    }
    //End New
    @FXML
    private void handleLogOut() 
    {	    
 		main.showEmployeeLoginOverview();
    }
    @FXML
    private void handleReturnHome()
    {
        main.showHomePageOverview();
    }
    @FXML
    private void handleAbout()
    {
        main.showAboutDialog();
    }
    
    @FXML 
	   public void handleChangeViewType()
	   {
	       int[] arr=new int[3];
	       if(name.isSelected())
	           arr[0]=1;
	       else
	           arr[0]=0;
	       if(table.isSelected())
	           arr[1]=1;
	       else
	           arr[1]=0;
	       if(time.isSelected())
	           arr[2]=1;
	       else
	           arr[2]=0;
	       
	       main.setTable(arr);
	       main.showMainDisplay(main.getOverviewName(), arr);
	   }
    

}
