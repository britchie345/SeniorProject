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
import restauto.manager.database.tools.Populate;
import restauto.manager.menu.levelc.model.Levelc;
import restauto.manager.menu.levelc.model.Menu_Item;
import restauto.manager.menu.levelc.view.HomePageController;
import restauto.manager.menu.levelc.view.LevelaOverviewController;
import restauto.manager.menu.levelc.view.LevelbOverviewController;
import restauto.manager.menu.levelc.view.LevelcEditDialogController;
import restauto.manager.menu.levelc.view.LevelcOverviewController;
import restauto.manager.menu.levelc.view.ManagerLoginController;
import restauto.manager.menu.levelc.view.MenuItemEditDialogController;
import restauto.manager.menu.levelc.model.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Levelcs.
     */
    private ObservableList<Levelc> levelcData = FXCollections.observableArrayList();
    //private Populate populator = new Populate();
    private MySQLDatabase database = new MySQLDatabase();
    
    private ObservableList<Type> type = FXCollections.observableArrayList();
    private ObservableList<Menu_Item> menuItem = FXCollections.observableArrayList();
    
    private ObservableList<Menu_Item> clickedMenuItems = FXCollections.observableArrayList();
    

    /**
     * Constructor
     */
    public MainApp() {
    	
    	//type = populator.getType("TYPE");
		ArrayList<LinkedHashMap<String, ArrayList<String>>> table = null;
    	
    	/*** Get All Types From The Database ***/
		try {
			table = database.getItems(true, null, "TYPE");
		} catch (SQLException e) {
			System.out.println("\n\nSOMETHING FAILED****\n\n");
		}
		
		for(LinkedHashMap<String, ArrayList<String>> index1: table)
			type.add(new Type(
						index1.get("TYPE_ID").get(0),
						index1.get("NAME").get(0),
						//index1.get("DESCRIPTION").get(0))
						" ")
					);
		
		/*** Get All Menu Items From The Database ***/
		try {
			table = database.getItems(true, null, "MENU_ITEM");
		} catch (SQLException e) {
			System.out.println("\n\nSOMETHING FAILED****\n\n");
		}		
		
		for(LinkedHashMap<String, ArrayList<String>> index1: table) {
			menuItem.add(new Menu_Item(
						index1.get("ITEM_ID").get(0),
						index1.get("CALORIES").get(0),
						index1.get("ONMENU").get(0),
						index1.get("SPICY").get(0),
						index1.get("RECOMMENDED").get(0),
						index1.get("PRICE").get(0),
						index1.get("NAME").get(0),
						//index1.get("MENU_DESC").get(0),
						" ",
						index1.get("DESCRIPTION").get(0),
						//index1.get("COOKTIME").get(0))
						" ")
					);
			
			/*** For Testing The Database ***/
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
    	
        // Add some sample data
        levelcData.add(new Levelc("344", "Burger"));
        levelcData.add(new Levelc("345", "Filet Mignonet"));
        levelcData.add(new Levelc("346", "Strip Steak"));
        levelcData.add(new Levelc("347", "Prime Rib"));
        levelcData.add(new Levelc("348", "Beef Tips"));
        levelcData.add(new Levelc("349", "Steak Sandwich"));
        levelcData.add(new Levelc("350", "Turkey Burger"));
        levelcData.add(new Levelc("351", "Turkey Legs"));
        levelcData.add(new Levelc("352", "Ham"));
    }

    /**
     * Returns the data as an observable list. 
     * @return
     */
    public ObservableList<Levelc> getLevelcData() {
        return levelcData;
    }
    public ObservableList<Type> getTypeData() {
        return type;
    }
    public ObservableList<Menu_Item> getMenuItems() {
    	
        //return menuItem;
    	return clickedMenuItems;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Manager App");
        
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
            // Load person overview.
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
    
    /**
     * Shows the HomePage overview inside the root layout.
     */
    public void showHomePageOverview() {
        try {
            // Load person overview.
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
    
    /**
     * Shows the levela overview inside the root layout.
     */
    public void showLevelaOverview() {
        try {
            // Load person overview.
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
    
    /**
     * Shows the levelb overview inside the root layout.
     */
    public void showLevelbOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelbOverview.fxml"));
            AnchorPane levelbOverview = (AnchorPane) loader.load();

            // Set levelb overview into the center of root layout.
            rootLayout.setCenter(levelbOverview);

            // Give the controller access to the main app.
            LevelbOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the levelc overview inside the root layout.
     */
    //public void showLevelcOverview() {
    public void showLevelcOverview(String clickedID) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelcOverview.fxml"));
            AnchorPane levelcOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(levelcOverview);

            // Give the controller access to the main app.
            LevelcOverviewController controller = loader.getController();
            //controller.setMainApp(this);
            controller.setMainApp(this, clickedID);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonEditDialog(Levelc person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LevelcEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Levelc");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            LevelcEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
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
    
    static void print(String string) {
    	System.out.println("\n\n" + string + "\n\n");
    }
    
}
