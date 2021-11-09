package entity;
//runhan
public class Customer {

	private String name; //first name last name
	private boolean membership;
	private int phoneNumber;

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