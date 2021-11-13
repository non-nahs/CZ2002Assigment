package boundary;

import java.util.Scanner;
import java.util.ArrayList;
import controller.DisplayMgr;
import entity.*;

public class OrderUI {
	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	ItemsUI itemsUI = MainMenuUI.itemsUI;
	Order order = MainMenuUI.order;
	Menu menu = MainMenuUI.menu;

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
				 	removeOrder();
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
		order.viewOrder();
	}

	private void removeOrder() {
		ArrayList<MenuItem> tempMenuItems = menu.getMenuItems();
		MenuItem tempItem = new MenuItem();
		String name;
		int i = 0;

		System.out.println("----------------------------------");
		System.out.println("Please enter name of menu item");
		System.out.println("----------------------------------");
		sc.nextLine();
		name = sc.nextLine();

		while(i < tempMenuItems.size()) {
			tempItem = tempMenuItems.get(i);
			if (name.equals(tempItem.getName())) {
				order.removeItem(tempItem);
				System.out.println("Removed from order!");
				break;
			}
			i++;
		}
	}

}