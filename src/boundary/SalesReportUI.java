package boundary;

import java.util.Scanner;
import entity.SalesRevenue;

public class SalesReportUI {

	Scanner sc = new Scanner(System.in);
	
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
		SalesRevenue salesRevenue = MainMenuUI.salesRevenue;
		System.out.println("Please enter month to view: (1-12)");
		int month = sc.nextInt();
		salesRevenue.printSalesReport(month, 0);
	}

	private void printByDay() {
		SalesRevenue salesRevenue = MainMenuUI.salesRevenue;
		System.out.println("Please enter month to view: (1-12)");
		int month = sc.nextInt();
		int day=0;
		if (month == 2) {
			System.out.println("Please enter day to view: (1-28)");
			day = sc.nextInt();
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Please enter day to view: (1-30)");
			day = sc.nextInt();
		}
		else {
			System.out.println("Please enter day to view: (1-31)");
			day = sc.nextInt();
		}
		salesRevenue.printSalesReport(month, day);
	}
}