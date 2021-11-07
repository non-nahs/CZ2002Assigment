import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private ArrayList<MenuItem> items;
	private ArrayList<SetPromotionPackage> sets;

	public void printMenu() {
		// TODO - implement Menu.printMenu
		throw new UnsupportedOperationException();
	}

	public void addItem(MenuItem newItem){
		// Scanner sc = new Scanner(System.in);
		// System.out.print("1 - Main Course");
		// System.out.print("2 - Drink");
		// System.out.print("3 - Dessert");
		// System.out.print("Please choose item category: ");
		// int category = sc.nextInt();

		// System.out.print("Please enter item name: ");
		// String name = sc.next();
		// System.out.print("Please enter item description: ");
		// String desc = sc.next();
		// System.out.print("Please enter item price: ");
		// double price = sc.nextDouble();

		// switch(category){
		// 	case 1:
		// 		MainCourse newItem = //dk how to name it as the name in here
		// }
		items.add(newItem);
	}

	public void addSet(SetPromotionPackage newSet){
		sets.add(newSet);
	}

}