package restauto.manager.menu.levelc;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import restauto.manager.database.tools.MySQLDatabase;
import restauto.manager.menu.levelc.model.Employee;
import restauto.manager.menu.levelc.model.LocationGoogle;
//import restauto.manager.database.tools.Populate;
//import restauto.manager.menu.levelc.model.Levelc;
import restauto.manager.menu.levelc.model.Menu_Item;
import restauto.manager.menu.levelc.view.EmployeeEditDialogController;
import restauto.manager.menu.levelc.view.EmployeeOverviewController;
import restauto.manager.menu.levelc.view.HomePageController;
import restauto.manager.menu.levelc.view.LevelaOverviewController;
import restauto.manager.menu.levelc.view.LocationEditDialogController;
import restauto.manager.menu.levelc.view.LocationOverviewController;
import restauto.manager.menu.levelc.view.PieChartReportController;
import restauto.manager.menu.levelc.view.ReportController;
//import restauto.manager.menu.levelc.view.LevelbOverviewController;
//import restauto.manager.menu.levelc.view.LevelcEditDialogController;
import restauto.manager.menu.levelc.view.RootLayoutController;
import restauto.manager.menu.levelc.view.LevelcOverviewController;
import restauto.manager.menu.levelc.view.ManagerLoginController;
import restauto.manager.menu.levelc.view.MenuItemEditDialogController;
import restauto.manager.menu.levelc.view.TypeEditDialogController;
import restauto.manager.menu.levelc.model.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
  //New andrew used to keep track which screens to show and not show menu buttons
    private boolean faded=true; 
    private boolean returnHome=true;
    private boolean editHide=false;
    private boolean editHideLevelC=false;
    private boolean editHideLevelA=false;
    //New used to keep track of type when refreshing level c/ 
    private String idHolder;
    
    /**
     * The data as an observable list of Levelcs.
     */
    //private Populate populator = new Populate();
    private MySQLDatabase database = new MySQLDatabase();
    
    private ObservableList<Type> type = FXCollections.observableArrayList();
    private ObservableList<Menu_Item> menuItem = FXCollections.observableArrayList();
    private ObservableList<LocationGoogle> locationGoogle = FXCollections.observableArrayList();
    private ObservableList<Employee> employee = FXCollections.observableArrayList();
    
    public ObservableList<Menu_Item> clickedMenuItems = FXCollections.observableArrayList();
    

    /**
     * Constructor
     */
    public MainApp() {
    	
    	//getAllTypes();
		//getAllMenuItems();
    }    
    
    private void getAllTypes() {
    	
    	/*** Get All Types From The Database ***/

		ArrayList<LinkedHashMap<String, ArrayList<String>>> table = null;
		
		try {
			table = database.getItems(true, null, "TYPE");
		} catch (SQLException e) {
			System.out.println("\n\nSOMETHING FAILED****\n\n");
		}
		
		//Clear the list so we start fresh
		type.removeAll(type);
		type.clear();
		
		for(LinkedHashMap<String, ArrayList<String>> index1: table)
			type.add(new Type(
						index1.get("TYPE_ID").get(0),
						index1.get("NAME").get(0),
						//index1.get("DESCRIPTION").get(0)) //Null values in database
						" ")
					);
    }
    
    private void getAllMenuItems() {
		
		/*** Get All Menu Items From The Database ***/
    	
		ArrayList<LinkedHashMap<String, ArrayList<String>>> table = null;
		
		try {
			table = database.getItems(true, null, "MENU_ITEM");
		} catch (SQLException e) {
			System.out.println("\n\nSOMETHING FAILED****\n\n");
		}

		//Clear the list so we start fresh
		menuItem.clear();
		
		for(LinkedHashMap<String, ArrayList<String>> index1: table) {
			menuItem.add(new Menu_Item(
						index1.get("ITEM_ID").get(0),
						index1.get("CALORIES").get(0),
						index1.get("ONMENU").get(0),
						index1.get("SPICY").get(0),
						index1.get("RECOMMENDED").get(0),
						index1.get("PRICE").get(0),
						index1.get("NAME").get(0),
						//index1.get("MENU_DESC").get(0), //Null values in database
						" ",
						index1.get("DESCRIPTION").get(0),
						//index1.get("COOKTIME").get(0)) //Null values in database
						" ")
					);
			
//			/*** For Testing The Database ***/
//			print("************************\n");
//			print(index1.get("ITEM_ID").get(0));
//			print(index1.get("CALORIES").get(0));
//			print(index1.get("ONMENU").get(0));
//			print(index1.get("SPICY").get(0));
//			print(index1.get("RECOMMENDED").get(0));
//			print(index1.get("PRICE").get(0));
//			print(index1.get("NAME").get(0));
//			//print(index1.get("MENU_DESC").get(0));
//			print(index1.get("DESCRIPTION").get(0));
//			//print(index1.get("COOKTIME").get(0)));
//			print("************************\n\n");	
		}
    }
    
