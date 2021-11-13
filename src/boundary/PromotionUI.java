package boundary;

import java.util.ArrayList;
import java.util.Scanner;
import controller.DisplayMgr;
import entity.Menu;
import entity.MenuItem;
import entity.Order;
import entity.SetPromotionPackage;

public class PromotionUI {

	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	Menu menu = MainMenuUI.menu;
	Order order = MainMenuUI.order;

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
				 case 2:  //add promotion set
				 	addPromoSet();
				 break;
				 case 3:  // remove promotion set
				 	rmPromoSet();;
				 break;
				 case 4: 
				 	editPromoSet();;
				 break;
				 case 5:
					System.out.println("Returning to main menu"); //return to main menu
				 break;
			}
	}

	private void addToOrder() {
		ArrayList<SetPromotionPackage> tempSetPackages = menu.getSetPackages();
		SetPromotionPackage tempSet = new SetPromotionPackage();
		String name;

		System.out.println("-------------------------------");
		System.out.println("Please enter name of the set");
		System.out.println("-------------------------------");
		sc.nextLine();
		name = sc.nextLine();

		for(int i=0; i<tempSetPackages.size(); i++){
			tempSet = tempSetPackages.get(i);
			if(name.equals(tempSet.getPromotionName())){
				order.addSet(tempSet);;
				System.out.println("Added to order!");
			}
		}
	}

	private void addPromoSet() { //add a whole set //need to call it in displayMgr
		String name;
		double price;
		ArrayList<MenuItem> setItems = new ArrayList<MenuItem>(); 

		System.out.println("---------------------------------");
		System.out.println("Please enter name of set package");
		System.out.println("---------------------------------");
		sc.nextLine();
		name = sc.nextLine();

		System.out.println("---------------------------------");
		System.out.println("Please enter price of set package");
		System.out.println("---------------------------------");
		price = sc.nextDouble();

		char done = 'n';
		MenuItem item;
		String itemName;
		while(done != 'y'){
			System.out.println("----------------------------------------------");
			System.out.println("Please the name of the item to add to the set");
			System.out.println("----------------------------------------------");
			itemName = sc.next();
			for(int i=0; i<menu.getMenuItems().size(); i++){
				if(itemName.equals(menu.getMenuItems().get(i).getName())){ //if itemName == name of the item
					item = menu.getMenuItems().get(i);
					setItems.add(item);
					break;
				}
			}

			System.out.println("-----------------------------");
			System.out.println("Add more items? y-yes n-no");
			System.out.println("-----------------------------");
			done = sc.next().charAt(0);
			if (done != 'y' && done != 'n'){
				System.out.println("Invalid input. Please enter y or n");
			}
		} //when done == y, not adding anymore items. exit loop

		SetPromotionPackage newSet = new SetPromotionPackage(name, price, setItems);
		menu.addSet(newSet);
		System.out.println(newSet.getPromotionName() + " set was added!");
		//displayMgr.addItem(newItem);
	}

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
				addPromoSet();
				System.out.println("Set was updated!");
				break;
			}
		}

	}

}