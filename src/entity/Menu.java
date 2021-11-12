package entity;
//runhan
import java.util.ArrayList;

import entity.MenuItem.Category;
import entity.MenuItem;

public class Menu {

	private ArrayList<MenuItem> items = new ArrayList<MenuItem>();
	private ArrayList<SetPromotionPackage> sets = new ArrayList<SetPromotionPackage>();

	//initialise default menu

	public void printMenu() {
		//for design principles: move each print e.g. print main course to a new class, then call the classes to print here?
		MenuItem tempItem;
		SetPromotionPackage tempSet;
		String name;
		double price;

		System.out.println("MENU\n");

		System.out.println("Main Course:");
		for(int i=0; i<items.size(); i++){
			tempItem = items.get(i); //current item in the iteration
			if(tempItem.getCategory() == Category.MAIN_COURSE){ //if item == maincourse, print
				System.out.println(tempItem.toString(tempItem)+"\n");
			}
		}
		System.out.println("\n");

		System.out.println("Drinks:");
		for(int i=0; i<items.size(); i++){
			tempItem = items.get(i);
			if(tempItem.getCategory() == Category.DRINK){
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
		System.out.println("\n");


		System.out.println("Set Promotion Packages: ");
		ArrayList<MenuItem> tempSetItems;
		for(int i=0; i<sets.size(); i++){
			tempSet = sets.get(i);
			tempSetItems = tempSet.getSetItems();

			name = tempSet.getPromotionName();
			price = tempSet.getPromotionPrice();
			System.out.println(name + "\t" + price);

			for(int j=0; j<tempSetItems.size(); j++) {
				System.out.println(tempSetItems.get(j).getName());
				System.out.println(tempSetItems.get(j).getDescripton()+"\n");
			}
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
		sets.add(new SetPromotionPackage(1, "Beefy Monday", 25, set1));

		ArrayList<MenuItem> set2 = new ArrayList<MenuItem>();
		set2.add(fishNchips); set2.add(pinkCooler); set2.add(tiramisu);
		sets.add(new SetPromotionPackage(2, "Fishy Tuesday", 22, set2));
	}

	public void addItem(MenuItem newItem){
		items.add(newItem);
	}

	public void removeItem(MenuItem item){
		items.remove(item);
		item = null;
	}

	public void addSet(SetPromotionPackage newSet){
		sets.add(newSet);
	}

	public void removeSet(SetPromotionPackage set){
		sets.remove(set);
		set = null;
	}

}