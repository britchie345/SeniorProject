package restauto.cook.display.view;


import java.io.File;
import java.util.LinkedHashMap;
import java.util.Set;

import restauto.cook.display.Main;
import restauto.cook.display.model.Menu_Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

//@SuppressWarnings("deprecation")
public class MainDisplayController {
    @FXML
    private TableView<Menu_Item> menuItemTable;
    @FXML   
    private TableColumn<Menu_Item, String> nameColumn;
    @FXML  
    private TableColumn<Menu_Item, String> tableColumn;
    @FXML 
    private TableColumn<Menu_Item, String> timeColumn;  
    
    @FXML
    private Button completeButton;
    @FXML
    private Button backButton;
    @FXML
    private Button refreshButton;
    @FXML
   	private FlowPane flow;
    
    // Reference to the main application.
    private Main mainApp;
    
    //Selected Menu Item
    private Menu_Item clickedMenuItem = null;
    
    //Station name
    private String station = "";
    
    
    
    
    
    
    LinkedHashMap<String,Integer> itemCount=new  LinkedHashMap<String,Integer>();
   
    
    
    
    
    
    
    
    
    
    
    

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MainDisplayController() {
    	//getItemCount();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
        //Initialize the Menu Item table with the two columns.
        nameColumn.setCellValueFactory(
               cellData -> cellData.getValue().getNameProperty());
        tableColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTableNumberProperty());
        timeColumn.setCellValueFactory(
                cellData -> cellData.getValue().getOrderTimeProperty());

        // Listen for selection changes and show the Menu Item details when changed.
        menuItemTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> menuItemClickedListner(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp, String station) {
    	
    	//Save reference to main app
        this.mainApp = mainApp;
        
        //Station name
        this.station = station;

        // Add observable list data to the table
        menuItemTable.setItems(mainApp.getStationMenuItems());
    }
    
    /**
     * Fills all text fields to show details about the Menu Item.
     * If the specified Menu Item is null, all text fields are cleared.
     * 
     * @param The Menu Item or null
     */
    private void menuItemClickedListner(Menu_Item clickedMenuItem) {

    	this.clickedMenuItem = clickedMenuItem;
    }

    //Andrew handle displays of Columns
    public void setTable(int[] arg)
    {
        if(arg[0]==1)
            nameColumn.setVisible(true);
        else
            nameColumn.setVisible(false);
        
         if(arg[1]==1)
            tableColumn.setVisible(true);
        else
            tableColumn.setVisible(false);
         
         if(arg[2]==1)
             timeColumn.setVisible(true);
         else
             timeColumn.setVisible(false);
    }
    