private void getAllLocations() {
		
		/*** Get All Locations From The Database ***/
    	
		ArrayList<LocationGoogle> table = new ArrayList<LocationGoogle>();
		
		try {
			table = database.locationAttempt();
		} catch (SQLException e) {
			System.out.println("\n\nSOMETHING FAILED****\n\n");
		}

		//Clear the list so we start fresh
				locationGoogle.clear();
				
				locationGoogle.addAll(table);
    }

private void getAllEmployees() {
	
	/*** Get All Employees From The Database ***/
	
	ArrayList<Employee> table = new ArrayList<Employee>();
	
	try {
		table = database.employeeAttempt();
	} catch (SQLException e) {
		System.out.println("\n\nSOMETHING FAILED****\n\n");
	}

	//Clear the list so we start fresh
			employee.clear();
			
			employee.addAll(table);
}

    /**
     * Returns the data as an observable list. 
     * @return
     */
    public ObservableList<Type> getTypeData() {
        return type;
    }
    public ObservableList<Menu_Item> getMenuItems() {
    	
        //return menuItem;
    	return clickedMenuItems;
    }
    
    public ObservableList<LocationGoogle> getLocation() {
	 	getAllLocations();
    	return locationGoogle;
    }
 
 public ObservableList<Employee> getEmployee() {
	 getAllEmployees();
 	return employee;
 }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Manager App");
        
        //Add in an icon
        this.primaryStage.getIcons().add(new Image("file:resources/images/1412737629_food-grey.png"));

        initRootLayout();

        //showLevelcOverview();
        showManagerLoginOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
          //new andrew used to set the view and avaibility of menu buttons
            RootLayoutController controller = loader.getController();                       
            controller.setMainApp(this);
            controller.fadeOut(faded);
            controller.setReturnHome(returnHome);
            controller.hideEdit(editHide);
            controller.hideLevelCItems(editHideLevelC);
            controller.hideLevelAItems(editHideLevelA);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the manager login overview inside the root layout.
     */
    public void showManagerLoginOverview() {
        try {
        	//new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=false;
            returnHome=true;
            faded=true;
            editHideLevelC=false;
            editHideLevelA=false;
            initRootLayout();
        	
            // Load Manager Login overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ManagerLogin.fxml"));
            AnchorPane managerLogin = (AnchorPane) loader.load();

            // Set manager login overview into the center of root layout.
            rootLayout.setCenter(managerLogin);

            // Give the controller access to the main app.
            ManagerLoginController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showManagerLoginInvalidOverview() {
        try {
        	//new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=false;
            returnHome=true;
            faded=true;
            editHideLevelC=false;
            editHideLevelA=false;
            initRootLayout();
        	
            // Load Manager Login overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ManagerLoginInvalid.fxml"));
            AnchorPane managerLogin = (AnchorPane) loader.load();

            // Set manager login overview into the center of root layout.
            rootLayout.setCenter(managerLogin);

            // Give the controller access to the main app.
            ManagerLoginController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the HomePage overview inside the root layout.
     */
    public void showHomePageOverview() {
        try {
        	 //new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=false;
            returnHome=true;
            faded=false;
            editHideLevelC=false;
            editHideLevelA=false;
            initRootLayout();
            // Load Home Page overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/HomePage.fxml"));
            AnchorPane homePageOverview = (AnchorPane) loader.load();

            // Set levela overview into the center of root layout.
            rootLayout.setCenter(homePageOverview);

            // Give the controller access to the main app.
            HomePageController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showHomePageOverview(String userName, String passWord) throws SQLException {
        try {
        	 //new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=false;
            returnHome=true;
            faded=false;
            editHideLevelC=false;
            editHideLevelA=false;
            if(database.loginAttempt(userName, passWord))
            {
            initRootLayout();
            // Load Home Page overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/HomePage.fxml"));
            AnchorPane homePageOverview = (AnchorPane) loader.load();

            // Set levela overview into the center of root layout.
            rootLayout.setCenter(homePageOverview);

            // Give the controller access to the main app.
            HomePageController controller = loader.getController();
            controller.setMainApp(this);
            }
            else
            	showManagerLoginInvalidOverview();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the levela overview inside the root layout.
     */
    public void showLevelaOverview() {
        try {
        	//new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=true;
            returnHome=false;
            faded=false;
            editHideLevelC=false;
            editHideLevelA=true;
            initRootLayout();
        	//Update all the Types
        	getAllTypes();
        	
            // Load First Level overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelaOverview.fxml"));
            AnchorPane levelaOverview = (AnchorPane) loader.load();

            // Set levelb overview into the center of root layout.
            rootLayout.setCenter(levelaOverview);

            // Give the controller access to the main app.
            LevelaOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    //New Andrew used to go backwards from level c without clearing type Observable list
    public void showLevelaOverviewBack() {
        try {
        	//new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=true;
            returnHome=false;
            faded=false;
            editHideLevelC=false;
            editHideLevelA=true;
            initRootLayout();
        	
        	
            // Load First Level overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelaOverview.fxml"));
            AnchorPane levelaOverview = (AnchorPane) loader.load();

            // Set levelb overview into the center of root layout.
            rootLayout.setCenter(levelaOverview);

            // Give the controller access to the main app.
            LevelaOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //new andrew used for when a user clicks a table edit button to refresh the new table.
    public void showLevelaOverview(int[] arr) {
       try {    
                //new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
               editHide=true;
               returnHome=false;
       	faded=false;
               editHideLevelC=false;
               editHideLevelA=true;
       	//Update all the Types
       	//getAllTypes();
       	
           // Load First Level overview.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/LevelaOverview.fxml"));
           AnchorPane levelaOverview = (AnchorPane) loader.load();

           // Set levelb overview into the center of root layout.
           rootLayout.setCenter(levelaOverview);

           // Give the controller access to the main app.
           LevelaOverviewController controller = loader.getController();
           controller.setMainApp(this);          
           controller.setTable(arr);
          
           

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    
//    /**
//     * Shows the levelb overview inside the root layout.
//     */
//    public void showLevelbOverview() {
//        try {
//            // Load Middle Level overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("view/LevelbOverview.fxml"));
//            AnchorPane levelbOverview = (AnchorPane) loader.load();
//
//            // Set levelb overview into the center of root layout.
//            rootLayout.setCenter(levelbOverview);
//
//            // Give the controller access to the main app.
//            LevelbOverviewController controller = loader.getController();
//            controller.setMainApp(this);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Shows the levelc overview inside the root layout.
     */
    //public void showLevelcOverview() {
    public void showLevelcOverview(String clickedID) {
        try {
        	//new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=true;
            returnHome=false;
            faded=false;
            editHideLevelC=true;
            editHideLevelA=false;
            idHolder=clickedID;                
            initRootLayout();
        	//Update all the Menu_Items
        	getAllMenuItems();
        	//Get only the Menu Items under the Type ID
        	clickedMenuItems(clickedID);
        	
            // Load Load Final Level overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelcOverview.fxml"));
            AnchorPane levelcOverview = (AnchorPane) loader.load();

            // Set Levelc overview into the center of root layout.
            rootLayout.setCenter(levelcOverview);

            // Give the controller access to the main app.
            LevelcOverviewController controller = loader.getController();
            //controller.setMainApp(this);
            controller.setMainApp(this, clickedID);
          //new andrew used to show just id and name column when first going to level c
            int[] arr=new int[4];
            arr[0]=1;
            arr[1]=1;
            arr[2]=0;
            arr[3]=0;
            controller.setTable(arr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //new Andre used when user wants to change table view on level c 
    public void showLevelcOverview(String clickedID,int[] arr) {
       try {
                //new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
               editHide=true;
               returnHome=false;
               faded=false;
               editHideLevelC=true;
               editHideLevelA=false;
               
       	//Update all the Menu_Items
       	getAllMenuItems();
       	//Get only the Menu Items under the Type ID
       	clickedMenuItems(clickedID);
       	
           // Load Load Final Level overview.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(MainApp.class.getResource("view/LevelcOverview.fxml"));
           AnchorPane levelcOverview = (AnchorPane) loader.load();

           // Set Levelc overview into the center of root layout.
           rootLayout.setCenter(levelcOverview);

           // Give the controller access to the main app.
           LevelcOverviewController controller = loader.getController();
           //controller.setMainApp(this);
           controller.setMainApp(this, clickedID);
           controller.setTable(arr);

       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    
    /**
     * Shows the location overview inside the root layout.
     */
    public void showLocationPage(String clickedID) {
    	try {
        	//new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=false;
            returnHome=false;
            faded=false;
            editHideLevelC=true;
            editHideLevelA=false;
            idHolder=clickedID;                
            initRootLayout();
        	//Update all the Menu_Items
        	getAllLocations();
        	
            // Load Load Final Level overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LocationOverview.fxml"));
            AnchorPane locationOverview = (AnchorPane) loader.load();

            // Set Levelc overview into the center of root layout.
            rootLayout.setCenter(locationOverview);

            // Give the controller access to the main app.
            LocationOverviewController controller = loader.getController();
            //controller.setMainApp(this);
            controller.setMainApp(this, clickedID);
          //new andrew used to show just id and name column when first going to level c
            int[] arr=new int[4];
            arr[0]=1;
            arr[1]=1;
            arr[2]=0;
            arr[3]=0;
            //controller.setTable(arr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showReportsPage() {
        try {

            // Load Load Final Level overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Reports2.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();

            rootLayout.setCenter(pane);

            // Give the controller access to the main app.
            ReportController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified Menu Item. If the user
     * clicks OK, the changes are saved into the provided Menu Item object and true
     * is returned.
     * 
     * @param Menu Item object to be edited
     * @return true if the user clicked OK, false otherwise.
     */  
    public boolean showMenuItemEditDialog(Menu_Item menuItem) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MenuItemEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Menu Item");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the Menu Item into the controller.
            MenuItemEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMenuItem(menuItem);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showTypeEditDialog(Type menuType) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TypeEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Type Item");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the Menu Item into the controller.
            TypeEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setType(menuType);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showLocationEditDialog(LocationGoogle location) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LocationEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Location Item");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the Menu Item into the controller.
            LocationEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLocation(location);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
  //display about menu dialog box when about button is clicked
    public void showAboutDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AboutDialogBox.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("About us");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

           

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();            
        }
    }
    
    /**
     * Filter through all the menu items
     * and create a new container for
     * just the menu items in the category
     * of the type which was clicked
     * @param clickedID
     */
    public void clickedMenuItems(String clickedID) {
    	
    	
    	clickedMenuItems = FXCollections.observableArrayList();
    	
    	ArrayList<String> matchedTypes = new ArrayList<String>();

		ArrayList<LinkedHashMap<String, ArrayList<String>>> table = null;
		
		/*** Get All Menu Items From The Database ***/
		try {
			table = database.getItems(true, null, "ITEM_TYPE");
		} catch (SQLException e) {
			print("\n\nSOMETHING FAILED****\n\n");
		}
    	
		for(LinkedHashMap<String, ArrayList<String>> index: table)
			if(index.get("TYPE_ID").get(0).equals(clickedID))
				matchedTypes.add(index.get("ITEM_ID").get(0));
		
    	for(Menu_Item index: menuItem)
    		for(String neededID: matchedTypes)
    			if(index.getItemID().equals(neededID))
    				clickedMenuItems.add(index);
    }
    
    // Simple printing solution to help typing
    static void print(String string) {
    	System.out.println("\n\n" + string + "\n\n");
    }
    
  //new Andrew used for passing the current level c type to rootlayoutController
    public String getIDHolder()
    {
        return idHolder;
    }    
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void showEmployeePage(String clickedID) {
    	try {
        	//new andrew used to set the view/avaibility of menu buttons and refresh rootlayout.
            editHide=false;
            returnHome=false;
            faded=false;
            editHideLevelC=true;
            editHideLevelA=false;
            idHolder=clickedID;                
            initRootLayout();
        	//Update all the Menu_Items
        	getAllLocations();
        	
            // Load Load Final Level overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EmployeeOverview.fxml"));
            AnchorPane employeeOverview = (AnchorPane) loader.load();

            // Set Levelc overview into the center of root layout.
            rootLayout.setCenter(employeeOverview);

            // Give the controller access to the main app.
            EmployeeOverviewController controller = loader.getController();
            //controller.setMainApp(this);
            controller.setMainApp(this, clickedID);
          //new andrew used to show just id and name column when first going to level c
            int[] arr=new int[4];
            arr[0]=1;
            arr[1]=1;
            arr[2]=0;
            arr[3]=0;
            //controller.setTable(arr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    public boolean showEmployeeEditDialog(Employee employee) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EmployeeEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Employee Item");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the Menu Item into the controller.
            EmployeeEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLocation(employee);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
