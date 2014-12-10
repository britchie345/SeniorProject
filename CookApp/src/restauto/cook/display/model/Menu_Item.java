package restauto.cook.display.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Menu_Item {

    private final StringProperty itemID;
    private final StringProperty calories;
    private final StringProperty onMenu;
    private final StringProperty spicy;
    private final StringProperty recomended;
    private final StringProperty price;
    private final StringProperty name;
    private final StringProperty menuDesc;
    private final StringProperty description;
    private final StringProperty cookTime;
    
    private final StringProperty tableNumber = new SimpleStringProperty("20");
    private final StringProperty orderTime   = new SimpleStringProperty("9:32");
    
    private String saleID       = "";
    private String orderID      = "";
    private String request      = "";
    private String orderItemID  = "";

    /**
     * Simple constructor.
     */
    public Menu_Item() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Constructor for initial data.
     */
    public Menu_Item(String itemID      ,String calories,
    				 String onMenu      ,String spicy,
    				 String recomended  ,String price,
    				 String name        ,String menuDesc,
    				 String description ,String cookTime,
    				 String saleID		,String orderID,
    				 String request		,String orderItemID) {
    	
        this.itemID      = new SimpleStringProperty(itemID);
        this.calories    = new SimpleStringProperty(calories);
        this.onMenu      = new SimpleStringProperty(onMenu);
        this.spicy       = new SimpleStringProperty(spicy);
        this.recomended  = new SimpleStringProperty(recomended);
        this.price       = new SimpleStringProperty(price);
        this.name        = new SimpleStringProperty(name);
        this.menuDesc    = new SimpleStringProperty(menuDesc);
        this.description = new SimpleStringProperty(description);
        this.cookTime    = new SimpleStringProperty(cookTime);
        
        this.saleID      = saleID;
        this.orderID     = orderID;
        this.request     = request;
        this.orderItemID = orderItemID;
    }
    
    /**
     * 	Setters
     */
    public void setTableNumber(String tableNumber) {
        this.tableNumber.set(tableNumber);
    }
    public void setOrderTime(String orderTime) {
        this.orderTime.set(orderTime);
    }
    public void setItemID(String itemID) {
        this.itemID.set(itemID);
    }
    public void setCalories(String calories) {
        this.calories.set(calories);
    }
    public void setOnMenu(String onMenu) {
        this.onMenu.set(onMenu);
    }
    public void setSpicy(String spicy) {
        this.spicy.set(spicy);
    }
    public void setRecomended(String recomended) {
        this.recomended.set(recomended);
    }
    public void setPrice(String price) {
        this.price.set(price);
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public void setMenuDesc(String menuDesc) {
        this.menuDesc.set(menuDesc);
    }
    public void setDescription(String description) {
        this.description.set(description);
    }
    public void setCookTime(String cookTime) {
        this.cookTime.set(cookTime);
    }
    
    /**
     * 	Getters
     */
    public String getTableNumber() {
    	return tableNumber.get();
    }
    public String getOrderTime() {
    	return orderTime.get();
    }
    public String getItemID() {
        return itemID.get();
    }
    public String getCalories() {
        return calories.get();
    }
    public String getOnMenu() {
        return onMenu.get();
    }
    public String getSpicy() {
        return spicy.get();
    } 
    public String getRecomended() {
        return recomended.get();
    }
    public String getPrice() {
        return price.get();
    } 
    public String getName() {
        return name.get();
    }
    public String getMenuDesc() {
        return menuDesc.get();
    } 
    public String getDescription() {
        return description.get();
    }
    public String getCookTime() {
        return cookTime.get();
    }
    
    public String getSaleID() {
        return saleID;
    } 
    public String getOrderID() {
        return orderID;
    }
    public String getRequest() {
        return request;
    } 
    public String getOrderItemID() {
        return orderItemID;
    } 
    
    /**
     * 	Property Getters
     */
    public StringProperty getTableNumberProperty() {
        return tableNumber;
    }
    public StringProperty getOrderTimeProperty() {
        return orderTime;
    }
    public StringProperty getItemIDProperty() {
        return itemID;
    }
    public StringProperty getCaloriesProperty() {
        return calories;
    }
    public StringProperty getOnMenuProperty() {
        return onMenu;
    }
    public StringProperty getSpicyProperty() {
        return spicy;
    }
    public StringProperty getRecomendedProperty() {
        return recomended;
    }
    public StringProperty getPriceProperty() {
        return price;
    }
    public StringProperty getNameProperty() {
        return name;
    }
    public StringProperty getMenuDescProperty() {
        return menuDesc;
    }
    public StringProperty getDescriptionProperty() {
        return description;
    }
    public StringProperty getCookTimeProperty() {
        return cookTime;
    }

}