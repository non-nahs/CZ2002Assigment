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
	//private LocalDate bookingExpiry;   ///// REMOVED THIS Date as controller class can prolly derieve

	public Reservation(Customer bC, int p, LocalDate bD, LocalTime bT){
		this.bookCustomer = bC;
		this.pax = p;
		this.bookingDate = bD;
		this.bookingTime = bT;
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
		System.out.println(this.bookingDate + " \t\t "
		+ this.bookingTime + " \t\t "
		+ this.bookCustomer.getName() + " \t\t "
		+ this.bookCustomer.getPhoneNumber() + " \t\t "
		+ this.pax);

		/*
		System.out.println("Table reservation for:\n" + this.bookCustomer.getName()); /////////////
		System.out.println("Customer contact:\n" + this.bookCustomer.getPhoneNumber());
		System.out.println("No. of pax:\n" + this.pax);
		*/
	}

	public void removeReservation() {
		// TODO - implement Reservation.removeReservation
		throw new UnsupportedOperationException();
	}

}