package boundary;

import java.util.Scanner;
import controller.DisplayMgr;

public class ReservationUI {

	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	
	public void reservationMenu() {
		int choice;

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
				 break;
				 case 3: //removes reservation
				 	displayMgr.removeReservation();
				break;
				case 4: //return to main menu
					System.out.println("Returning to main menu"); 
				break;
			}
		

	}

	public void displayReservation() {
		// TODO - implement ReservationUI.displayReservation
		//throw new UnsupportedOperationException();
		System.out.println("Reservations Displayed!"); 
	}
}