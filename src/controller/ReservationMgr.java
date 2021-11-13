package controller;

import java.time.*;
import java.time.temporal.ChronoUnit;

import entity.Customer;
import entity.Reservation;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservationMgr {


	// to be dump somewhere later if there is time
	// this is an arrayList to store all reservations
	public ArrayList<Reservation> reservationList = new ArrayList<Reservation>();


	Scanner sc = new Scanner(System.in);


	//public void createReservation() {
		//return new Reservation();
	//}
	public void createReservation(Customer cus, int pax, LocalDate bookingDate,LocalTime bookingTime){
		reservationList.add(new Reservation(cus,pax,bookingDate,bookingTime));

	}

	public void viewReservation() {
		//remove expired
		clearExpiry();

		System.out.println("Date \t\t Time \t\t CustomerName \t\t CustomerContact \t\t Pax");
		for(int i = 0; i < reservationList.size();i++){
			reservationList.get(i).viewReservation();
		}
	}

	public void removeReservation() {
		// TODO - implement ReservationMgr.removeReservation
		throw new UnsupportedOperationException();
	}

	private void clearExpiry() {
		// basically this method del array entries that pass expired date
		for(int i = 0; i < reservationList.size();i++){
			System.out.println("the  date now is " + LocalDate.now());
			System.out.println("the time  now is " + LocalTime.now());
			if(reservationList.get(i).getBookingDate().isBefore(LocalDate.now()) || reservationList.get(i).getBookingDate().isEqual(LocalDate.now()) ){
				if(reservationList.get(i).getBookingTime().plus(Duration.of(15,ChronoUnit.MINUTES)).isBefore(LocalTime.now())){
					reservationList.remove(i);
				}
			}
		}
	}

	public void checkTableAvail() {
		// TODO - implement ReservationMgr.checkTableAvail
		throw new UnsupportedOperationException();
	}

}