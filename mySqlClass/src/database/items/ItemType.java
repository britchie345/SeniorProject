package database.items;

public class ItemType {

	private int itemID;
	private int typeID;
	
	/*
	*   Setters
	*/
	public void setItemId(int itemID) {
	
		this.itemID = itemID;
	}
	
	public void setTypeId(int typeID) {
	
		this.typeID = typeID;
	}
	
	/*
	*   Getters
	*/
	public int getItemId() {
	
		return itemID;
	}
	
	public int getTypeId() {
	
		return typeID;
	}
	
}