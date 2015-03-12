package restauto.manager.menu.levelc.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Employee {

    private final StringProperty itemID;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty fname;
    private final StringProperty lname;

    /**
     * Simple constructor.
     */
    public Employee() {
        this(null, null, null, null, null);
    }

    /**
     * Constructor for initial data.
     */
    public Employee(String itemID      ,String username,
    				 String password      ,String fname,
    				 String lname) {
    	
        this.itemID      = new SimpleStringProperty(itemID);
        this.username    = new SimpleStringProperty(username);
        this.password      = new SimpleStringProperty(password);
        this.fname       = new SimpleStringProperty(fname);
        this.lname  = new SimpleStringProperty(lname);
    }
    
    /**
     * 	Setters
     */
    public void setItemID(String itemID) {
        this.itemID.set(itemID);
    }
    public void setUsername(String username) {
        this.username.set(username);
    }
    public void setPassword(String password) {
        this.password.set(password);
    }
    public void setFname(String fname) {
        this.fname.set(fname);
    }
    public void setLname(String lname) {
        this.lname.set(lname);
    }
    
    /**
     * 	Getters
     */
    public String getItemID() {
        return itemID.get();
    }
    public String getUsername() {
        return username.get();
    }
    public String getPassword() {
        return password.get();
    }
    public String getFname() {
        return fname.get();
    } 
    public String getLname() {
        return lname.get();
    }
    
    /**
     * 	Property Getters
     */
    public StringProperty getItemIDProperty() {
        return itemID;
    }
    public StringProperty getUsernameProperty() {
        return username;
    }
    public StringProperty getPasswordProperty() {
        return password;
    }
    public StringProperty getFnameProperty() {
        return fname;
    }
    public StringProperty getLnameProperty() {
        return lname;
    }
    }

