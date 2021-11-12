package boundary;

import entity.*;
import entity.MenuItem.Category;

import java.util.*;
import controller.DisplayMgr;
import controller.MainMgr;

public class ItemsUI {

	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	Menu menu = MainMenuUI.menu;

	public void itemsMenu() {
		int choice;

		System.out.println("----------------------------------");
		printMenu();
		System.out.println("----------------------------------");
		System.out.println("Please choose an option");
		System.out.println("1. Add item to menu");
		System.out.println("2. Remove item from menu");
		System.out.println("3. Return to main menu");
		System.out.println("----------------------------------");

		choice = sc.nextInt();
			switch (choice) {
				 case 1:  //add item
				 	addMenuItem();
				 break;
				 case 2:  // remove item
				 	rmMenuItem();
				 break;
				 case 3: //return to main menu
				 	System.out.println("Returning to main menu"); 
				break;
			}
	}

	private void printMenu() {
		menu.printMenu();
	}

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

	private void rmMenuItem() {
		/*ArrayList<MenuItem> tempMenuItems = menu.getMenuItems();
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
		}*/

	}
}