package controller;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import entity.Reservation;
import boundary.MainMenuUI;

import java.util.ArrayList;
import java.util.Scanner;



/**
 * Controller Class to control the flow of Reservation entity class.
 * 
 * @author Yeo Kai Liang, Jasper
 * @version 1.0
 * @since 2021-10-15
 */

public class ReservationMgr {
	Scanner sc = new Scanner(System.in);

	/**
	 * This is an ArrayList of Reservation to store all reservations created.
	 */
	public ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	/**
	 * This is the opening hours of the restaurant.
	 */
	public LocalTime openingHours = LocalTime.parse("10:00",DateTimeFormatter.ofPattern(("HH:mm")));
	/**
	 * This is the closing hours of the restaurant.
	 */
	public LocalTime closingHours = LocalTime.parse("22:00",DateTimeFormatter.ofPattern(("HH:mm")));
	

	/**
	 * This is the logic that ReservationMgr will flow when trying to create a new Reservation.
	 * 
	 * The method logic will check for the following conditions before creating a reservation:
	 * Check if this customer has already made a reservation or not.
	 * Check if this customer is not trying to reserve for lesser than 1 or more than 12 people
	 * Check if this customer is not trying to reserve before opening hours or after closing hours
	 * Check if there are any available tables for this customer to make a reservation
	 * 
	 * @param cusName		This is the customer's name trying to create a reservation
	 * @param cusContact	This is the customer's contact trying to create a reservation
	 * @param pax			This is the number of people customer is booking for
	 * @param bookingTime	This is the expected arrival time of customer reaching the restaurant
	 */
	public void createReservation(String cusName,int cusContact, int pax, LocalTime bookingTime){
		int failReserve = -1;
		for(int i =0 ; i < reservationList.size(); i++){
			if(cusName == reservationList.get(i).getCusName() && cusContact == reservationList.get(i).getCusContact()){
				failReserve = 1;
				break;
			}
		}
		if(failReserve == 1){
			System.out.println("Customer already has a booking reservation.");
		}
		else{
			if(pax > 12 || pax < 1){
				System.out.println("Sorry we cannot book the amount of people.");
			}
			else{
				if(bookingTime.isAfter(closingHours) || bookingTime.isBefore(openingHours)){ // outside operating hours
					System.out.println("Sorry we are closed");
				}
				else{
					if(testBook(pax)== -1){ //if booktest fail
						System.out.println("Sorry there are no slots for booking at the momement.");
					}
					else{
						reservationList.add(new Reservation(cusName,cusContact,pax,bookingTime,MainMenuUI.table.get(testBook(pax))));
						MainMenuUI.table.get(testBook(pax)).bookTable();
						System.out.println("Reservation booked successfully");
					}
				}
			}
		}

		clearExpiry();

	}
	/**
 	* Displays all the reservations that are made. 
	* Reservations that are past 15min of current time will be deleted first via clearExpiry() method.
 	*/
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

	/**
	 * Check against all reservations made and remove all reservations that are past 15mins of expected arrival time.
	 */

	 ///// need to test if can clear back to back
	private void clearExpiry() {
		int i = 0;
		while (i<reservationList.size()){
			//System.out.println("reservation siz now " + reservationList.size());
			if(reservationList.get(i).getBookingTime().plus(Duration.of(15,ChronoUnit.MINUTES)).isBefore(LocalTime.now())){
				reservationList.get(i).getTable().releaseTable();
				reservationList.remove(i);
			}
			else{
				i++;
			}
		}
	}

	/**
	 * Display all tables' information that are:
	 * table number
	 * table seat capacity
	 * table occupied status (display Occupied if true, else display Unoccupied if false)
	 * 
	 */
	public void checkTableAvail() { 
		clearExpiry();
		System.out.println("TableNo. \t TableCapacity \t TableStatus");
		for (int i = 0; i < MainMenuUI.table.size(); i++){
			System.out.print(MainMenuUI.table.get(i).getTableID() + "\t\t");
			System.out.print(MainMenuUI.table.get(i).getSeatCapacity() + "\t\t");
			if(MainMenuUI.table.get(i).getTableStatus()){
				System.out.print("Occupied" + "\n");
			}
			else{
				System.out.print("Unoccupied" + "\n");
			}
			
		}
	}

	/**
	 * This method will run through all the table to check for the best possible table available to accomodate for customer.
	 * Method will try to fit customer with the exact same table seat capacity.
	 * Method will assign customer to the next possible table if exact seat capacity tables are fully booked.
	 * @param pax		This is the number of people customer is reserving the table for.
	 * @return tableID	This returns the index from the ArrayList of tables created. (return -1 if no tables are available)
	 */
	public int testBook(int pax ){ // purpose is to return a tableID if table is found
		int tableID = -1;
		//remove expired

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
	

	/**
	 * This method will manually remove a reservation and set the table's occupied status to false if requested from UI.
	 * This method will require user to key in both customer's name and customer's number to delete the reservation.
	 * @param cusName		This is the customer's name of the targeted reservation
	 * @param cusContact	This is the customer's contact number of the targeted reservation
	 */
	public void removeReservation(String cusName, int cusContact) {
		clearExpiry();
		int removed = -1;
		for(int i = 0; i<reservationList.size();i++){
			if(cusContact == reservationList.get(i).getCusContact() && cusName.equals(reservationList.get(i).getCusName())){
				reservationList.get(i).getTable().releaseTable();
				reservationList.remove(i);
				removed = 1;
				break;
			}
		}

		if(removed == -1){
			System.out.println("Reservation removed unsuccessfully.");
		}
		else{
			System.out.println("Reservation removed successfully.");
		}

	}
	
}