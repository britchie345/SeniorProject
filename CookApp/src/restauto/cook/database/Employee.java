package restauto.cook.database;

public class Employee {

	int employeeID;
	String userName;
	String passWord;
	String firstName;
	String lastName;
	
	//setters
	public void setID(int id)
	{
		employeeID=id;
	}
	public void setUserName(String user)
	{
		userName=user;
	}
	public void setPassWord(String pass)
	{
		passWord=pass;
	}
	public void setFirstName(String name)
	{
		firstName=name;
	}
	public void setLastName(String name)
	{
		lastName=name;
	}
	
	//getters
	public int getID()
	{
		return employeeID;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getPassWord()
	{
		return passWord;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	
}
