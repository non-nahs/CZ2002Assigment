// no man's repsonsiblity :X
package entity;

import java.time.*;


public class Reservation {

	//private String bookingName; // change to Customer
	//private int contact;
	private String cusName;
	private int cusContact;
	private int pax;
	private LocalTime bookingTime;
	private Table customerTable;

	public Reservation(String cusName, int cusContact, int p, LocalTime bT, Table table){
		this.cusName = cusName;
		this.cusContact = cusContact;
		this.pax = p;
		this.bookingTime = bT;
		this.customerTable = table;
	}

	public String getCusName(){
		return this.cusName;
	}
	public int getCusContact(){
		return this.cusContact;
	}
	public int getPax(){
		return this.pax;
	}

	public LocalTime getBookingTime(){
		return this.bookingTime;
	}


	public void viewReservation() {
		//do formatting later
		System.out.print(this.bookingTime + " \t\t ");
		System.out.print(this.getCusName()+ " \t\t ");
		System.out.print(this.getCusContact() + " \t\t\t ");
		System.out.print(this.pax + " \t ");
		System.out.print(this.customerTable.getTableID());
		System.out.print("\n");
	}

	public void assginedTable(Table table){
		this.customerTable = table;
	}

	public Table getTable(){
		return this.customerTable;
	}

}