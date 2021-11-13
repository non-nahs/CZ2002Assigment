// no man's repsonsiblity :X
package entity;

import java.util.*;
import java.time.*;


public class Reservation {

	//private String bookingName; // change to Customer
	//private int contact;
	private Customer bookCustomer;
	private int pax;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	private Table customerTable;
	//private LocalDate bookingExpiry;   ///// REMOVED THIS Date as controller class can prolly derieve

	public Reservation(Customer bC, int p, LocalDate bD, LocalTime bT){
		this.bookCustomer = bC;
		this.pax = p;
		this.bookingDate = bD;
		this.bookingTime = bT;
		this.customerTable = null;
	}

	public Customer getCustomer(){
		return this.bookCustomer;
	}
	public int getPax(){
		return this.pax;
	}
	public LocalDate getBookingDate(){
		return this.bookingDate;
	}

	public LocalTime getBookingTime(){
		return this.bookingTime;
	}

	public void editReservation() {
		// TODO - implement Reservation.editReservation
		throw new UnsupportedOperationException();
	}

	public void viewReservation() {
		//do formatting later
		System.out.print(this.bookingDate + " \t\t ");
		System.out.print(this.bookingTime + " \t\t ");
		System.out.print(this.bookCustomer.getName()+ " \t\t ");
		System.out.print(this.bookCustomer.getPhoneNumber() + " \t\t ");
		System.out.print(this.pax + " \t\t ");
		if(this.customerTable != null){
			System.out.print(this.customerTable.getTableID());
		}
		else{
			System.out.print("  ");
		}
		System.out.print("\n");
	}

	public void assginedTable(Table table){
		this.customerTable = table;
	}

	public Table getTable(){
		return this.customerTable;
	}


	public void removeReservation() {
		// TODO - implement Reservation.removeReservation
		throw new UnsupportedOperationException();
	}

}