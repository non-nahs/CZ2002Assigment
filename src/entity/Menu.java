package entity;
import java.util.ArrayList;

import entity.MenuItem.Category;

/**
 * Represents a menu containing menu items and set promotion packages.
 * @author Yu Runhan
 * @version 1.0
 * @since 2021-10-15
 */
public class Menu {

	/**
	 * The list of ala-carte menu items in this menu.
	 */
	private ArrayList<MenuItem> items = new ArrayList<MenuItem>();

	/**
	 * The list of set promotion packages in this menu.
	 * Each set promotion package contains a list of ala-carte menu items.
	 */
	private ArrayList<SetPromotionPackage> sets = new ArrayList<SetPromotionPackage>();

	//print ala carte menu
	/**
	 * Displays all ala-carte menu items in this menu.
	 * This menu's items are displayed under their respective categories.
	 * Each item's name, price and description will be displayed.
	 */
	public void printAlaCarteMenu() { 
		//for design principles: move each print e.g. print main course to a new class, then call the classes to print here?
		MenuItem tempItem;

		System.out.println("ALA-CARTE MENU\n");

		System.out.println("Main Course:");
		for(int i=0; i<items.size(); i++){
			tempItem = items.get(i); 		//current item in the arraylist of menuitems
			if(tempItem.getCategory() == Category.MAIN_COURSE){ //if item == maincourse, print
				System.out.println(tempItem.toString(tempItem)+"\n"); //each menuitem printed
			}
		}
		System.out.println("\n");

		System.out.println("Drinks:");
		for(int i=0; i<items.size(); i++){		
			tempItem = items.get(i); 			//current item in the arraylist of menuitems
			if(tempItem.getCategory() == Category.DRINK){		//if item == maincourse, print
				System.out.println(tempItem.toString(tempItem)+"\n");
			}
		}
		System.out.println("\n");


		System.out.println("Dessert:");
		for(int i=0; i<items.size(); i++){
			tempItem = items.get(i);
			if(tempItem.getCategory() == Category.DESSERT){
				System.out.println(tempItem.toString(tempItem)+"\n");
			}
		}
	}

	//print promo menu
	/**
	 * Displays all the set promotion packages in this menu.
	 * Each set promotion package's name, price and list of items with their respective descriptions are displayed.
	 */
	public void printPromoMenu(){ 
		SetPromotionPackage tempSet;
		String name;
		double price;

		System.out.println("Set Promotion Packages: ");
		ArrayList<MenuItem> tempSetItems;
		for(int i=0; i<sets.size(); i++){
			tempSet = sets.get(i);
			tempSetItems = tempSet.getSetItems();

			name = tempSet.getPromotionName();
			price = tempSet.getPromotionPrice();
			System.out.println(name + "\t\t" + price);

			for(int j=0; j<tempSetItems.size(); j++) {
				System.out.println(tempSetItems.get(j).getName());
				System.out.println(tempSetItems.get(j).getDescripton()+"\n");
			}

			System.out.println("\n");

		}
	}

	/**
	 * Initialise the default menu of this menu.
	 * This default menu contains six ala-carte items and two set promotion packages.
	 */
	public void initMenu() {
		/*MenuItem mItem = new MenuItem(Category.MAIN_COURSE, "Angus Beef Burger", "Brioche Bun, Angus Beef Patty, Tomato, Caramelized Onion, Cheddar, Sunny-Side Egg, Potato Fries", 18);
		items.add(mItem);*/
		MenuItem beefBurger = new MenuItem(Category.MAIN_COURSE, "Angus Beef Burger", "Brioche Bun, Angus Beef Patty, Tomato, Caramelized Onion, Cheddar, Sunny-Side Egg, Potato Fries", 18);
		items.add(beefBurger);
		MenuItem fishNchips = new MenuItem(Category.MAIN_COURSE, "Fish and Chips", "Battered Pollock, Cajun Potato Fries, Passionfruit Tartar Sauce", 16);
		items.add(fishNchips);
		MenuItem passionFruit = new MenuItem(Category.DRINK, "Passion Fashion", "Passionfruit, pineapple, mint", 6);
		items.add(passionFruit);
		MenuItem pinkCooler = new MenuItem(Category.DRINK, "Pink Cooler", "Watermelon, orange, pineapple", 6);
		items.add(pinkCooler);
		MenuItem carrotCake = new MenuItem(Category.DESSERT, "Carrot cake", "Carrot Sponge, Cinnamon, Cream Cheese Frosting", 6.5);
		items.add(carrotCake);
		MenuItem tiramisu = new MenuItem(Category.DESSERT, "Tiramisu", "Cocoa Almond Sponge, Coffee Syrup, Mascarpone Mousse", 6.5);
		items.add(tiramisu);
		
		//initialise sets
		ArrayList<MenuItem> set1 = new ArrayList<MenuItem>();
		set1.add(beefBurger); set1.add(passionFruit); set1.add(carrotCake);
		sets.add(new SetPromotionPackage("Beefy Monday", 25, set1));

		ArrayList<MenuItem> set2 = new ArrayList<MenuItem>();
		set2.add(fishNchips); set2.add(pinkCooler); set2.add(tiramisu);
		sets.add(new SetPromotionPackage("Fishy Tuesday", 22, set2));
	}

	/**
	 * Adds an ala-carte item into the this menu's current list ala-carte items.
	 * @param newItem New ala-carte item to be added into this menu's current list of ala-carte items.
	 */
	public void addItem(MenuItem newItem){
		items.add(newItem);
	}

	/**
	 * Removes the given ala-carte item from this menu's current list of ala-carte items.
	 * Set promotion packages that contain the removed item will be removed as well.
	 * @param item The ala-carte item to be removed from this menu's current list of ala-carte-items.
	 */
	public void removeItem(MenuItem item){
		// first checks if item exists in a set promotion package, then removes package if it exists

		int i=0, j=0;
		ArrayList<SetPromotionPackage> tempPromoList = sets;
		SetPromotionPackage tempPromoSet = new SetPromotionPackage();
		MenuItem tempItem = new MenuItem();
		for (i=0; i<tempPromoList.size(); i++) { //remove set if set contains this item
			tempPromoSet = tempPromoList.get(i);
			ArrayList<MenuItem> tempMList = tempPromoSet.getSetItems();
			for (j=0; j<tempMList.size(); j++) {
				tempItem = tempMList.get(j);
				if (item.getName().equals(tempItem.getName())) {
					removeSet(tempPromoSet);
					System.out.println("Set " + tempPromoSet.getPromotionName() + " was removed!");
				}
			}
		}
		//removes item from list
		items.remove(item);
		//item = null;
	}

	/**
	 * Adds the given set promotion package into this menu's current list of set packages.
	 * @param newSet The set promotion package to be added into this menu's current list of set packages
	 */
	public void addSet(SetPromotionPackage newSet){
		sets.add(newSet);
	}

	public void removeSet(SetPromotionPackage set){
		sets.remove(set);
		//set = null;
	}

	public ArrayList<MenuItem> getMenuItems() {
		return items;
	}

	public ArrayList<SetPromotionPackage> getSetPackages(){
		return sets;
	}

}