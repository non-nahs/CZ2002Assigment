package controller;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import entity.Reservation;
import boundary.MainMenuUI;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservationMgr {


	// to be dump somewhere later if there is time
	// this is an arrayList to store all reservations
	public ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	public LocalTime openingHours = LocalTime.parse("10:00",DateTimeFormatter.ofPattern(("HH:mm")));
	public LocalTime closingHours = LocalTime.parse("22:00",DateTimeFormatter.ofPattern(("HH:mm")));
	Scanner sc = new Scanner(System.in);


	public void createReservation(String cusName,int cusContact, int pax, LocalTime bookingTime){
		int failReserve = -1;
		for(int i =0 ; i < reservationList.size(); i++){
			if(cusName == reservationList.get(i).getCusName() && cusContact == reservationList.get(i).getCusContact()){
				failReserve = 1;
				break;
			}
		}
		if(failReserve == 1){
			System.out.print("Customer already has a booking reservation.");
		}
		else{
			if(pax > 12 || pax < 1){
				System.out.print("Sorry we cannot book the amount of people.");
			}
			else{
				if(bookingTime.isAfter(closingHours) || bookingTime.isBefore(openingHours)){ // outside operating hours
					System.out.print("Sorry we are closed");
				}
				else{
					if(testBook(pax)== -1){ //if booktest fail
						System.out.print("Sorry there are no slots for booking at the momement.");
					}
					else{
						reservationList.add(new Reservation(cusName,cusContact,pax,bookingTime,MainMenuUI.table.get(testBook(pax))));
						System.out.print("Reservation booked successfully");
					}
				}
			}
		}

	}

	public void viewReservation() {
		//remove expired
		clearExpiry();

		System.out.println("Time \t\t CustomerName \t\t CustomerContact \t Pax \t TableID");
		if(reservationList.size()<=0){
			System.out.println("No reservation records found.");
		}
		for(int i = 0; i < reservationList.size();i++){
			reservationList.get(i).viewReservation();
		}
	}

	private void clearExpiry() {
		// basically this method del array entries that pass expired date
		for(int i = 0; i < reservationList.size();i++){
			//System.out.println("the  date now is " + LocalDate.now());
			//System.out.println("the time  now is " + LocalTime.now());
			//System.out.println("the diff is " + Duration.between(LocalTime.now(), reservationList.get(i).getBookingTime()).toMinutes());
			// assume reservation last for 15mins pass booking hour
			if(reservationList.get(i).getBookingTime().plus(Duration.of(15,ChronoUnit.MINUTES)).isBefore(LocalTime.now())){
				reservationList.remove(i);
			}
		}
	}

	/*
	public boolean checkTableAvail(int index) { 
		// see table available or not
		//for (int i = 0; i < MainMenuUI.table.size(); i++){
			
		//}
		//return MainMenuUI.table.getTableStatus();
	}
	*/
	public int testBook(int pax ){ // purpose is to return a tableID if table is found
		int tableID = -1;
		for(int i = 0; i <  MainMenuUI.table.size();i++){
			if(!MainMenuUI.table.get(i).getTableStatus()){ //if table is not occupied
				if(pax <= MainMenuUI.table.get(i).getSeatCapacity()){
					tableID = i;
					break;
				}
			}
		}
		return tableID;
	}
	

	public void removeReservation(String cusName, int cusContact) {
		int removed = -1;
		for(int i = 0; i<reservationList.size();i++){
			System.out.print("cusName: " + cusName);
			System.out.print("cusContaact" + cusContact);
			if(cusContact == reservationList.get(i).getCusContact() && cusName.equals(reservationList.get(i).getCusName())){
				reservationList.remove(i);
				removed = 1;
				break;
			}
		}

		if(removed == -1){
			System.out.print("Reservation removed unsuccessfully.");
		}
		else{
			System.out.print("Reservation removed successfully.");
		}

	}
	
}