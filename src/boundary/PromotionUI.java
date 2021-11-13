package boundary;

import java.util.Scanner;
import controller.DisplayMgr;
import entity.Menu;

public class PromotionUI {

	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	Menu menu = MainMenuUI.menu;

	public void promotionMenu() {
		// TODO - implement PromotionUI.displayPromotion
		//throw new UnsupportedOperationException();
		int choice;
		menu.printPromoMenu();
		System.out.println("----------------------------------");
		System.out.println("Please choose an option");
		System.out.println("1. Add promotion set to menu");
		System.out.println("2. Remove promotion set from menu");
		System.out.println("3. Update promotion set in menu");
		System.out.println("4. Return to main menu");
		System.out.println("----------------------------------");

		choice = sc.nextInt();
			switch (choice) {
				 case 1:  //add promotion set
				 	displayMgr.addPromo();
				 break;
				 case 2:  // remove promotion set
				 	displayMgr.removePromo();
				 break;
				 case 3: 
				 	displayMgr.updatePromo();
				break;
				case 4:
					System.out.println("Returning to main menu"); //return to main menu
				break;
			}
	}

}