    public void setImages(String display)
    {
    	
    	
    	if(display=="Bar")
    	{    		   	 
    		File file[] = new File[5];
    		file[0]=new File("/Users/Andrew/workspace/CookApp/src/images/strawberryBar.png");
    		file[1]=new File("/Users/Andrew/workspace/CookApp/src/images/cosmo.png");
    		file[2]=new File("/Users/Andrew/workspace/CookApp/src/images/white.png");
    		file[3]=new File("/Users/Andrew/workspace/CookApp/src/images/longIsland.png");
    		file[4]=new File("/Users/Andrew/workspace/CookApp/src/images/rum+coke.jpg");
    		
    		
    		String imgName[] = new String[5];
    		imgName[0]="SB Margarita";
    		imgName[1]="Cosmopolitan";
    		imgName[2]="White Sangria";
    		imgName[3]="Long island";
    		imgName[4]="Rum and coke";
    		
    		
    		for(int i=0;i<5;i++)
    			 imgName[i] = String.format(imgName[i],"%12s").replace(' ', ' ');
    	
    		Image image[]=new Image[5];
    		for(int i=0;i<5;i++)
   	  	  		image[i]=new Image(file[i].toURI().toString());
   	    
   	      
    		ImageView[] imgview =new ImageView[5];
    		for(int i=0;i<5;i++)
    			imgview[i]=new ImageView(image[i]);
   	   
    		Label[] imgLabel = new Label[5];
    		for(int i=0;i<5;i++)
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
   	   
    		for(int i=0;i<5;i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(140, 40);
		
    			flow.setHgap(50);
    			flow.setVgap(50);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    	if(display=="Beverage")
    	{
    		File file[] = new File[11];
    		file[0]=new File("/Users/Andrew/workspace/CookApp/src/images/cokecola.png");
    		file[1]=new File("/Users/Andrew/workspace/CookApp/src/images/DietCoke.png");
    		file[2]=new File("/Users/Andrew/workspace/CookApp/src/images/sprite.jpg");
    		file[3]=new File("/Users/Andrew/workspace/CookApp/src/images/drpepper.jpg");
    		file[4]=new File("/Users/Andrew/workspace/CookApp/src/images/rootbeer.jpg");
    		file[5]=new File("/Users/Andrew/workspace/CookApp/src/images/orangesoda.jpg");
    		file[6]=new File("/Users/Andrew/workspace/CookApp/src/images/cherrycoke.jpg");
    		file[7]=new File("/Users/Andrew/workspace/CookApp/src/images/lemonade.jpg");
    		file[8]=new File("/Users/Andrew/workspace/CookApp/src/images/strawberry.jpg");
    		file[9]=new File("/Users/Andrew/workspace/CookApp/src/images/sweetTea.jpg");
    		file[10]=new File("/Users/Andrew/workspace/CookApp/src/images/unsweet.jpg");
    		
    		String imgName[] = new String[11];
    		imgName[0]="Coke-Cola";
    		imgName[1]="Diet-Coke";
    		imgName[2]="Sprite";
    		imgName[3]="Dr.Pepper";
    		imgName[4]="Root Beer";
    		imgName[5]="Orange Soda";
    		imgName[6]="Cherry-Coke";
    		imgName[7]="Lemonade";
    		imgName[8]="Strawberry";
    		imgName[9]="Sweet Tea";
    		imgName[10]="Unsweet Tea";
    		
    		for(int i=0;i<11;i++)
    			 imgName[i] = String.format(imgName[i],"%12s").replace(' ', ' ');
    	
    		Image image[]=new Image[11];
    		for(int i=0;i<11;i++)
   	  	  		image[i]=new Image(file[i].toURI().toString());
   	    
   	      
    		ImageView[] imgview =new ImageView[11];
    		for(int i=0;i<11;i++)
    			imgview[i]=new ImageView(image[i]);
   	   
    		Label[] imgLabel = new Label[11];
    		for(int i=0;i<11;i++)
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
   	   
    		for(int i=0;i<11;i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(140, 40);
		
    			flow.setHgap(50);
    			flow.setVgap(50);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    	if(display=="Grill")
    	{
    		File file[] = new File[4];
    		file[0]=new File("/Users/Andrew/workspace/CookApp/src/images/chedderBurger.jpg");
    		file[1]=new File("/Users/Andrew/workspace/CookApp/src/images/veggieBurger.jpg");
    		file[2]=new File("/Users/Andrew/workspace/CookApp/src/images/filet.jpg");
    		file[3]=new File("/Users/Andrew/workspace/CookApp/src/images/parmSteak.jpg");
    		
    		
    		
    		String imgName[] = new String[4];
    		imgName[0]="Ched Burger";
    		imgName[1]="Veg Burger";
    		imgName[2]="Filet mignon";
    		imgName[3]="Parm Filet";
    		
    		
    		
    		for(int i=0;i<4;i++)
    			 imgName[i] = String.format(imgName[i],"%12s").replace(' ', ' ');
    	
    		Image image[]=new Image[4];
    		for(int i=0;i<4;i++)
   	  	  		image[i]=new Image(file[i].toURI().toString());
   	    
   	      
    		ImageView[] imgview =new ImageView[4];
    		for(int i=0;i<4;i++)
    			imgview[i]=new ImageView(image[i]);
   	   
    		Label[] imgLabel = new Label[4];
    		for(int i=0;i<4;i++)
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
   	   
    		for(int i=0;i<4;i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(140, 40);
		
    			flow.setHgap(50);
    			flow.setVgap(50);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    	if(display=="Oven")
    	{
    		File file[] = new File[6];
    		file[0]=new File("/Users/Andrew/workspace/CookApp/src/images/chickenAlfedo.png");
    		file[1]=new File("/Users/Andrew/workspace/CookApp/src/images/garlicChicken.png");
    		file[2]=new File("/Users/Andrew/workspace/CookApp/src/images/macNcheese.jpg");
    		file[3]=new File("/Users/Andrew/workspace/CookApp/src/images/rattlesnake.png");
    		file[4]=new File("/Users/Andrew/workspace/CookApp/src/images/shrimp.png");
    		file[5]=new File("/Users/Andrew/workspace/CookApp/src/images/stuffedChicken.jpg");
    		
    		
    		String imgName[] = new String[6];
    		imgName[0]="Chicken Alf";
    		imgName[1]="Garlic Chic";
    		imgName[2]="Mac N Cheese";
    		imgName[3]="Rattlesnake";
    		imgName[4]="Shimp Scampi";
    		imgName[5]="Stuffed Chic";
    		
    		
    		for(int i=0;i<6;i++)
    			 imgName[i] = String.format(imgName[i],"%12s").replace(' ', ' ');
    	
    		Image image[]=new Image[6];
    		for(int i=0;i<6;i++)
   	  	  		image[i]=new Image(file[i].toURI().toString());
   	    
   	      
    		ImageView[] imgview =new ImageView[6];
    		for(int i=0;i<6;i++)
    			imgview[i]=new ImageView(image[i]);
   	   
    		Label[] imgLabel = new Label[6];
    		for(int i=0;i<6;i++)
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
   	   
    		for(int i=0;i<6;i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(140, 40);
		
    			flow.setHgap(50);
    			flow.setVgap(50);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}    	
    	if(display=="Fryer")
    	{
    		File file[] = new File[2];
    		file[0]=new File("/Users/Andrew/workspace/CookApp/src/images/salmon.png");
    		file[1]=new File("/Users/Andrew/workspace/CookApp/src/images/talipa.jpg");
    		
    		
    		
    		
    		String imgName[] = new String[2];
    		imgName[0]="Herb Salmon";
    		imgName[1]="Baked Talipa";
    		
    		
    		
    		
    		for(int i=0;i<2;i++)
    			 imgName[i] = String.format(imgName[i],"%12s").replace(' ', ' ');
    	
    		Image image[]=new Image[2];
    		for(int i=0;i<2;i++)
   	  	  		image[i]=new Image(file[i].toURI().toString());
   	    
   	      
    		ImageView[] imgview =new ImageView[2];
    		for(int i=0;i<2;i++)
    			imgview[i]=new ImageView(image[i]);
   	   
    		Label[] imgLabel = new Label[2];
    		for(int i=0;i<2;i++)
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
   	   
    		for(int i=0;i<2;i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(140, 40);
		
    			flow.setHgap(50);
    			flow.setVgap(50);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}	
    	}
    	if(display=="FlatTop")
    	{
    		File file[] = new File[11];
    		file[0]=new File("/Users/Andrew/workspace/CookApp/src/images/brushette.png");
    		file[1]=new File("/Users/Andrew/workspace/CookApp/src/images/calamari.png");
    		file[2]=new File("/Users/Andrew/workspace/CookApp/src/images/eggplant.jpg");
    		file[3]=new File("/Users/Andrew/workspace/CookApp/src/images/firecraker.png");
    		file[4]=new File("/Users/Andrew/workspace/CookApp/src/images/lasgna.png");
    		file[5]=new File("/Users/Andrew/workspace/CookApp/src/images/mozz.png");
    		file[6]=new File("/Users/Andrew/workspace/CookApp/src/images/mushrooms.png");
    		file[7]=new File("/Users/Andrew/workspace/CookApp/src/images/sample.png");
    		file[8]=new File("/Users/Andrew/workspace/CookApp/src/images/shrimpFritta.png");
    		file[9]=new File("/Users/Andrew/workspace/CookApp/src/images/turkeyBacon.png");
    		file[10]=new File("/Users/Andrew/workspace/CookApp/src/images/wings.png");
    		
    		String imgName[] = new String[11];
    		imgName[0]="Brushetta";
    		imgName[1]="Calamari";
    		imgName[2]="Eggplant";
    		imgName[3]="Firecraker";
    		imgName[4]="Lasagne";
    		imgName[5]="Mozzarella";
    		imgName[6]="Stuffed Mush";
    		imgName[7]="Sampler";
    		imgName[8]="Shimp Frit";
    		imgName[9]="Turkey Bac";
    		imgName[10]="Spicy Wings";
    		
    		for(int i=0;i<11;i++)
    			 imgName[i] = String.format(imgName[i],"%12s").replace(' ', ' ');
    	
    		Image image[]=new Image[11];
    		for(int i=0;i<11;i++)
   	  	  		image[i]=new Image(file[i].toURI().toString());
   	    
   	      
    		ImageView[] imgview =new ImageView[11];
    		for(int i=0;i<11;i++)
    			imgview[i]=new ImageView(image[i]);
   	   
    		Label[] imgLabel = new Label[11];
    		for(int i=0;i<11;i++)
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
   	   
    		for(int i=0;i<11;i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(140, 40);
		
    			flow.setHgap(50);
    			flow.setVgap(50);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    	if(display=="Salad")
    	{
    		File file[] = new File[9];
    		file[0]=new File("/Users/Andrew/workspace/CookApp/src/images/chicMil.png");
    		file[1]=new File("/Users/Andrew/workspace/CookApp/src/images/choclate.png");
    		file[2]=new File("/Users/Andrew/workspace/CookApp/src/images/cobb.png");
    		file[3]=new File("/Users/Andrew/workspace/CookApp/src/images/grilledChic.png");
    		file[4]=new File("/Users/Andrew/workspace/CookApp/src/images/grilledcit.png");
    		file[5]=new File("/Users/Andrew/workspace/CookApp/src/images/honey.png");
    		file[6]=new File("/Users/Andrew/workspace/CookApp/src/images/house.png");
    		file[7]=new File("/Users/Andrew/workspace/CookApp/src/images/powerGreen.jpg");
    		file[8]=new File("/Users/Andrew/workspace/CookApp/src/images/walnut.png");
    		
    		
    		String imgName[] = new String[9];
    		imgName[0]="Milanese Chic";
    		imgName[1]="Chocolate Cake";
    		imgName[2]="Cobb";
    		imgName[3]="Grilled Chicken";
    		imgName[4]="Grilled Citrus";
    		imgName[5]="Honey Crisp";
    		imgName[6]="House";
    		imgName[7]="Power Green";
    		imgName[8]="Walnut/Blue";
    		
    		
    		for(int i=0;i<9;i++)
    			 imgName[i] = String.format(imgName[i],"%12s").replace(' ', ' ');
    	
    		Image image[]=new Image[9];
    		for(int i=0;i<9;i++)
   	  	  		image[i]=new Image(file[i].toURI().toString());
   	    
   	      
    		ImageView[] imgview =new ImageView[9];
    		for(int i=0;i<9;i++)
    			imgview[i]=new ImageView(image[i]);
   	   
    		Label[] imgLabel = new Label[9];
    		for(int i=0;i<9;i++)
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
   	   
    		for(int i=0;i<9;i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(140, 40);
		
    			flow.setHgap(50);
    			flow.setVgap(50);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    	if(display=="Expodite")
    	{
    		File file[] = new File[5];
    		file[0]=new File("/Users/Andrew/workspace/CookApp/src/images/brocChed.png");
    		file[1]=new File("/Users/Andrew/workspace/CookApp/src/images/chickenAGn.png");
    		file[2]=new File("/Users/Andrew/workspace/CookApp/src/images/pastaeFago.png");
    		file[3]=new File("/Users/Andrew/workspace/CookApp/src/images/Minestrone.png");
    		file[4]=new File("/Users/Andrew/workspace/CookApp/src/images/Zuppa.png");
    		
    		
    		String imgName[] = new String[5];
    		imgName[0]="Broccoli Ched";
    		imgName[1]="Chicken Gno";
    		imgName[2]="Pasta e Fagioli";
    		imgName[3]="Minestrone";
    		imgName[4]="Zuppa Toscana";
    		
    		
    		for(int i=0;i<5;i++)
    			 imgName[i] = String.format(imgName[i],"%12s").replace(' ', ' ');
    	
    		Image image[]=new Image[5];
    		for(int i=0;i<5;i++)
   	  	  		image[i]=new Image(file[i].toURI().toString());
   	    
   	      
    		ImageView[] imgview =new ImageView[5];
    		for(int i=0;i<5;i++)
    			imgview[i]=new ImageView(image[i]);
   	   
    		Label[] imgLabel = new Label[5];
    		for(int i=0;i<5;i++)
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
   	   
    		for(int i=0;i<5;i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(140, 40);
		
    			flow.setHgap(50);
    			flow.setVgap(50);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}	
    	}
    }
    
    
    private void getItemCount()
    {
    	for(Menu_Item index: mainApp.stationMenuItems)
    	{
    		if(itemCount.containsKey(index.getName()))
    		{
    			Integer temp = itemCount.get(index.getName());
    			temp++;
    			itemCount.put(index.getName(), temp);   		
    		}
    		else
    		{
    			itemCount.put(index.getName(), 1);
    		}    		
    	}
    	Set<String> iterator = itemCount.keySet();
    	for(String index: iterator)
    	{
    		System.out.print(index);
    	}
    }
    
    /**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleComplete() {
		
		if(clickedMenuItem != null)
			mainApp.completeMenuItem(clickedMenuItem);
	}
	
    /**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleRefresh() {
		
		mainApp.getAllOrders(station);
	}
	
	/**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleBackward() {
		
		//mainApp.showLevelbOverview();
		mainApp.showHomePageOverview();
	}
		
 
}