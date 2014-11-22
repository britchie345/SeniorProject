package restauto.cook.display.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Sales {

    private final StringProperty saleID;
    private final StringProperty userID;
    private final StringProperty tableNum;
    private final StringProperty date;
    private final StringProperty arriveTime;
    private final StringProperty serveTime;
    private final StringProperty ifApp;
    private final StringProperty ifCarry;

    /**
     * Simple constructor.
     */
    public Sales() {
        this(null, null, null, null, null, null, null, null);
    }

    /**
     * Constructor for initial data.
     */
    public Sales(String saleID     ,String userID,
    		    String tableNum   ,String date,
    		    String arriveTime ,String serveTime,
    		    String ifApp       ,String ifCarry) {
    	
        this.saleID     = new SimpleStringProperty(saleID);
        this.userID     = new SimpleStringProperty(userID);
        this.tableNum   = new SimpleStringProperty(tableNum);
        this.date       = new SimpleStringProperty(date);
        this.arriveTime = new SimpleStringProperty(arriveTime);
        this.serveTime  = new SimpleStringProperty(serveTime);
        this.ifApp      = new SimpleStringProperty(ifApp);
        this.ifCarry    = new SimpleStringProperty(ifCarry);
    }
    
    /**
     * 	Setters
     */
    public void setSaleID(String saleID) {
        this.saleID.set(saleID);
    }
    public void setUserID(String userID) {
        this.userID.set(userID);
    }
    public void setTableNum(String tableNum) {
        this.tableNum.set(tableNum);
    }
    public void setDate(String date) {
        this.date.set(date);
    }
    public void setArriveTime(String arriveTime) {
        this.arriveTime.set(arriveTime);
    }
    public void setServeTime(String serveTime) {
        this.serveTime.set(serveTime);
    }
    public void setIfApp(String ifApp) {
        this.ifApp.set(ifApp);
    }
    public void setIfCarry(String ifCarry) {
        this.ifCarry.set(ifCarry);
    }
    
    /**
     * 	Getters
     */
    public String getSaleID() {
        return saleID.get();
    }
    public String getUserID() {
        return userID.get();
    }
    public String getTableNum() {
        return tableNum.get();
    }
    public String getDate() {
        return date.get();
    } 
    public String getArriveTime() {
        return arriveTime.get();
    }
    public String getServeTime() {
        return serveTime.get();
    } 
    public String getIfApp() {
        return ifApp.get();
    }
    public String getIfCarry() {
        return ifCarry.get();
    }
    
    /**
     * 	Property Getters
     */
    public StringProperty getSaleIDProperty() {
        return saleID;
    }
    public StringProperty getUserIDProperty() {
        return userID;
    }
    public StringProperty getTableNumProperty() {
        return tableNum;
    }
    public StringProperty getDateProperty() {
        return date;
    }
    public StringProperty getArriveTimeProperty() {
        return arriveTime;
    }
    public StringProperty getServeTimeProperty() {
        return serveTime;
    }
    public StringProperty getIfAppProperty() {
        return ifApp;
    }
    public StringProperty getIfCarryProperty() {
        return ifCarry;
    }

}