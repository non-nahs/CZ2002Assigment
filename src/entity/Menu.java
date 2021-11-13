package entity;
//runhan
import java.util.ArrayList;

import entity.MenuItem.Category;
import entity.MenuItem;

public class Menu {

	private ArrayList<MenuItem> items = new ArrayList<MenuItem>();
	private ArrayList<SetPromotionPackage> sets = new ArrayList<SetPromotionPackage>();

	//print ala carte menu
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

	// public String toString(MenuItem item){
	// 	return item.getName() + item.getPrice() + "\n" + item.getDescripton();
	// }
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

	public void addItem(MenuItem newItem){
		items.add(newItem);
	}

	public void removeItem(MenuItem item){
		// first checks if item exists in a set promotion package, then removes package if it exists

		int i=0, j=0;
		ArrayList<SetPromotionPackage> tempPromoList = sets;
		SetPromotionPackage tempPromoSet = new SetPromotionPackage();
		MenuItem tempItem = new MenuItem();
		for (i=0; i<tempPromoList.size(); i++) {
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

		/*while (i<tempPromoList.size()) {
			tempPromoSet = tempPromoList.get(i);
			ArrayList<MenuItem> tempMList = tempPromoSet.getSetItems();
			while (j<tempMList.size()) {
				tempItem = tempMList.get(j);
				if (item.getName().equals(tempItem.getName())) {
					removeSet(tempPromoSet);
					System.out.println("Set " + tempPromoSet.getPromotionID() + " was removed!");
				}
				j++;
			}
			i++;
		}*/
		
		//removes item from list
		items.remove(item);
		//item = null;
	}

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