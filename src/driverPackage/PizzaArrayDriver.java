package driverPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaArrayDriver {
	
	public static void main(String[] args) {
		
		// Scanner for users input
		// Using the try with resources tech. to automatically close resources like db and file connections. Ensures resources are closed after there is an exception
		try (Scanner inputScanner = new Scanner(System.in)) {
			// An array of objects
			Pizza[] PizzaArr = new Pizza[20];
			
			
			// Ask users what file name to create: 
			
			System.out.print("Enter a file name you want to create! ");
			String usersFileName = inputScanner.nextLine();
			
			
			// Create the file from users requests]
			File usersFile = new File(usersFileName);
			
			
			// Creating a scanner and read from the file
			// Using the try with resources tech. to automatically close resources like db and file connections. Ensures resources are closed after there is an exception
			try (Scanner fileScanner = new Scanner(usersFile)) {
				// Keep count of how many lines read
				int index =0;
			
				// While the scanner has lines to read, read each line of items from that file	
				while (fileScanner.hasNext()) {
					String pizzaNameField = fileScanner.next();
					
					int pizzaQuantityfield = fileScanner.nextInt();
					
					// Create a new pizza object from the scanned file fields
					Pizza newPizzaFromFile = new Pizza(pizzaNameField,pizzaQuantityfield);
					
					
					//add both read lines	to the array of pizza objects
					PizzaArr[index] = new Pizza(pizzaNameField,pizzaQuantityfield);
				}
				
			} catch (FileNotFoundException error) {
				System.out.printf("File not found: ", error);
				return;
			}
			
			// Print the user's Pizza on screen
			System.out.print("Pizza from the array:\n");
			
			for (Pizza pizza : PizzaArr) {
				pizza.toString();
			}
			
		}
	
	} 
	
	public int overallAvg( Pizza[] inputArray ) {
		int sum = 0;
		
		// For each pizza in the input array, get the number of that pizza and add them up together
		for (Pizza pizza : inputArray) {
			sum += pizza.getNumberOfPizza();
		}
		
		// Grab the average of the pizza
		int avg = sum/inputArray.length;
		
		return avg;
	}
	
	
	public int count( Pizza[] p, Pizza o ) {
		
		int count = 0;
		
		for (Pizza pizza : p) {
			// If the pizza item in the object is equal to the given pizza o param, increase the count
			if (pizza.equals(o)) {
				count ++;
			}
		}
		
		return count;
		
	}
	
	
	public int groupAvg(Pizza[] a , String inputString) {
		
		int count = 0;
		int sum = 0;
		
		for (Pizza pizza : a) {
			String pizzaName = pizza.getPizzaName();
			
			if (pizzaName.equals(inputString)) {
				sum += pizza.getNumberOfPizza();
				count ++;
			}		
		}
		
		// No matching input strings
		if (count == 0) {
			return -1;
		}
		
		int average = sum/count;
		
		return average;
		
		}

	
	public Pizza[] lessThan( Pizza[] a, Integer i ) {
		ArrayList<Pizza> pizzasLessThanInputInt = new ArrayList<>();
		
		
		for (Pizza pizza : a) {
			int numbOfPizza = pizza.getNumberOfPizza();
			
			if (numbOfPizza < i) {
				pizzasLessThanInputInt.add(pizza);
			}
		}
		
		// Convert the arrayList to an array of pizza with the pizzasLessThanInputInt size
		Pizza[] arrayOfItemsLessThanInt = new Pizza[pizzasLessThanInputInt.size()];
		
		return arrayOfItemsLessThanInt;
		
	}


	public void groupEdit( Pizza[] a, String s, Integer n ) {
		for (Pizza pizza : a) {
			String pizzaName = pizza.getPizzaName();
			
			// If the pizza name equals to given string case insensitive, then add input n to existing number of pizza
			if (pizzaName.equalsIgnoreCase(s)) {
				Integer numberOfPizzas = pizza.getNumberOfPizza();
				
				pizza.setNumberOfPizza(numberOfPizzas+n);
			}
		}
	}
}
