package entity;
//runhan
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import entity.MenuItem.Category;

public class Menu {

	private ArrayList<MenuItem> items;
	private ArrayList<SetPromotionPackage> sets;


	public void printMenu() {
		//for design principles: move each print e.g. print main course to a new class, then call the classes to print here?
		MenuItem tempItem;
		SetPromotionPackage tempSet;
		String name;
		double price;

		System.out.println("MENU");

		System.out.println("Main Course:");
		for(int i=0; i<items.size(); i++){
			tempItem = items.get(i); //current item in the iteration
			if(tempItem.getCategory() == Category.MAIN_COURSE){ //if item == maincourse, print
				System.out.println(tempItem.toString(tempItem));
			}
		}

		System.out.println("Drinks:");
		for(int i=0; i<items.size(); i++){
			tempItem = items.get(i);
			if(tempItem.getCategory() == Category.DRINK){
				System.out.println(tempItem.toString(tempItem));
			}
		}

		System.out.println("Dessert:");
		for(int i=0; i<items.size(); i++){
			tempItem = items.get(i);
			if(tempItem.getCategory() == Category.DESSERT){
				System.out.println(tempItem.toString(tempItem));
			}
		}

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
				System.out.println(tempSetItems.get(j).getDescripton());
			}
		}

	}

	// public String toString(MenuItem item){
	// 	return item.getName() + item.getPrice() + "\n" + item.getDescripton();
	// }

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