package boundary;

import java.util.ArrayList;
import java.util.Scanner;
import controller.DisplayMgr;
import controller.MainMgr;
import entity.Menu;
import entity.MenuItem;
import entity.Order;
import entity.SetPromotionPackage;
import java.io.FileWriter;
import java.time.*;

/**
 * Represents a boundary class to get user input to perform methods related to set promotion packages on the menu in the main menu.
 * @author Yu Runhan
 * @version 1.0
 * @since 2021-10-15
 */
public class PromotionUI {

	Scanner sc = new Scanner(System.in);
	
	//DisplayMgr displayMgr = MainMenuUI.displayMgr;

	/**
	 * The menu that this user interface will be using to get set promotion packages' information from.
	 */
	Menu menu = MainMenuUI.menu;

	/**
	 * The order that this user interface adds set promotion packages to.
	 * Each set promotion package from the menu can be added to this order.
	 */
	Order order = MainMenuUI.order;

	/**
	 * Displays the options a user can choose to do with set promotion packages in the menu.
	 * Gets the user's input option choice.
	 * The options are: 
	 * adding a set promotion package to the order, adding or removing a set promotion package to the menu, updating a set promotion package in the menu, and returning to the main menu display.
	 */
	public void promotionMenu() {
		// TODO - implement PromotionUI.displayPromotion
		//throw new UnsupportedOperationException();
		int choice;
		menu.printPromoMenu();
		System.out.println("----------------------------------");
		System.out.println("Please choose an option");
		System.out.println("1. Order a set");
		System.out.println("2. Add promotion set to menu");
		System.out.println("3. Remove promotion set from menu");
		System.out.println("4. Update promotion set in menu");
		System.out.println("5. Return to main menu");
		System.out.println("----------------------------------");

		choice = sc.nextInt();
			switch (choice) {
				 case 1:
					addToOrder();
					break;
				 case 2:  //add promotion set
				 sc.nextLine(); //flush
				 addPromoSet();
				 break;
				 case 3:  // remove promotion set
				 	rmPromoSet();
				 break;
				 case 4: 
				 	editPromoSet();
				 break;
				 case 5:
					System.out.println("Returning to main menu"); //return to main menu
				 break;
			}
	}

	/**
	 * Asks the user to input the name of the set promotion package to be added to the order.
	 * Adds the set promotion package with the given name to the order in main menu.
	 */
	private void addToOrder() {
		ArrayList<SetPromotionPackage> tempSetPackages = menu.getSetPackages();
		SetPromotionPackage tempSet = new SetPromotionPackage();
		String name;
		LocalDate orderDate;

		System.out.println("-------------------------------");
		System.out.println("Please enter name of the set");
		System.out.println("-------------------------------");
		sc.nextLine(); 
		name = sc.nextLine();

		for(int i=0; i<tempSetPackages.size(); i++){
			tempSet = tempSetPackages.get(i);
			if(name.equals(tempSet.getPromotionName())){
				order.addSet(tempSet);
				/*orderDate = LocalDate.now();
				try (FileWriter writer = new FileWriter(MainMgr.PATH, true)){;  //add to promoUI
					writer.write(orderDate + "\t" + "Set : " + tempSet.getPromotionName() + "\t" + tempSet.getPromotionPrice() + "\n");
					writer.flush();
					writer.close();
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}*/
				System.out.println("Added to order!");
			}
		}
	}

	/**
	 * Asks the user to input the details of a new set promotion package to be added to the menu in main menu.
	 * Adds the set promotion package with the given details from user input to the menu in main menu.
	 * The details the user inputs give are: 
	 * the name to be given to this new set promotion package,
	 * the price of this new set promotion package,
	 * the names of the ala-carte items in the menu to be contained in this set promotion package.
	 */
	private void addPromoSet() { //if add new item to the set, need to add it to alacarte items also
		String name;
		double price;
		ArrayList<MenuItem> setItems = new ArrayList<MenuItem>(); 

		System.out.println("---------------------------------");
		System.out.println("Please enter name of set package");
		System.out.println("---------------------------------");
		//sc.nextLine(); //!!!!!!!!!!!!!!!!!!!!!if come from editPromoSet, need enter 2 times!!
		name = sc.nextLine();

		System.out.println("---------------------------------");
		System.out.println("Please enter price of set package");
		System.out.println("---------------------------------");
		price = sc.nextDouble();

		int done = 0;
		MenuItem item;
		String itemName;
		while(done==0){ //if done==1, break out of loop and add whole set
			System.out.println("----------------------------------------------");
			System.out.println("Please enter the name of the item to be added");
			System.out.println("----------------------------------------------");
			sc.nextLine();
			itemName = sc.nextLine();
			boolean found = false;
			for(int i=0; i<menu.getMenuItems().size(); i++){
				if(itemName.equals(menu.getMenuItems().get(i).getName())){ //if itemName == name of the item
					found = true;
					item = menu.getMenuItems().get(i);
					setItems.add(item);
					System.out.println("Item added");
					break;
				}
			}

			 if(!found){
				System.out.println("Item not found!");
				return;
			}

			System.out.println("-----------------------------");
			System.out.println("Add more items? 0-yes 1-no");
			System.out.println("-----------------------------");
			done = sc.nextInt();
			
		} //when done == 1, not adding anymore items. exit loop

		SetPromotionPackage newSet = new SetPromotionPackage(name, price, setItems);
		menu.addSet(newSet);
		System.out.println(newSet.getPromotionName() + " set was added!");
		//displayMgr.addItem(newItem);
	}

	/**
	 * Asks for user input of the name of the set promotion package to be removed.
	 * Removes the set promotion package with the given name from the menu in main menu.
	 */
	private void rmPromoSet() { //remove whole set
		ArrayList<SetPromotionPackage> tempSetPackages = menu.getSetPackages();

		SetPromotionPackage tempSet = new SetPromotionPackage();
		String name;

		System.out.println("----------------------------------");
		System.out.println("Please enter name of the set");
		System.out.println("----------------------------------");
		sc.nextLine();
		name = sc.nextLine();

		for(int i=0; i<tempSetPackages.size(); i++){
			tempSet = tempSetPackages.get(i);
			if( name.equals(tempSet.getPromotionName()) ){
				menu.removeSet(tempSet);
				System.out.println(tempSet.getPromotionName() + " set was removed!");
				break;
			}
		}
	}

	/**
	 * Updates the promotion set with corresponding details received from user input.
	 * Asks for user input of the name of the set promotion package on the menu that is to be updated.
	 * Removes the set promotion package that matches the name given by user input.
	 * Adds a new set promotion package to the main menu with new details received from user input to replace the details of the removed set.
	 * The new details are the name of the set promotion package, price, and names of the ala-carte items to be contained in this set promotion package.
	 */
	private void editPromoSet() { //add and remove items in the package
		ArrayList<SetPromotionPackage> tempSetPackages = menu.getSetPackages(); 
		SetPromotionPackage tempSet = new SetPromotionPackage();
		String name;

		System.out.println("-----------------------------------------------");
		System.out.println("Please enter name of the set promotion package");
		System.out.println("-----------------------------------------------");
		sc.nextLine();
		name = sc.nextLine();

		for(int i=0; i<tempSetPackages.size(); i++){
			tempSet = tempSetPackages.get(i);
			if(name.equals(tempSet.getPromotionName())){
				menu.removeSet(tempSet);
				addPromoSet();
				System.out.println("Set was updated!");
				break;
			}
		}

	}

}