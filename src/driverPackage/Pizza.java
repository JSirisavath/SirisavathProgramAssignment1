package driverPackage;

public class Pizza {
	private String PizzaName;
	
	private Integer NumberOfPizza;

	
	// Constructor for Pizza Name and number of Pizza
	public Pizza(String pizzaName, Integer numberOfPizza) {
		super();
		PizzaName = pizzaName;
		NumberOfPizza = numberOfPizza;
	}
	

	// Getters and Setters
	public String getPizzaName() {
		return PizzaName;
	}




	public void setPizzaName(String pizzaName) {
		PizzaName = pizzaName;
	}


	public Integer getNumberOfPizza() {
		return NumberOfPizza;
	}


	public void setNumberOfPizza(Integer numberOfPizza) {
		NumberOfPizza = numberOfPizza;
	}




	// To string function 
	@Override
	public String toString() {
		return "Pizza: PizzaName = " + PizzaName + ", NumberOfPizza = " + NumberOfPizza + "\n";
	}
	
	
	// Comparator
	public boolean equals (Pizza usersPizza) {
		
		String pizzaName = this.PizzaName;
		
		String usersPizzaName = usersPizza.PizzaName;
		
		// Returns true if this pizzaName is equal to the users pizza name case insensitive
		Boolean checkEqual = pizzaName.equalsIgnoreCase(usersPizzaName);
		
		// If true, return boolean to be true
		if (checkEqual) {
			return true;
		}
		
		return false; // Default return is false
		
	}
	

}
