package restauto.manager.menu.levelc.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Type {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty description;

    /**
     * Simple constructor.
     */
    public Type() {
        this("", "", "");
    }

    /**
     * Constructor for initial data.
     * 
     * @param id
     * @param name
     * @param description
     */
    public Type(String id, String name, String description) {
    	
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }
    
    /**
     * 	Setters
     */
    public void setID(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }   

    public void setDescription(String description) {
        this.description.set(description);
    }  
    
    /**
     * 	Getters
     */
    public String getName() {
        return name.get();
    }   

    public String getDescription() {
        return description.get();
    }   

    public String getID() {
        return id.get();
    }  
    
    /**
     * 	Property Getters
     */
    public StringProperty getIDProperty() {
        return id;
    }

    public StringProperty getNameProperty() {
        return name;
    }
    
    public StringProperty getDescriptionProperty() {
        return description;
    }

}