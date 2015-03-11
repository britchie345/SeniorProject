package restauto.cook.display.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HelpTable {

	 	private final StringProperty TableID;
	    private final StringProperty CustID;
	    private final StringProperty time;

	    
	    
	    public HelpTable() {
	    	
	    	this(null, null, null, null);
	    
	    	
	    }
	    
	    public HelpTable(String orderID ,String saleID,
  		      String itemID  ,String request) {
  	
      this.TableID = new SimpleStringProperty(orderID);
      this.CustID  = new SimpleStringProperty(saleID);
      this.time  = new SimpleStringProperty(itemID);
  }
	    
	    /**
	     * 	Setters
	     */
	    public void setTableID(String orderID) {
	        this.TableID.set(orderID);
	    }
	    public void setCustID(String saleID) {
	        this.CustID.set(saleID);
	    }
	    public void setTime(String itemID) {
	        this.time.set(itemID);
	    }
	   
	    
	    /**
	     * 	Getters
	     */
	    public String getTableID() {
	        return TableID.get();
	    }
	    public String getCustID() {
	        return CustID.get();
	    }
	    public String getTime() {
	        return time.get();
	    }
	   
	    
	    /**
	     * 	Property Getters
	     */
	    public StringProperty getTableIDProperty() {
	        return TableID;
	    }
	    public StringProperty getCustIDProperty() {
	        return CustID;
	    }
	    public StringProperty getTimeProperty() {
	        return time;
	    }
	   
	    
	    
	    
	    
	    
}
