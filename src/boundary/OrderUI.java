package boundary;

import java.util.Scanner;
import java.util.ArrayList;
import entity.*;

/**
 * Represents a boundary class to get user input to perform methods related to the order. 
 * @author Shannon Chieng
 * @version 1.0
 * @since 2021-10-15
 */
public class OrderUI {
	Scanner sc = new Scanner(System.in);
	ItemsUI itemsUI = MainMenuUI.itemsUI;

	Order order = MainMenuUI.order;
	SetPromotionPackage setPromo = MainMenuUI.setPromo;
	Menu menu = MainMenuUI.menu;

	/**
	 * Displays opetions a user can choose to do with an order.
	 * Gets user input. 
	 */
	public void orderMenu() {
		int choice;

		System.out.println("----------------------------------");
		System.out.println("Current orders:");
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
					InvoiceUI invoiceUI = MainMenuUI.invoiceUI;
					System.out.println("Printing invoice..."); 
					invoiceUI.printInvoice();
				break;
				case 4: 
					System.out.println("Returning to main menu"); //return to main menu
				break;
			}
	}

	/**
	 * Prints all the a la carte items and promotion sets currently in the order. 
	 */
	private void printOrder() {
		ArrayList<MenuItem> tempMenuItems = order.getOrder();
		ArrayList<SetPromotionPackage> tempSetPromo = order.getSetOrder();
		
		for (MenuItem m : tempMenuItems)
			System.out.println(m.getName() + "\t" + m.getPrice());
		for (SetPromotionPackage set : tempSetPromo)
			System.out.println(set.getPromotionName() + "\t" + set.getPromotionPrice());
	}

	/**
	 * Remove a menuItem or promotion set from the current order.
	 */
	private void removeOrder() {
		ArrayList<MenuItem> tempMenuItems = menu.getMenuItems();
		ArrayList<SetPromotionPackage> tempSetPromoList = menu.getSetPackages();
		MenuItem tempItem = new MenuItem();
		SetPromotionPackage tempSetPromo = new SetPromotionPackage();

		String name;
		int i = 0;

		System.out.println("----------------------------------");
		System.out.println("Please enter name of Menu Item or Set Promotion.");
		System.out.println("----------------------------------");
		sc.nextLine();
		name = sc.nextLine();

		while(i < tempMenuItems.size()) {
			tempItem = tempMenuItems.get(i);
			if (name.equals(tempItem.getName())) {
				order.removeItem(tempItem);
				System.out.println("Removed "+ name + " from order!");
				break;
			}
			i++;
		}
		i=0;
		while(i < tempSetPromoList.size()) {
			tempSetPromo = tempSetPromoList.get(i);
			if (name.equals(tempSetPromo.getPromotionName())) {
				order.removeSet(tempSetPromo);
				System.out.println("Removed "+ name + " from order!");
				break;
			}
			i++;
		}
	}

}