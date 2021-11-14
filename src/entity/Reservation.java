package entity;
import java.time.*;

/**
 * Represents a reservation in a reservation list.
 * A reservation holds a table object.
 * @author Yeo Kai Liang, Jasper
 * @version 1.0
 * @since 2021-10-15
 */


public class Reservation {

	/**
	 * The full name of customer
	 */
	private String cusName;
	/**
	 * The contact number of customer
	 */
	private int cusContact;
	/**
	 * The reservation of number of people for 1 table
	 */
	private int pax;
	/**
	 * The expected arrival time of customer
	 */
	private LocalTime bookingTime;
	/**
	 * The table reserved for customer
	 */
	private Table customerTable;


	/**
	 * Creates a new Reservation with the  given:
	 * customer name, customer contact number, number of people, reservation time, reserved table.
	 * The customer name can inlcude both first and last name, or either of them.
	 * @param cusName		This is customer name
	 * @param cusContact	This is customer contact
	 * @param p				This is number of people (pax)
	 * @param bT			This is reservation time slot
	 * @param table			This is table object reserved for customer
	 * 
	 */
	public Reservation(String cusName, int cusContact, int pax, LocalTime bT, Table table){
		this.cusName = cusName;
		this.cusContact = cusContact;
		this.pax = pax;
		this.bookingTime = bT;
		this.customerTable = table;
	}

	/**
	 * Gets the name of this customer.
	 * @return this customer's name
	 */
	public String getCusName(){
		return this.cusName;
	}
	/**
	 * Gets the contact number of this customer.
	 * @return this customer's contact number
	 */
	public int getCusContact(){
		return this.cusContact;
	}
	/**
	 * Gets the number of people reserving for a table
	 * @return this customer's head count
	 */
	public int getPax(){
		return this.pax;
	}

	/**
	 * Gets the customer's expected arrival time.
	 * @return this customer's expected arrival time
	 */
	public LocalTime getBookingTime(){
		return this.bookingTime;
	}
	/**
	 * Gets the table reserved for this Customer.
	 * @return the table object reserved for this customer
	 */
	public Table getTable(){
		return this.customerTable;
	}

	/**
	 * Display this reservation details
	 */
	public void viewReservation() {
		//do formatting later
		System.out.print(this.bookingTime + " \t\t ");
		System.out.print(this.getCusName()+ " \t\t ");
		System.out.print(this.getCusContact() + " \t\t\t ");
		System.out.print(this.pax + " \t ");
		System.out.print(this.customerTable.getTableID());
		System.out.print("\n");
	}

}