package restauto.cook.display.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Orders {

    private final StringProperty orderID;
    private final StringProperty saleID;
    private final StringProperty itemID;
    private final StringProperty request;

    /**
     * Simple constructor.
     */
    public Orders() {
        this(null, null, null, null);
    }

    /**
     * Constructor for initial data.
     */
    public Orders(String orderID ,String saleID,
    		      String itemID  ,String request) {
    	
        this.orderID = new SimpleStringProperty(orderID);
        this.saleID  = new SimpleStringProperty(saleID);
        this.itemID  = new SimpleStringProperty(itemID);
        this.request = new SimpleStringProperty(request);
    }
    
    /**
     * 	Setters
     */
    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
    }
    public void setSaleID(String saleID) {
        this.saleID.set(saleID);
    }
    public void setItemID(String itemID) {
        this.itemID.set(itemID);
    }
    public void setRequest(String request) {
        this.request.set(request);
    }
    
    /**
     * 	Getters
     */
    public String getOrderID() {
        return orderID.get();
    }
    public String getSaleID() {
        return saleID.get();
    }
    public String getItemID() {
        return itemID.get();
    }
    public String getRequest() {
        return request.get();
    }
    
    /**
     * 	Property Getters
     */
    public StringProperty getOrderIDProperty() {
        return orderID;
    }
    public StringProperty getSaleIDProperty() {
        return saleID;
    }
    public StringProperty getItemIDProperty() {
        return itemID;
    }
    public StringProperty getRequestProperty() {
        return request;
    }

}