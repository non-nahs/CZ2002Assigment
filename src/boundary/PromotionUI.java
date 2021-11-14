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
					break;
				 case 2:  //add promotion set
				 sc.nextLine();
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
				menu.removeSet(tempSet);
				addPromoSet();
				System.out.println("Set was updated!");
				break;
			}
		}

	}

}