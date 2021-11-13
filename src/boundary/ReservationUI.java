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

		int pax;
		int contact;
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
					System.out.print("Enter number of pax: ");
					pax = sc.nextInt();
					System.out.print("Booking date (dd//MM/yy): ");
					sc.nextLine(); // "flush"
					bookingString = sc.nextLine();
					dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
					bookingDate = LocalDate.parse(bookingString, dateFormat);
					System.out.print("Booking time (HH:mm): ");
					bookingString = sc.nextLine();
					//bookingString = sc.nextLine();
					dateFormat = DateTimeFormatter.ofPattern("HH:mm");
					bookingTime = LocalTime.parse(bookingString,dateFormat);

					//need to find a way to prevnt user from booking same timeslot 
					reserveMgr.createReservation(cus,pax,bookingDate,bookingTime);


				 break;
				 case 3: //removes reservation
				 	System.out.print("Enter customer's contact number: ");
					contact = sc.nextInt();
					System.out.print("Enter customer's booking date (dd/MM/yy): ");
					sc.nextLine(); // "flush"
					bookingString = sc.nextLine();
					dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
					bookingDate = LocalDate.parse(bookingString, dateFormat);
					
					reserveMgr.removeReservation(contact,bookingDate);
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