package restauto.cook.display;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import restauto.cook.display.model.Orders;
import restauto.cook.display.model.Sales;
import restauto.cook.display.view.EmployeeLoginController;
import restauto.cook.display.view.HomePageController;
import restauto.cook.display.view.MainDisplayController;
import restauto.cook.display.view.RootLayoutController;
import restauto.cook.database.MySQLDatabase;
import restauto.cook.display.model.Menu_Item;
import restauto.cook.display.model.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    //Andrew used to keep track of which rootlayout buttons to show
    private static boolean fadeOut=true;
    private static boolean returnHome=true;
    private static boolean edit=false;
    private static String overviewName=null;
    //New Andrew
    private static int[] tableColumns=new int[3];

    private MySQLDatabase database = new MySQLDatabase();
    private HashMap<String, ArrayList<Integer>> stationTypes = new HashMap<String, ArrayList<Integer>>();
    
    private ObservableList<Sales> sales = FXCollections.observableArrayList();
    private ObservableList<Orders> orders = FXCollections.observableArrayList();
    
    private ObservableList<Type> type = FXCollections.observableArrayList();
    private ObservableList<Menu_Item> menuItem = FXCollections.observableArrayList();
    public ObservableList<Menu_Item> stationMenuItems = FXCollections.observableArrayList();
       
    /**
     * Constructor
     */
    @SuppressWarnings("serial")
	public Main() {
    	
    	//Subscribe each station to a group of types
    	stationTypes.put("Expodite",
    			new ArrayList<Integer>(){{ add(4); }});
    	
    	stationTypes.put("Salad",
    			new ArrayList<Integer>(){{ add(3); add(11); }});
    	
    	stationTypes.put("FlatTop",
    			new ArrayList<Integer>(){{ add(2); add(5); }});
    	
    	stationTypes.put("Fryer",
    			new ArrayList<Integer>(){{ add(8); }});
    	
    	stationTypes.put("Oven",
    			new ArrayList<Integer>(){{ add(7); add(9); }});
    	
    	stationTypes.put("Grill",
    			new ArrayList<Integer>(){{ add(10); add(6); }});
    	
    	stationTypes.put("Beverage",
    			new ArrayList<Integer>(){{ add(1); }});
    	
    	stationTypes.put("Bar",
    			new ArrayList<Integer>(){{ add(12); }});	
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Employee Display");
        
        //Add in an icon
        this.primaryStage.getIcons().add(new Image("file:resources/images/1412737629_food-grey.png"));

        initRootLayout();
        showEmployeeLoginOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
        	
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);                        
            
            primaryStage.setScene(scene);
            primaryStage.show();
            //Andrew set root layout controller and change buttons
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            controller.fadeOut(fadeOut);
            controller.setReturnHome(returnHome);
            controller.hideEdit(edit);
            //New Andrew
            tableColumns=controller.getTable();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<Orders> getStationOrders() {
    	
    	return orders;
    }
    
    @SuppressWarnings("unused")
	private void getAllSales() {
    	
    	/*** Get All Types From The Database ***/

		ArrayList<LinkedHashMap<String, ArrayList<String>>> table = null;
		
		try {
			table = database.getItems(true, null, "SALE");
		} catch (SQLException e) {
			System.out.println("\n\nGET ALL SALES FAILED****\n\n");
		}
		
		//Clear the list so we start fresh
		sales.removeAll(sales);
		
		for(LinkedHashMap<String, ArrayList<String>> index1: table)
			sales.add(new Sales(
						index1.get("SALE_ID").get(0),
						index1.get("USER_ID").get(0),
						index1.get("TABLE_NUM").get(0),
						index1.get("DATE").get(0),
						index1.get("ARRIVE_TIME").get(0),
						index1.get("SERVE_TIME").get(0),
						index1.get("ifApp").get(0),
						index1.get("ifCarry").get(0))
					);
    }
    
    public void getAllOrders(String station) {
    	
        sales.removeAll(sales);
        orders.removeAll(orders);
        type.removeAll(type);
        menuItem.removeAll(menuItem);
        stationMenuItems.removeAll(stationMenuItems);
    	
    	/*** Get All Orders From The Database ***/
    	
    	ArrayList<LinkedHashMap<String, ArrayList<String>>> table = null;
		
		try {
			table = database.getItems(true, null, "ORDERS");
		} catch (SQLException e) {
			System.out.println("\n\nGET ALL ORDERS FAILED****\n\n");
		}

		for(LinkedHashMap<String, ArrayList<String>> index1: table)
			orders.add(new Orders(
						index1.get("ORDER_ID").get(0),
						index1.get("SALE_ID").get(0),
						index1.get("ITEM_ID").get(0),
						"")
					);
		
		//New**************
		
		//for(Orders index: orders)
		//	getMenuItemsDatabase(index, station);
		
    	//ArrayList<LinkedHashMap<String, ArrayList<String>>> table = null;
    	
		/** Get All Types **/
		
		try {
			table = database.getItems(true, null, "TYPE");
		} catch (SQLException e) {
			System.out.println("\n\nSOMETHING FAILED****\n\n");
		}
    	
		for(LinkedHashMap<String, ArrayList<String>> index1: table)
			type.add(new Type(
						index1.get("TYPE_ID").get(0),
						index1.get("NAME").get(0),
						" ")
					);
		
		/** Get All Menu Items **/
		
		for(Orders index: orders) {
		
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(Integer.parseInt(index.getItemID()));
		
			try {
				table = database.getItems(false, temp, "MENU_ITEM");
			} catch (SQLException e) {
				System.out.println("\n\nGET ALL ORDERS FAILED****\n\n");
			}
		
			for(LinkedHashMap<String, ArrayList<String>> index1: table)
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
					" ",
					index.getSaleID(),
					index.getOrderID(),
					index.getRequest(),
					index.getItemID())
				);
		}
		
		/** Sort **/
		
		ArrayList<Integer> typeID = stationTypes.get(station);
		
    	ArrayList<String> matchedTypes = new ArrayList<String>();
		
		/*** Get All Menu Items From The Database ***/
		try {
			table = database.getItems(true, null, "ITEM_TYPE");
		} catch (SQLException e) {
			print("\n\nSOMETHING FAILED****\n\n");
		}
    	
		for(LinkedHashMap<String, ArrayList<String>> index: table)
			for(Integer index1: typeID)
				if(index.get("TYPE_ID").get(0).equals(Integer.toString(index1)))
					matchedTypes.add(index.get("ITEM_ID").get(0));
		
    	for(Menu_Item index: menuItem)
    		for(String neededID: matchedTypes)
    			if(index.getItemID().equals(neededID))
    				stationMenuItems.add(index);
		
		//New**************
		
