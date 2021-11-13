//DELETE CLASS

/**
 * Represents a customer that books a reservation and orders from the menu.
 * 
 * @author Yu Runhan
 * @version 1.0
 * @since 2021-10-15
 */

package entity;

public class Customer {

	private String name; //first name last name
	private boolean membership;
	private int phoneNumber;

	public Customer() {
		name = "John Smith";
		membership = true;
		phoneNumber = 123;
	}

	public Customer(String name, boolean member, int number){
		 this.name = name;
		 this.membership = member;
		 this.phoneNumber = number;
	}

	//getters
	public String getName(){
		return name;
	}
	public boolean getMembership() {
		return this.membership;
	}
	public int getPhoneNumber(){
		return phoneNumber;
	}

	//setters
	public void setName(String newName){
		name = newName;
	}
	public void setMembership(boolean newStatus) {
		this.membership = newStatus;
	}
	public void setPhoneNumber(int newNumber){
		this.phoneNumber = newNumber; 
	}



}