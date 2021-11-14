package boundary;

import java.util.Scanner;
import entity.SalesRevenue;

/**
 * Represents a boundary class to get user input to perform methods related to sales report. 
 * @author Shannon Chieng
 * @version 1.0
 * @since 2021-10-15
 */
public class SalesReportUI {

	Scanner sc = new Scanner(System.in);
	
	/**
	 * Displays options user can choose in the menu.
	 * Gets user input.
	 * Display sales report based on user input. 
	 */
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

	/**
	 * Request user to input month.
	 * Get user's input. 
	 * Print requested month sales report. 
	 */
	private void printByMonth() {
		SalesRevenue salesRevenue = MainMenuUI.salesRevenue;
		System.out.println("Please enter month to view: (1-12)");
		int month = sc.nextInt();
		salesRevenue.printSalesReport(month, 0);
	}
	
	/**
	 * Request user to input month and day. Available day range changes based on selected month. 
	 * Get user's input. 
	 * Print requested day sales report. 
	 */
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