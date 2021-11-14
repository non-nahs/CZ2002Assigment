package boundary;

import entity.*;
import entity.MenuItem.Category;
import java.io.FileWriter;
import java.util.*;
import controller.MainMgr;
import java.time.*;

/**
 * Represents a boundary class to get user input to perform methods related to ala-carte items on the menu in main menu.
 * @author Shannon Chieng
 * @version 1.0
 * @since 2021-10-15
 */
public class ItemsUI {

	Scanner sc = new Scanner(System.in);
	//DisplayMgr displayMgr = MainMenuUI.displayMgr;

	/**
	 * The menu that this user interface will be using to get ala-carte menu items' information from.
	 */
	Menu menu = MainMenuUI.menu;

	/**
	 * The order that this user interface will add ala-carte menu items to.
	 * Each ala-carte item on the menu in main menu can be added to this order.
	 */
	Order order = MainMenuUI.order;

	/**
	 * Displays the options a user can choose to do with the ala-carte menu items.
	 * Gets the user's input option choice.
	 * The options are: 
	 * adding a ala-carte menu item to the order, adding or removing a ala-carte item from the menu, updating a ala-carte item in the menu, and returning to the main menu display.
	 */
	public void itemsMenu() {
		int choice;

		System.out.println("----------------------------------");
		menu.printAlaCarteMenu();
		//printMenu();
		System.out.println("----------------------------------");
		System.out.println("Please choose an option");
		System.out.println("1. Order item");
		System.out.println("2. Add item to menu");
		System.out.println("3. Edit menu item");
		System.out.println("4. Remove item from menu");
		System.out.println("5. Return to main menu");
		System.out.println("----------------------------------");

		choice = sc.nextInt();
			switch (choice) {
				case 1: //add item to order
					addToOrder();
					break;
				 case 2:  //add item
				 	addMenuItem();
				 break;
				 case 3:
				 	editMenuItem();
					 break;
				 case 4:  // remove item
				 	rmMenuItem();
				 break;
				 case 5: //return to main menu
				 	System.out.println("Returning to main menu"); 
				break;
			}
	}

	/**
	 * Updates the ala-carte item with corresponding details received from user input.
	 * Asks for user input of the name of the ala-carte item on the menu that is to be updated.
	 * Removes the ala-carte item that matches the name given by user input.
	 * Adds an ala-carte item to the main menu with new details received from user input to replace the details of the removed item.
	 * The new details are the category, name, description and price of the ala-carte menu item.
	 */
	private void editMenuItem() {
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
				menu.removeItem(tempItem);
				addMenuItem();
				System.out.println("Item was updated!");
				break;
			}
			i++;
		}
	}

	/**
	 * Asks the user to input the name of the ala-carte item to be added to the order.
	 * Adds the ala-carte item with the given name to the order in main menu.
	 */
	private void addToOrder() {
		ArrayList<MenuItem> tempMenuItems = menu.getMenuItems();
		MenuItem tempItem = new MenuItem();
		String name;
		int i = 0;

		System.out.println("----------------------------------");
		System.out.println("Please enter name of menu item");
		System.out.println("----------------------------------");
		sc.nextLine();
		name = sc.nextLine();

		while(i < tempMenuItems.size()) { //add time of order
			tempItem = tempMenuItems.get(i);
			if (name.equals(tempItem.getName())) {
				order.addItem(tempItem);
				
				/*try (FileWriter writer = new FileWriter(MainMgr.PATH, true)){;  //add to promoUI
					writer.write(orderDate + "\t" + "ALC : " + tempItem.getName() + "\t" + tempItem.getPrice() + "\n");
					writer.flush();
					writer.close();
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}*/
				System.out.println("Added to order!");
			}
			i++;
		}
	}

	// private void printMenu() {
	// 	menu.printAlaCarteMenu();
	// }

	/**
	 * Asks the user to input the details of a new ala-carte to be added to the menu in main menu.
	 * Adds an ala-carte item with the given details from user input to the menu in main menu.
	 * The details the user inputs give are: the category, name, description and price to be given to this new ala-carte item.
\	 */
	private void addMenuItem() {
		String name, desc;
		double price;
		Category cat = Category.MAIN_COURSE;
		int choice=0;

		System.out.println("----------------------------------");
		System.out.println("Please choose Category");
		System.out.println("1. Main Course");
		System.out.println("2. Drink");
		System.out.println("3. Dessert");
		System.out.println("----------------------------------");
		choice = sc.nextInt();

		switch(choice) {
			case 1: cat = Category.MAIN_COURSE;
			break;
			case 2: cat = Category.DRINK;
			break;
			case 3: cat = Category.DESSERT;
			break;
		}

		System.out.println("----------------------------------");
		System.out.println("Please enter name of menu item");
		System.out.println("----------------------------------");
		sc.nextLine();
		name = sc.nextLine();

		System.out.println("----------------------------------");
		System.out.println("Please enter description of menu item");
		System.out.println("----------------------------------");
		desc = sc.nextLine();

		System.out.println("----------------------------------");
		System.out.println("Please enter price of menu item");
		System.out.println("----------------------------------");
		price = sc.nextDouble();

		MenuItem newItem = new MenuItem(cat, name, desc, price);
		menu.addItem(newItem);
		//displayMgr.addItem(newItem);
	}

	/**
	 * Asks for user input of the name of the ala-carte item to be removed.
	 * Removes the ala-carte item with the given name from the menu in main menu.
	 * Removes any set promotion packages that contains the removed ala-carte item.
	 */
	private void rmMenuItem() {
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
				menu.removeItem(tempItem);
				System.out.println("Item was removed!");
				break;
			}
			i++;
		}

	}
}