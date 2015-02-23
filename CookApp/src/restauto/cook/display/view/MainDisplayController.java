package restauto.cook.display.view;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;

import restauto.cook.display.Main;
import restauto.cook.display.model.Menu_Item;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
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
    
    public void setImages(String display) throws IOException
    {
    	
    	
        if(display=="Bar")
    	{   
        	LinkedHashMap<String, BufferedImage> pictureList=mainApp.cookAppPictures("12");
    		
    		String imgName[]=new String[pictureList.size()];
    		BufferedImage holder[]=new BufferedImage[pictureList.size()];
    		WritableImage images[]=new WritableImage[pictureList.size()];
    		int g=0;
    		for(Iterator i=pictureList.keySet().iterator();i.hasNext();)
    		{
    			imgName[g]=i.next().toString();
    			holder[g]= (BufferedImage) pictureList.get(imgName[g]);
    			g++;
    		}
    		for(int i=0;i<pictureList.size();i++)
    		{
    		if (holder[i] != null) {
	            images[i] = new WritableImage(holder[i].getWidth(), holder[i].getHeight());
	            PixelWriter pw = images[i].getPixelWriter();
	            for (int x = 0; x < holder[i].getWidth(); x++) {
	                for (int y = 0; y < holder[i].getHeight(); y++) {
	                    pw.setArgb(x, y, holder[i].getRGB(x, y));
	                }
	            }

		}
    		}	
    		
    		int count[]=new int[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			if(itemCount.containsKey(imgName[i]))
    				count[i]=itemCount.get(imgName[i]);
    			else
    				count[i]=0;
    			imgName[i]=imgName[i]+": "+count[i];
    		}
    		
   	      
    		ImageView[] imgview =new ImageView[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    			imgview[i]=new ImageView(images[i]);
   	   
    		Label[] imgLabel = new Label[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
    			imgLabel[i].setStyle("-fx-font-size:11;");
    		}
   	   
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(180, 40);
		
    			flow.setHgap(20);
    			flow.setVgap(20);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    		
    	}
        else if(display=="Beverage")
    	{   
        	
        	LinkedHashMap<String, BufferedImage> pictureList=mainApp.cookAppPictures("1");
    		
    		String imgName[]=new String[pictureList.size()];
    		BufferedImage holder[]=new BufferedImage[pictureList.size()];
    		WritableImage images[]=new WritableImage[pictureList.size()];
    		int g=0;
    		for(Iterator i=pictureList.keySet().iterator();i.hasNext();)
    		{
    			imgName[g]=i.next().toString();
    			holder[g]= (BufferedImage) pictureList.get(imgName[g]);
    			g++;
    			
    		}
    		for(int i=0;i<pictureList.size();i++)
    		{
    		if (holder[i] != null) {
	            images[i] = new WritableImage(holder[i].getWidth(), holder[i].getHeight());
	            PixelWriter pw = images[i].getPixelWriter();
	            for (int x = 0; x < holder[i].getWidth(); x++) {
	                for (int y = 0; y < holder[i].getHeight(); y++) {
	                    pw.setArgb(x, y, holder[i].getRGB(x, y));
	                }
	            }

		}
    		}	
    		
    		int count[]=new int[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			if(itemCount.containsKey(imgName[i]))
    				count[i]=itemCount.get(imgName[i]);
    			else
    				count[i]=0;
    			imgName[i]=imgName[i]+": "+count[i];
    		}
    		
   	      
    		ImageView[] imgview =new ImageView[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    			imgview[i]=new ImageView(images[i]);
   	   
    		Label[] imgLabel = new Label[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
    			imgLabel[i].setStyle("-fx-font-size:11;");
    		}
   	   
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(180, 40);
		
    			flow.setHgap(20);
    			flow.setVgap(20);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
        else if(display=="Grill")
    	{
        	LinkedHashMap<String, BufferedImage> pictureList1=mainApp.cookAppPictures("10");
        	LinkedHashMap<String, BufferedImage> pictureList2=mainApp.cookAppPictures("6");
        	LinkedHashMap<String, BufferedImage> pictureList=new LinkedHashMap<String, BufferedImage>();
        	pictureList.putAll(pictureList1);
        	pictureList.putAll(pictureList2);
    		
    		String imgName[]=new String[pictureList.size()];
    		BufferedImage holder[]=new BufferedImage[pictureList.size()];
    		WritableImage images[]=new WritableImage[pictureList.size()];
    		int g=0;
    		for(Iterator i=pictureList.keySet().iterator();i.hasNext();)
    		{
    			imgName[g]=i.next().toString();
    			holder[g]= (BufferedImage) pictureList.get(imgName[g]);
    			g++;
    			
    		}
    		for(int i=0;i<pictureList.size();i++)
    		{
    		if (holder[i] != null) {
	            images[i] = new WritableImage(holder[i].getWidth(), holder[i].getHeight());
	            PixelWriter pw = images[i].getPixelWriter();
	            for (int x = 0; x < holder[i].getWidth(); x++) {
	                for (int y = 0; y < holder[i].getHeight(); y++) {
	                    pw.setArgb(x, y, holder[i].getRGB(x, y));
	                }
	            }

		}
    		}	
    		
    		int count[]=new int[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			if(itemCount.containsKey(imgName[i]))
    				count[i]=itemCount.get(imgName[i]);
    			else
    				count[i]=0;
    			imgName[i]=imgName[i]+": "+count[i];
    		}
    		
   	      
    		ImageView[] imgview =new ImageView[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    			imgview[i]=new ImageView(images[i]);
   	   
    		Label[] imgLabel = new Label[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
    			imgLabel[i].setStyle("-fx-font-size:11;");
    		}
   	   
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(180, 40);
		
    			flow.setHgap(20);
    			flow.setVgap(20);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    		
    	
        else if(display=="Oven")
    	{
        	LinkedHashMap<String, BufferedImage> pictureList1=mainApp.cookAppPictures("7");
        	LinkedHashMap<String, BufferedImage> pictureList2=mainApp.cookAppPictures("9");
        	LinkedHashMap<String, BufferedImage> pictureList=new LinkedHashMap<String, BufferedImage>();
        	pictureList.putAll(pictureList1);
        	pictureList.putAll(pictureList2);
    		
    		String imgName[]=new String[pictureList.size()];
    		BufferedImage holder[]=new BufferedImage[pictureList.size()];
    		WritableImage images[]=new WritableImage[pictureList.size()];
    		int g=0;
    		for(Iterator i=pictureList.keySet().iterator();i.hasNext();)
    		{
    			imgName[g]=i.next().toString();
    			holder[g]= (BufferedImage) pictureList.get(imgName[g]);
    			g++;
    			
    		}
    		for(int i=0;i<pictureList.size();i++)
    		{
    		if (holder[i] != null) {
	            images[i] = new WritableImage(holder[i].getWidth(), holder[i].getHeight());
	            PixelWriter pw = images[i].getPixelWriter();
	            for (int x = 0; x < holder[i].getWidth(); x++) {
	                for (int y = 0; y < holder[i].getHeight(); y++) {
	                    pw.setArgb(x, y, holder[i].getRGB(x, y));
	                }
	            }

		}
    		}	
    		
    		int count[]=new int[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			if(itemCount.containsKey(imgName[i]))
    				count[i]=itemCount.get(imgName[i]);
    			else
    				count[i]=0;
    			imgName[i]=imgName[i]+": "+count[i];
    		}
    		
   	      
    		ImageView[] imgview =new ImageView[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    			imgview[i]=new ImageView(images[i]);
   	   
    		Label[] imgLabel = new Label[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
    			imgLabel[i].setStyle("-fx-font-size:11;");
    		}
   	   
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(180, 40);
		
    			flow.setHgap(20);
    			flow.setVgap(20);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    		
    	   	
        else if(display=="Fryer")
    	{
        	LinkedHashMap<String, BufferedImage> pictureList=mainApp.cookAppPictures("8");
    		
    		String imgName[]=new String[pictureList.size()];
    		BufferedImage holder[]=new BufferedImage[pictureList.size()];
    		WritableImage images[]=new WritableImage[pictureList.size()];
    		int g=0;
    		for(Iterator i=pictureList.keySet().iterator();i.hasNext();)
    		{
    			imgName[g]=i.next().toString();
    			holder[g]= (BufferedImage) pictureList.get(imgName[g]);
    			g++;
    			
    		}
    		for(int i=0;i<pictureList.size();i++)
    		{
    		if (holder[i] != null) {
	            images[i] = new WritableImage(holder[i].getWidth(), holder[i].getHeight());
	            PixelWriter pw = images[i].getPixelWriter();
	            for (int x = 0; x < holder[i].getWidth(); x++) {
	                for (int y = 0; y < holder[i].getHeight(); y++) {
	                    pw.setArgb(x, y, holder[i].getRGB(x, y));
	                }
	            }

		}
    		}	
    		
    		int count[]=new int[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			if(itemCount.containsKey(imgName[i]))
    				count[i]=itemCount.get(imgName[i]);
    			else
    				count[i]=0;
    			imgName[i]=imgName[i]+": "+count[i];
    		}
    		
   	      
    		ImageView[] imgview =new ImageView[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    			imgview[i]=new ImageView(images[i]);
   	   
    		Label[] imgLabel = new Label[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
    			imgLabel[i].setStyle("-fx-font-size:11;");
    		}
   	   
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(180, 40);
		
    			flow.setHgap(20);
    			flow.setVgap(20);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    		
    	
        else if(display=="FlatTop")
    	{
        	LinkedHashMap<String, BufferedImage> pictureList1=mainApp.cookAppPictures("2");
        	LinkedHashMap<String, BufferedImage> pictureList2=mainApp.cookAppPictures("5");
        	LinkedHashMap<String, BufferedImage> pictureList=new LinkedHashMap<String, BufferedImage>();
        	pictureList.putAll(pictureList1);
        	pictureList.putAll(pictureList2);
    		
    		String imgName[]=new String[pictureList.size()];
    		BufferedImage holder[]=new BufferedImage[pictureList.size()];
    		WritableImage images[]=new WritableImage[pictureList.size()];
    		int g=0;
    		for(Iterator i=pictureList.keySet().iterator();i.hasNext();)
    		{
    			imgName[g]=i.next().toString();
    			holder[g]= (BufferedImage) pictureList.get(imgName[g]);
    			g++;
    			
    		}
    		for(int i=0;i<pictureList.size();i++)
    		{
    		if (holder[i] != null) {
	            images[i] = new WritableImage(holder[i].getWidth(), holder[i].getHeight());
	            PixelWriter pw = images[i].getPixelWriter();
	            for (int x = 0; x < holder[i].getWidth(); x++) {
	                for (int y = 0; y < holder[i].getHeight(); y++) {
	                    pw.setArgb(x, y, holder[i].getRGB(x, y));
	                }
	            }

		}
    		}	
    		
    		int count[]=new int[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			if(itemCount.containsKey(imgName[i]))
    				count[i]=itemCount.get(imgName[i]);
    			else
    				count[i]=0;
    			imgName[i]=imgName[i]+": "+count[i];
    		}
    		
   	      
    		ImageView[] imgview =new ImageView[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    			imgview[i]=new ImageView(images[i]);
   	   
    		Label[] imgLabel = new Label[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
    			imgLabel[i].setStyle("-fx-font-size:11;");
    		}
   	   
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(180, 40);
		
    			flow.setHgap(20);
    			flow.setVgap(20);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}    		   		    	
        else if(display=="Salad")
    	{
        	LinkedHashMap<String, BufferedImage> pictureList1=mainApp.cookAppPictures("3");
        	LinkedHashMap<String, BufferedImage> pictureList2=mainApp.cookAppPictures("11");
        	LinkedHashMap<String, BufferedImage> pictureList=new LinkedHashMap<String, BufferedImage>();
        	pictureList.putAll(pictureList1);
        	pictureList.putAll(pictureList2);
        	
    		String imgName[]=new String[pictureList.size()];
    		BufferedImage holder[]=new BufferedImage[pictureList.size()];
    		WritableImage images[]=new WritableImage[pictureList.size()];
    		int g=0;
    		for(Iterator i=pictureList.keySet().iterator();i.hasNext();)
    		{
    			imgName[g]=i.next().toString();
    			holder[g]= (BufferedImage) pictureList.get(imgName[g]);
    			g++;
    			
    		}
    		for(int i=0;i<pictureList.size();i++)
    		{
    		if (holder[i] != null) {
	            images[i] = new WritableImage(holder[i].getWidth(), holder[i].getHeight());
	            PixelWriter pw = images[i].getPixelWriter();
	            for (int x = 0; x < holder[i].getWidth(); x++) {
	                for (int y = 0; y < holder[i].getHeight(); y++) {
	                    pw.setArgb(x, y, holder[i].getRGB(x, y));
	                }
	            }

		}
    		}	
    		
    		int count[]=new int[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			if(itemCount.containsKey(imgName[i]))
    				count[i]=itemCount.get(imgName[i]);
    			else
    				count[i]=0;
    			imgName[i]=imgName[i]+": "+count[i];
    		}
    		
   	      
    		ImageView[] imgview =new ImageView[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    			imgview[i]=new ImageView(images[i]);
   	   
    		Label[] imgLabel = new Label[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
    			imgLabel[i].setStyle("-fx-font-size:11;");
    		}
   	   
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(180, 40);
		
    			flow.setHgap(20);
    			flow.setVgap(20);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
        else if(display=="Expodite")
    	{
        	LinkedHashMap<String, BufferedImage> pictureList=mainApp.cookAppPictures("4");
    		
    		String imgName[]=new String[pictureList.size()];
    		BufferedImage holder[]=new BufferedImage[pictureList.size()];
    		WritableImage images[]=new WritableImage[pictureList.size()];
    		int g=0;
    		for(Iterator i=pictureList.keySet().iterator();i.hasNext();)
    		{
    			imgName[g]=i.next().toString();
    			holder[g]= (BufferedImage) pictureList.get(imgName[g]);
    			g++;
    			
    		}
    		for(int i=0;i<pictureList.size();i++)
    		{
    		if (holder[i] != null) {
	            images[i] = new WritableImage(holder[i].getWidth(), holder[i].getHeight());
	            PixelWriter pw = images[i].getPixelWriter();
	            for (int x = 0; x < holder[i].getWidth(); x++) {
	                for (int y = 0; y < holder[i].getHeight(); y++) {
	                    pw.setArgb(x, y, holder[i].getRGB(x, y));
	                }
	            }

		}
    		}	
    		
    		int count[]=new int[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			if(itemCount.containsKey(imgName[i]))
    				count[i]=itemCount.get(imgName[i]);
    			else
    				count[i]=0;
    			imgName[i]=imgName[i]+": "+count[i];
    		}
    		
   	      
    		ImageView[] imgview =new ImageView[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    			imgview[i]=new ImageView(images[i]);
   	   
    		Label[] imgLabel = new Label[pictureList.size()];
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgLabel[i]= new Label(imgName[i],imgview[i]);
    			imgLabel[i].setStyle("-fx-font-size:11;");
    		}
   	   
    		for(int i=0;i<pictureList.size();i++)
    		{
    			imgview[i].setFitHeight(30);
    			imgview[i].setFitWidth(30);
    			
    			imgLabel[i].setPrefSize(180, 40);
		
    			flow.setHgap(20);
    			flow.setVgap(20);
  		
    			flow.getChildren().add(imgLabel[i]);
    		}
    	}
    }

    public void getItemCount()
    {
    	for(Menu_Item index: mainApp.stationMenuItems) {
    		if(itemCount.containsKey(index.getName())) {
    			Integer temp = itemCount.get(index.getName());
    			temp++;
    			itemCount.put(index.getName(), temp);   		
    		}
    		else
    			itemCount.put(index.getName(), 1);
    		
    	}    	
    }
    
    /**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleComplete() {
		
		if(clickedMenuItem != null)
			mainApp.completeMenuItem(clickedMenuItem, station);
		
		mainApp.showMainDisplay(station,mainApp.getTable());
	}
	
    /**
	 * Called when the user clicks the back button.
	 */
	@FXML
	private void handleRefresh() {
		
		mainApp.getAllOrders(station);
		mainApp.showMainDisplay(station,mainApp.getTable());
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