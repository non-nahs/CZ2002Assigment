package entity;

import java.util.*;
import java.time.*;

import entity.Customer;

public class Reservation {

	//private String bookingName; // change to Customer
	//private int contact;
	private Customer bookCustomer;
	private int pax;
	private LocalDate bookingTime;
	//private LocalDate bookingExpiry;   ///// REMOVED THIS Date as controller class can prolly derieve

	public Reservation(Customer bC, int p, int c, LocalDate bT){
		this.bookCustomer = bC;
		this.pax = p;
		//this.contact = c;
		this.bookingTime = bT;
	}
	/*
	public void newReservation() { // useless, change to constructor 
		// TODO - implement Reservation.newReservation
		throw new UnsupportedOperationException();
	}
	*/

	public void editReservation() {
		// TODO - implement Reservation.editReservation
		throw new UnsupportedOperationException();
	}

	public void viewReservation() {
		// TODO - implement Reservation.viewReservation
		throw new UnsupportedOperationException();
		System.out.println("Table reservation for:\n" + this.bookCustomer.getName()); /////////////
		System.out.println("Customer contact:\n" + this.bookCustomer.getPhoneNumber());
		System.out.println("No. of pax:\n" + this.pax);
	}

	public void removeReservation() {
		// TODO - implement Reservation.removeReservation
		throw new UnsupportedOperationException();
	}

}