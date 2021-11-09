package boundary;

import entity.Order;
import java.util.Scanner;

public class MainMenuUI {
	ItemsUI itemsUI = new ItemsUI();
	PromotionUI promoUI = new PromotionUI();
	OrderUI orderUI = new OrderUI();
	InvoiceUI invoiceUI = new InvoiceUI();
	ReservationUI reserveUI = new ReservationUI();
	SalesReportUI salesReportUI = new SalesReportUI();

	int choice;

	Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		// TODO - implement MainMenuUI.displayMenu
		do {
			System.out.println("Select a function to perform: ");
			System.out.println("1: Item menu");
			System.out.println("2: Promotion items menu");
			System.out.println("3: Order menu");
			System.out.println("4: Reservation menu");
			System.out.println("5: Print order invoice");
			System.out.println("6: Print sale revenue report");
			System.out.println("7: Quit");
			System.out.println("Enter the number of your choice: ");
			System.out.println();
			choice = sc.nextInt();
			switch (choice) {
				 case 1: itemsUI.displayItems();
				 break;
				 case 2: 
					 plane.showEmptySeats();
				 break;
				 case 3: 
					 plane.showAssignedSeats(true);
				 break;
				 case 4:
					 plane.showAssignedSeats(false);
				 break;
				 case 5:
					 int seatId, custId;
					 System.out.println("Assigning Seat...");
					 System.out.print("Please enter SeatID: ");
					 System.out.println();
					 seatId = sc.nextInt();
					 System.out.print("Please enter Customer ID: ");
					 System.out.println();
					 custId = sc.nextInt();
					 plane.assignSeat(seatId, custId);
				 break;
				 case 6:
					 int seatId2;
					 System.out.print("Enter SeatID to unassign customer from: ");
					 System.out.println();
					 seatId2 = sc.nextInt();
					 plane.unAssignSeat(seatId2);
				 break; 
				 case 7: System.out.println("Program terminating...");
			}
		} while (choice < 7);
		//throw new UnsupportedOperationException();
	}

}