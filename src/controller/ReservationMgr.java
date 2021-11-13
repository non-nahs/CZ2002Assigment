package controller;

import java.time.*;
import java.time.temporal.ChronoUnit;

import entity.Customer;
import entity.Reservation;
import boundary.MainMenuUI;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservationMgr {


	// to be dump somewhere later if there is time
	// this is an arrayList to store all reservations
	public ArrayList<Reservation> reservationList = new ArrayList<Reservation>();


	Scanner sc = new Scanner(System.in);


	public void createReservation(Customer cus, int pax, LocalDate bookingDate,LocalTime bookingTime){
		reservationList.add(new Reservation(cus,pax,bookingDate,bookingTime));

	}

	public void viewReservation() {
		//remove expired
		clearExpiry();
		assignTable();
		
		System.out.println("Date \t\t Time \t\t CustomerName \t\t CustomerContact \t\t Pax \t\t TableID");
		for(int i = 0; i < reservationList.size();i++){
			reservationList.get(i).viewReservation();
		}
	}

	private void clearExpiry() {
		// basically this method del array entries that pass expired date
		for(int i = 0; i < reservationList.size();i++){
			System.out.println("the  date now is " + LocalDate.now());
			System.out.println("the time  now is " + LocalTime.now());
			System.out.println("the diff is " + Duration.between(LocalTime.now(), reservationList.get(i).getBookingTime()).toMinutes());
			if(reservationList.get(i).getBookingDate().isBefore(LocalDate.now()) || reservationList.get(i).getBookingDate().isEqual(LocalDate.now()) ){
				if(reservationList.get(i).getBookingTime().plus(Duration.of(15,ChronoUnit.MINUTES)).isBefore(LocalTime.now())){
					reservationList.remove(i);
				}
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

	
	public void assignTable(){
		for(int i = 0; i < reservationList.size();i++){
			if(reservationList.get(i).getBookingDate().isEqual(LocalDate.now())){
				if(Duration.between(reservationList.get(i).getBookingTime(),LocalTime.now()).toMinutes() <=60){
					for(int j = 0; j < MainMenuUI.table.size();j++){
						if(!MainMenuUI.table.get(j).getTableStatus()){
							if(reservationList.get(i).getPax() <= MainMenuUI.table.get(j).getSeatCapacity()){
								MainMenuUI.table.get(j).bookTable();
								reservationList.get(i).assginedTable(MainMenuUI.table.get(j));
								break;
							}
						}
					}
				} 
			}
		}
	}

	public void removeReservation(int contact, LocalDate bookingDate) {
		for(int i = 0; i<reservationList.size();i++){
			if(contact == reservationList.get(i).getCustomer().getPhoneNumber() && bookingDate == reservationList.get(i).getBookingDate()){
				reservationList.remove(i);
			}
		}
	}
	
}