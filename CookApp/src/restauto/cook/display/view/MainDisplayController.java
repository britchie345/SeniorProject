package restauto.cook.display.view;


import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
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
    		URL location[] =new URL[5]; 
    		location[0]=this.getClass().getResource("/images/strawberryBar.png");
    		location[1]=this.getClass().getResource("/images/cosmo.png");
    		location[2]=this.getClass().getResource("/images/white.png");
    		location[3]=this.getClass().getResource("/images/longIsland.png");
    		location[4]=this.getClass().getResource("/images/rum+coke.jpg");
    		
    		String fullPath[] =new String[5];
    		for(int i=0;i<5;i++)
        		fullPath[i]=location[i].getPath();   		
    		
    		
    		File file[] = new File[5];
    		file[0]=new File(fullPath[0]);
    		file[1]=new File(fullPath[1]);
    		file[2]=new File(fullPath[2]);
    		file[3]=new File(fullPath[3]);
    		file[4]=new File(fullPath[4]);
    		
    		
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
        else if(display=="Beverage")
    	{   
    		URL location[] =new URL[11]; 
    		location[0]=this.getClass().getResource("/images/cokecola.png");
    		location[1]=this.getClass().getResource("/images/DietCoke.png");
    		location[2]=this.getClass().getResource("/images/sprite.jpg");
    		location[3]=this.getClass().getResource("/images/drpepper.jpg");
    		location[4]=this.getClass().getResource("/images/rootbeer.jpg");
    		location[5]=this.getClass().getResource("/images/orangesoda.jpg");
    		location[6]=this.getClass().getResource("/images/cherrycoke.jpg");
    		location[7]=this.getClass().getResource("/images/lemonade.jpg");
    		location[8]=this.getClass().getResource("/images/strawberry.jpg");
    		location[9]=this.getClass().getResource("/images/sweetTea.jpg");
    		location[10]=this.getClass().getResource("/images/unsweet.jpg");
    		
    		String fullPath[] =new String[11];
    		for(int i=0;i<11;i++)
        		fullPath[i]=location[i].getPath();
    		
    		
    		
    		
    		File file[] = new File[11];      		
    		file[0]=new File(fullPath[0]);     		
    		file[1]=new File(fullPath[1]);
    		file[2]=new File(fullPath[2]);
    		file[3]=new File(fullPath[3]);
    		file[4]=new File(fullPath[4]);
    		file[5]=new File(fullPath[5]);
    		file[6]=new File(fullPath[6]);
    		file[7]=new File(fullPath[7]);
    		file[8]=new File(fullPath[8]);
    		file[9]=new File(fullPath[9]);
    		file[10]=new File(fullPath[10]);
    		
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
        else if(display=="Grill")
    	{
    		URL location[] =new URL[4]; 
    		location[0]=this.getClass().getResource("/images/chedderBurger.jpg");
    		location[1]=this.getClass().getResource("/images/veggieBurger.jpg");
    		location[2]=this.getClass().getResource("/images/filet.jpg");
    		location[3]=this.getClass().getResource("/images/parmSteak.jpg");
    		
    		
    		String fullPath[] =new String[4];
    		for(int i=0;i<4;i++)
        		fullPath[i]=location[i].getPath();
    		
    		
    		File file[] = new File[4];
    		file[0]=new File(fullPath[0]);
    		file[1]=new File(fullPath[1]);
    		file[2]=new File(fullPath[2]);
    		file[3]=new File(fullPath[3]);
    		
    		
    		
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
        else if(display=="Oven")
    	{
    		URL location[] =new URL[6]; 
    		location[0]=this.getClass().getResource("/images/chickenAlfedo.png");
    		location[1]=this.getClass().getResource("/images/garlicChicken.png");
    		location[2]=this.getClass().getResource("/images/macNcheese.jpg");
    		location[3]=this.getClass().getResource("/images/rattlesnake.png");
    		location[4]=this.getClass().getResource("/images/shrimp.png");
    		location[5]=this.getClass().getResource("/images/stuffedChicken.jpg");
    		
    		String fullPath[] =new String[6];
    		for(int i=0;i<6;i++)
        		fullPath[i]=location[i].getPath();
    		
    		File file[] = new File[6];
    		file[0]=new File(fullPath[0]);
    		file[1]=new File(fullPath[1]);
    		file[2]=new File(fullPath[2]);
    		file[3]=new File(fullPath[3]);
    		file[4]=new File(fullPath[4]);
    		file[5]=new File(fullPath[5]);
    		
    		
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
        else if(display=="Fryer")
    	{
    		URL location[] =new URL[2]; 
    		location[0]=this.getClass().getResource("/images/salmon.png");
    		location[1]=this.getClass().getResource("/images/talipa.jpg");    		    		
    		
    		String fullPath[] =new String[2];
    		fullPath[0]=location[0].getPath();
    		fullPath[1]=location[1].getPath();    		
    		
    		File file[] = new File[2];
    		file[0]=new File(fullPath[0]);
    		file[1]=new File(fullPath[1]);
    		
    		
    		
    		
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
        else if(display=="FlatTop")
    	{
    		URL location[] =new URL[11]; 
    		location[0]=this.getClass().getResource("/images/brushette.png.");
    		location[1]=this.getClass().getResource("/images/calamari.png");
    		location[2]=this.getClass().getResource("/images/eggplant.jpg");
    		location[3]=this.getClass().getResource("/images/firecraker.png");
    		location[4]=this.getClass().getResource("/images/lasgna.png");
    		location[5]=this.getClass().getResource("/images/mozz.png");
    		location[6]=this.getClass().getResource("/images/mushrooms.png");
    		location[7]=this.getClass().getResource("/images/sample.png");
    		location[8]=this.getClass().getResource("/images/shrimpFritta.png");
    		location[9]=this.getClass().getResource("/images/turkeyBacon.png");
    		location[10]=this.getClass().getResource("/images/wings.png");
    		
    		String fullPath[] =new String[11];
    		for(int i=0;i<11;i++)
        		fullPath[i]=location[i].getPath();
    		
    		File file[] = new File[11];
    		file[0]=new File(fullPath[0]);
    		file[1]=new File(fullPath[1]);
    		file[2]=new File(fullPath[2]);
    		file[3]=new File(fullPath[3]);
    		file[4]=new File(fullPath[4]);
    		file[5]=new File(fullPath[5]);
    		file[6]=new File(fullPath[6]);
    		file[7]=new File(fullPath[7]);
    		file[8]=new File(fullPath[8]);
    		file[9]=new File(fullPath[9]);
    		file[10]=new File(fullPath[10]);
    		
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
        else if(display=="Salad")
    	{
    		URL location[] =new URL[9]; 
    		location[0]=this.getClass().getResource("/images/chicMil.png.");
    		location[1]=this.getClass().getResource("/images/choclate.png");
    		location[2]=this.getClass().getResource("/images/cobb.png");
    		location[3]=this.getClass().getResource("/images/grilledChic.png");
    		location[4]=this.getClass().getResource("/images/grilledcit.png");
    		location[5]=this.getClass().getResource("/images/honey.png");
    		location[6]=this.getClass().getResource("/images/house.png");
    		location[7]=this.getClass().getResource("/images/powerGreen.jpg");
    		location[8]=this.getClass().getResource("/images/walnut.png");
    		
    		String fullPath[] =new String[9];
    		for(int i=0;i<9;i++)
        		fullPath[i]=location[i].getPath();  		
    		
    		
    		File file[] = new File[9];
    		file[0]=new File(fullPath[0]);
    		file[1]=new File(fullPath[1]);
    		file[2]=new File(fullPath[2]);
    		file[3]=new File(fullPath[3]);
    		file[4]=new File(fullPath[4]);
    		file[5]=new File(fullPath[5]);
    		file[6]=new File(fullPath[6]);
    		file[7]=new File(fullPath[7]);
    		file[8]=new File(fullPath[8]);
    		
    		
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
        else if(display=="Expodite")
    	{
    		URL location[] =new URL[5]; 
    		location[0]=this.getClass().getResource("/images/brocChed.png");
    		location[1]=this.getClass().getResource("/images/chickenAGn.png");
    		location[2]=this.getClass().getResource("/images/pastaeFago.png");
    		location[3]=this.getClass().getResource("/images/Minestrone.png");
    		location[4]=this.getClass().getResource("/images/Zuppa.png");
    		
    		String fullPath[] =new String[5];
    		for(int i=0;i<5;i++)
    		fullPath[i]=location[i].getPath();
    	
    		
    		File file[] = new File[5];
    		file[0]=new File(fullPath[0]);
    		file[1]=new File(fullPath[1]);
    		file[2]=new File(fullPath[2]);
    		file[3]=new File(fullPath[3]);
    		file[4]=new File(fullPath[4]);
    		
    		
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