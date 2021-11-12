package boundary;

import java.util.Scanner;
import controller.DisplayMgr;

public class SalesReportUI {

	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	
	public void printSaleReport() {
		int choice;

		System.out.println("----------------------------------");
		System.out.println("Please choose an option");
		System.out.println("1. View Sales Report by Month");
		System.out.println("2. View Sales Report by Day");
		System.out.println("3. Return to main menu");
		System.out.println("----------------------------------");

		choice = sc.nextInt();
			switch (choice) {
				 case 1:  //get reservations from display mgr and prints it
				 	printByMonth();
				 break;
				 case 2:  // adds reservation
				 	printByDay();
				 break;
				 case 3: //removes reservation
				 System.out.println("Returning to main menu"); 
				break;
			}
	}

	private void printByMonth() {
		System.out.println("Printing by month...");
		displayMgr.getSalesReport();
	}

	private void printByDay() {
		System.out.println("Printing by day...");
		displayMgr.getSalesReport();
	}
}