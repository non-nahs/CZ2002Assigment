package boundary;

import java.util.Scanner;
import controller.DisplayMgr;

public class OrderUI {
	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	ItemsUI itemsUI = MainMenuUI.itemsUI;

	public void orderMenu() {
		// TODO - implement OrderUI.displayOrder
		//throw new UnsupportedOperationException();
		int choice;

		System.out.println("----------------------------------");
		printOrder();
		System.out.println("----------------------------------");
		System.out.println("Please choose an option");
		System.out.println("1. Continue ordering"); 
		System.out.println("2. Remove item from order");
		System.out.println("3. Checkout");
		System.out.println("4. Return to main menu");
		System.out.println("----------------------------------");
		
		choice = sc.nextInt();
			switch (choice) {
				 case 1:  //continue order, return to menu
					itemsUI.itemsMenu();
				 break;
				 case 2:  // remove item from order
				 	displayMgr.removeOrderItem();
				 break;
				 case 3: //prints and calls order invoice
					System.out.println("Printing invoice..."); 
					displayMgr.getInvoice();
				break;
				case 4: 
					System.out.println("Returning to main menu"); //return to main menu
				break;
			}
	}

	public void editOrder() {
		// TODO - implement OrderUI.editOrder
		//throw new UnsupportedOperationException();
	}

	private void printOrder() {
		System.out.println("This is the order");
	}

}