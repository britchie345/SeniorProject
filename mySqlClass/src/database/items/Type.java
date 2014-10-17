package database.items;

public class Type {

	private String name;
	private String description;
		
	private int typeID;

	/*
	*   Setters
	*/
	public void setTypeId(int typeID) {
		
		this.typeID = typeID;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public void setDescription(String description) {
		
		this.description = description;
	}

	/*
	*   Getters
	*/
	public int getTypeId() {
		
		return typeID;
	}

	public String getName() {
		
		return name;
	}

	public String getDescription() {
		
		return description;
	}
	
}