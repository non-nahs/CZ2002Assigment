//Jasper edited 
package boundary;

import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

//import controller.MainMgr;
import controller.DisplayMgr;
import controller.ReservationMgr;

import entity.Customer;

public class ReservationUI {

	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	Customer cus = MainMenuUI.customer;  // a bit weird but wadevaaa
	ReservationMgr reserveMgr = new ReservationMgr();
	
	public void reservationMenu() {
		int choice;

		String cusName;
		int cusContact;
		int pax;
		String bookingString;
		LocalDate bookingDate;
		LocalTime bookingTime;
		DateTimeFormatter dateFormat;

		System.out.println("----------------------------------");
		System.out.println("Please choose an option");
		System.out.println("1. View Reservations");
		System.out.println("2. Add Reservation");
		System.out.println("3. Remove Reservation");
		System.out.println("4. Return to main menu");
		System.out.println("----------------------------------");
		
		choice = sc.nextInt();
			switch (choice) {
				 case 1:  //get reservations from display mgr and prints it
				 	displayMgr.getReservation();
					displayReservation();
				 break;

				 case 2:  // adds reservation
				 	displayMgr.addReservation();
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
				 
				 case 3: //removes reservation
				 	sc.nextLine(); // "flush"
					System.out.print("Enter customer's name: ");
					cusName = sc.nextLine();
					//7sc.nextLine(); // "flush"
					System.out.print("Enter customer's contact number: ");
					cusContact = sc.nextInt();
	
					reserveMgr.removeReservation(cusName,cusContact);
				 	displayMgr.removeReservation();
					
				break;
				case 4: //return to main menu
					System.out.println("Returning to main menu"); 
				break;
			}
		

	}

	public void displayReservation() {
		reserveMgr.viewReservation();
		System.out.println("Reservations Displayed!"); 
	}
}