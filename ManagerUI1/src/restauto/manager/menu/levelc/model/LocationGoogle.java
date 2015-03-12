package restauto.manager.menu.levelc.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class LocationGoogle {

    private final StringProperty itemID;
    private final StringProperty latitude;
    private final StringProperty longitude;
    private final StringProperty title;
    private final StringProperty description;
    private final StringProperty street;
    private final StringProperty city;
    private final StringProperty state;
    private final StringProperty zip;

    /**
     * Simple constructor.
     */
    public LocationGoogle() {
        this(null, null, null, null, null, null, null, null, null);
    }

    /**
     * Constructor for initial data.
     */
    public LocationGoogle(String itemID      ,String latitude,
    				 String longitude      ,String title,
    				 String description  ,String street,
    				 String city        ,String state,
    				 String zip) {
    	
        this.itemID      = new SimpleStringProperty(itemID);
        this.latitude    = new SimpleStringProperty(latitude);
        this.longitude      = new SimpleStringProperty(longitude);
        this.title       = new SimpleStringProperty(title);
        this.description  = new SimpleStringProperty(description);
        this.street       = new SimpleStringProperty(street);
        this.city        = new SimpleStringProperty(city);
        this.state    = new SimpleStringProperty(state);
        this.zip = new SimpleStringProperty(zip);
    }
    
    /**
     * 	Setters
     */
    public void setItemID(String itemID) {
        this.itemID.set(itemID);
    }
    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }
    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }
    public void setTitle(String title) {
        this.title.set(title);
    }
    public void setStreet(String street) {
        this.street.set(street);
    }
    public void setCity(String city) {
        this.city.set(city);
    }
    public void setState(String state) {
        this.state.set(state);
    }
    public void setZip(String zip) {
        this.zip.set(zip);
    }
    public void setDescription(String description) {
        this.description.set(description);
    }
    
    /**
     * 	Getters
     */
    public String getItemID() {
        return itemID.get();
    }
    public String getLongitude() {
        return longitude.get();
    }
    public String getLatitude() {
        return latitude.get();
    }
    public String getTitle() {
        return title.get();
    } 
    public String getStreet() {
        return street.get();
    }
    public String getCity() {
        return city.get();
    } 
    public String getState() {
        return state.get();
    }
    public String getZip() {
        return zip.get();
    } 
    public String getDescription() {
        return description.get();
    }
    
    /**
     * 	Property Getters
     */
    public StringProperty getItemIDProperty() {
        return itemID;
    }
    public StringProperty getLongitudeProperty() {
        return longitude;
    }
    public StringProperty getLatitudeProperty() {
        return latitude;
    }
    public StringProperty getTitleProperty() {
        return title;
    }
    public StringProperty getStreetProperty() {
        return street;
    }
    public StringProperty getCityProperty() {
        return city;
    }
    public StringProperty getStateProperty() {
        return state;
    }
    public StringProperty getZipProperty() {
        return zip;
    }
    public StringProperty getDescriptionProperty() {
        return description;
    }

}