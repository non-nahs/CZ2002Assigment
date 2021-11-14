package boundary;

import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

//import controller.MainMgr;
import controller.DisplayMgr;
import controller.ReservationMgr;

import entity.Customer;

/**
 * Boundary Class ReservatuionUI for user to interact with the reservation program.
 * 
 * @author Yeo Kai Liang, Jasper
 * @version 1.0
 * @since 2021-10-15
 */

public class ReservationUI {
	
 	/**
  	* Scanner object to register user's input. Input will affect how the program flows.
  	*/
	Scanner sc = new Scanner(System.in);
	
	/*
	/**
  	* displayMgr object used in reservationMenu method, to display appropriate messages
  	*/
	//DisplayMgr displayMgr = MainMenuUI.displayMgr;


	/**
	 * ReservationMgr object for this class to call upon user's input
	 */
	ReservationMgr reserveMgr = new ReservationMgr();
	
	/**
	 * display all options a user can choose to execute for reservation.
	 * Each option will be handled by the respective methods in ReservationMgr class
	 * The following options are:
	 * 1) view all reservations
	 * 2) check all table's occupied status
	 * 3) create a new reservation
	 *  	- This option will get all require the inputs (customerName, customerContact number, number of pax, booking time)
	 * 		- The inputs will be passed into a method by ReservationMgr createReservation()
	 * 4) remove a reservation
	 * 		- This option will get the require inputs (customerName, customerContact) to find the corresponding reservation
	 * 		- The inputs will be passed into the method by ReservationMgr removeReservation()
	 * 5) return back to main menu
	 */
	public void reservationMenu() {
		int choice;

		String cusName;
		int cusContact;
		int pax;
		String bookingString;
		LocalTime bookingTime;
		DateTimeFormatter dateFormat;

		System.out.println("----------------------------------");
		System.out.println("Please choose an option");
		System.out.println("1. View Reservations");
		System.out.println("2. Check Table Availability");
		System.out.println("3. Add Reservation");
		System.out.println("4. Remove Reservation");
		System.out.println("5. Return to main menu");
		System.out.println("----------------------------------");
		
		choice = sc.nextInt();
			switch (choice) {
				 case 1:  //get reservations from display mgr and prints it
				 	//displayMgr.getReservation();
					displayReservation();
				 break;
				 case 2:
					reserveMgr.checkTableAvail();
				 break;
				 case 3:  // adds reservation
				 	//displayMgr.addReservation();
					sc.nextLine();
					System.out.print("Enter name of customer: ");
					cusName = sc.nextLine();
					System.out.print("Enter contact of customer: ");
					cusContact = sc.nextInt();
					System.out.print("Enter number of pax: ");
					pax = sc.nextInt();
					sc.nextLine(); // "flush"
					System.out.print("Booking time (HH:mm): ");
					bookingString = sc.nextLine();
					dateFormat = DateTimeFormatter.ofPattern("HH:mm");
					bookingTime = LocalTime.parse(bookingString,dateFormat);
					reserveMgr.createReservation(cusName,cusContact,pax,bookingTime);
				 break;
				 
				 case 4: //removes reservation
				 	sc.nextLine(); // "flush"
					System.out.print("Enter customer's name: ");
					cusName = sc.nextLine();
					//sc.nextLine(); // "flush"
					System.out.print("Enter customer's contact number: ");
					cusContact = sc.nextInt();
	
					reserveMgr.removeReservation(cusName,cusContact);
				 	//displayMgr.removeReservation();
					
				break;
				case 5: //return to main menu
					System.out.println("Returning to main menu"); 
				break;
			}
		

	}

	/**
	 * display all reservation method for option 1 of reservationMenu
	 */
	public void displayReservation() {
		reserveMgr.viewReservation();
		System.out.println("Reservations Displayed!"); 
	}
}