//		//Test getting certain menu items
//		ArrayList<Integer> orderedMenuItems = new ArrayList<Integer>();
//		
//		for(Orders index: orders) {
//			
////			print("\n");
////			print("Item ID " + index.getItemID());
////			print("Order ID " + index.getOrderID());
////			print("Sale ID " + index.getSaleID() + "\n");
//			
//			orderedMenuItems.add(Integer.parseInt(index.getItemID()));
//		}
//		
//		for(Integer index: orderedMenuItems)
//			print("\n" + index + "\n");
//		
//		/** Get All Types **/
//		
//		try {
//			table = database.getItems(true, null, "TYPE");
//		} catch (SQLException e) {
//			System.out.println("\n\nSOMETHING FAILED****\n\n");
//		}
//		
//		for(LinkedHashMap<String, ArrayList<String>> index1: table)
//			type.add(new Type(
//						index1.get("TYPE_ID").get(0),
//						index1.get("NAME").get(0),
//						" ")
//					);
//		
//		/** Get All Menu Items **/
//		
//		try {
//			table = database.getItems(false, orderedMenuItems, "MENU_ITEM");
//		} catch (SQLException e) {
//			System.out.println("\n\nGET ALL ORDERS FAILED****\n\n");
//		}
//		
//		for(LinkedHashMap<String, ArrayList<String>> index1: table)
//			menuItem.add(new Menu_Item(
//					index1.get("ITEM_ID").get(0),
//					index1.get("CALORIES").get(0),
//					index1.get("ONMENU").get(0),
//					index1.get("SPICY").get(0),
//					index1.get("RECOMMENDED").get(0),
//					index1.get("PRICE").get(0),
//					index1.get("NAME").get(0),
//					//index1.get("MENU_DESC").get(0), //Null values in database
//					" ",
//					index1.get("DESCRIPTION").get(0),
//					//index1.get("COOKTIME").get(0)) //Null values in database
//					" ")
//				);
//		
//		
//		/** Sort **/
//		
//		ArrayList<Integer> typeID = stationTypes.get(station);
//		
//    	ArrayList<String> matchedTypes = new ArrayList<String>();
//		
//		/*** Get All Menu Items From The Database ***/
//		try {
//			table = database.getItems(true, null, "ITEM_TYPE");
//		} catch (SQLException e) {
//			print("\n\nSOMETHING FAILED****\n\n");
//		}
//    	
//		for(LinkedHashMap<String, ArrayList<String>> index: table)
//			for(Integer index1: typeID)
//				if(index.get("TYPE_ID").get(0).equals(Integer.toString(index1)))
//					matchedTypes.add(index.get("ITEM_ID").get(0));
//		
//    	for(Menu_Item index: menuItem)
//    		for(String neededID: matchedTypes)
//    			if(index.getItemID().equals(neededID))
//    				stationMenuItems.add(index);
//		
////    	for(Menu_Item index: stationMenuItems) {
////    		print("\nHere");
////    		print(index.getName());
////    		print(index.getTableNumber());
////    		print(index.getOrderTime());
////    		print("\n");
////    	}
		
    }
    
    private void getMenuItemsDatabase(Orders orderedMenuItem, String station) {
    	
    	ArrayList<LinkedHashMap<String, ArrayList<String>>> table = null;
    	
		/** Get All Types **/
		
		try {
			table = database.getItems(true, null, "TYPE");
		} catch (SQLException e) {
			System.out.println("\n\nSOMETHING FAILED****\n\n");
		}
    	
		for(LinkedHashMap<String, ArrayList<String>> index1: table)
			type.add(new Type(
						index1.get("TYPE_ID").get(0),
						index1.get("NAME").get(0),
						" ")
					);
		
		/** Get All Menu Items **/
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(Integer.parseInt(orderedMenuItem.getItemID()));
		
		try {
			table = database.getItems(false, temp, "MENU_ITEM");
		} catch (SQLException e) {
			System.out.println("\n\nGET ALL ORDERS FAILED****\n\n");
		}
		
		for(LinkedHashMap<String, ArrayList<String>> index1: table)
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
					" ",
					orderedMenuItem.getSaleID(),
					orderedMenuItem.getOrderID(),
					orderedMenuItem.getRequest(),
					orderedMenuItem.getItemID())
				);
		
		/** Sort **/
		
		ArrayList<Integer> typeID = stationTypes.get(station);
		
    	ArrayList<String> matchedTypes = new ArrayList<String>();
		
		/*** Get All Menu Items From The Database ***/
		try {
			table = database.getItems(true, null, "ITEM_TYPE");
		} catch (SQLException e) {
			print("\n\nSOMETHING FAILED****\n\n");
		}
    	
		for(LinkedHashMap<String, ArrayList<String>> index: table)
			for(Integer index1: typeID)
				if(index.get("TYPE_ID").get(0).equals(Integer.toString(index1)))
					matchedTypes.add(index.get("ITEM_ID").get(0));
		
    	for(Menu_Item index: menuItem)
    		for(String neededID: matchedTypes)
    			if(index.getItemID().equals(neededID))
    				stationMenuItems.add(index);
    }
    
    public ObservableList<Menu_Item> getStationMenuItems() {
    	return stationMenuItems;
    }
    
    public void completeMenuItem(Menu_Item item, String station) {
    	
    	stationMenuItems.remove(item);
    	
    	try {
    		
    		ArrayList<Integer> idNumber = new ArrayList<Integer>();
    		idNumber.add(Integer.parseInt(item.getOrderID()));
    		ArrayList<LinkedHashMap<String, ArrayList<String>>> test = database.getItems(idNumber, "ORDERS", "ORDER_ID");
    		
    		for(LinkedHashMap<String, ArrayList<String>> indexA: test) {
    			
//    			Set<String> keys = indexA.keySet();
//    			for(String indexB: keys) {
//    				
//    				System.out.println("\nKey:  " + indexB + "\n\n");
//    				for(String indexC: indexA.get(indexB)) {
//    					
//    					System.out.println("\nData:  " + indexC + "\n");
//    				}
//    			}
    			
    			database.insertItem(indexA, "ORDERS_ARCHIVE");
    		}
    		
    		
			database.deleteItem("ORDERS", Integer.parseInt(item.getOrderID()), "ORDER_ID");
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	//Refresh Orders
    	getAllOrders(station);
    }
    
    /**
     * Shows the employee login overview inside the root layout.
     */
    public void showEmployeeLoginOverview() {
        try {
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=true;
        	returnHome=true;
        	edit=false;
        	initRootLayout();
            // Load Manager Login overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EmployeeLogin.fxml"));
            AnchorPane managerLogin = (AnchorPane) loader.load();

            // Set manager login overview into the center of root layout.
            rootLayout.setCenter(managerLogin);

            // Give the controller access to the main app.
            EmployeeLoginController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showEmployeeLoginInvalidOverview() {
        try {
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=true;
        	returnHome=true;
        	edit=false;
        	initRootLayout();
            // Load Manager Login overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EmployeeLoginInvalid.fxml"));
            AnchorPane managerLogin = (AnchorPane) loader.load();

            // Set manager login overview into the center of root layout.
            rootLayout.setCenter(managerLogin);

            // Give the controller access to the main app.
            EmployeeLoginController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showHomePageOverview() {
        try {
        	
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=false;
        	returnHome=true;
        	edit=false;
        	
        	initRootLayout();
            // Load Home Page overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/HomePage.fxml"));
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
     * Shows the HomePage overview inside the root layout.
     * @throws SQLException 
     */
    public void showHomePageOverview(String userName, String passWord) throws SQLException {
        try {
        	
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=false;
        	returnHome=true;
        	edit=false;
        	if(database.loginAttempt(userName, passWord))
        	{
        	initRootLayout();
            // Load Home Page overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/HomePage.fxml"));
            AnchorPane homePageOverview = (AnchorPane) loader.load();

            // Set levela overview into the center of root layout.
            rootLayout.setCenter(homePageOverview);

            // Give the controller access to the main app.
            HomePageController controller = loader.getController();
            controller.setMainApp(this);
        	}
        	else
        		showEmployeeLoginInvalidOverview();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the Main Display overview inside the root layout.
     */
    public void showMainDisplay(String display) {
        try {
        	
        	//Populate the orders list
        	getAllOrders(display);
        	
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=false;
        	returnHome=false;
        	edit=true;
        	overviewName=display;
        	initRootLayout();
            // Load Main Display overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainDisplay2.fxml"));
            AnchorPane homePageOverview = (AnchorPane) loader.load();

            // Set Main Display overview into the center of root layout.
            rootLayout.setCenter(homePageOverview);

            // Give the controller access to the main app.
            MainDisplayController controller = loader.getController();
            controller.setMainApp(this, display);
            controller.getItemCount();
            controller.setImages(display);            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Andrew used for updating mainDisplay without updating rootlayout
    public void showMainDisplay(String display, int[] arr) {
        try {
        	
        	//Andrew handle setting buttons for this particular scene
        	fadeOut=false;
        	returnHome=false;
        	edit=true;        	
            // Load Main Display overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainDisplay2.fxml"));
            AnchorPane homePageOverview = (AnchorPane) loader.load();

            // Set Main Display overview into the center of root layout.
            rootLayout.setCenter(homePageOverview);

            // Give the controller access to the main app.
            MainDisplayController controller = loader.getController();
            controller.setMainApp(this, display);
            controller.setTable(arr);
            controller.getItemCount();
            controller.setImages(display);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  //Andrew display about menu dialog box when about button is clicked
    public void showAboutDialog() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/AboutDialogBox.fxml"));
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
    
    private LinkedHashMap<String,BufferedImage> getCookPics(String typeID) throws SQLException, IOException
    {
    	return database.getCookPictures(typeID);
    }
    public LinkedHashMap<String,BufferedImage> cookAppPictures(String typeID) throws IOException
    {
    	LinkedHashMap<String,BufferedImage> pics=new LinkedHashMap<String,BufferedImage>();
    	try {
			pics= getCookPics(typeID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return pics;
    }
    
    // Simple printing solution to help typing
    static void print(String string) {
    	System.out.println(string);
    }
    public String getOverviewName()
    {
    	return overviewName;
    }
    //New Andrew
    public int[] getTable()
    {
    	return tableColumns;
    }
    public void setTable(int[] arg)
    {
    	tableColumns=arg;
    }
    //End New
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
    
}
