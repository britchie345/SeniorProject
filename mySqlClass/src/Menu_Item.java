
public class Menu_Item {

	private int id;
	private int calories;
	private int onmenu;
	private int spicy;
	private int recommended;
	
	private double price;
	
	private String name;
	private String menu_Desc;
	private String Description;
	private String cooktime;
	
	/*
	*   Setters
	*/
	public void setId(int id) {
	
		this.id = id;
	}
	
	public void setName(String name) {
			
		this.name = name;
	}
          
	public void setMenuDesc(String menu_Desc) {
			
		this.menu_Desc = menu_Desc;
	}
          
	public void setDescription(String Description) {
			
		this.Description = Description;
	}
          
	public void setPrice(double price) {
			
		this.price = price;
	}
          
	public void setCalories(int calories) {
			
		this.calories = calories;
	}
          
	public void setOnMenu(int onmenu) {
			
		this.onmenu = onmenu;
	}
          
	public void setCookTime(String cooktime) {
			
		this.cooktime = cooktime;
	}
          
	public void setSpicy(int spicy) {
			
		this.spicy = spicy;
	}
          
	public void setRecommended(int recommended) {
	
		this.recommended = recommended;
	}
	
	/*
	*   Getters
	*/
	public int getId() {
			
		return id;
	}
			
	public String getName() {
			
		return name;
	}
			
	public String getMenuDesc() {
			
		return menu_Desc;
	}
	
	public String getDescription() {
			
		return Description;
	}
	
	public double getPrice() {
			
		return price;
	}
	
	public int getCalories() {
			
		return calories;
	}
	
	public int getOnMenu() {
			
		return onmenu;
	}

	public String getCookTime() {
			
		return cooktime;
	}

	public int getSpicy() {
			
		return spicy;
	}

	public int getRecommended() {
	
		return recommended;
	}
	
}