package boundary;

import entity.*;
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
				 	displayMgr.addItem();
				 break;
				 case 2:  // remove item
				 	displayMgr.removeItem();
				 break;
				 case 3: 
				 	System.out.println("Returning to main menu"); //return to main menu
				break;
			}
	}

	private void printMenu() {
		menu.printMenu();
	}
}