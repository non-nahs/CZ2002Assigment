package controller;

import boundary.MainMenuUI;
//import entity.*;

/**
 *  Controller Class to start the Program.
 */
public class MainMgr {
	
	/**
	 * Stores the path of orderList.txt.
	 * You should change the path to your machine before running the program. 
	 */
	public static final String PATH = "/Users/shanchieng/Desktop/Git/CZ2002Assigment/orderList.txt";
	public static int x;
	
	/**
	 * Runs the program.
	 * @param args
	 */
	public static void main(String[] args) {
		initDisplay();
	}
	
	/**
	 * Initialises the menu and table. 
	 * Displays the main menu. 
	 */
	private static void initDisplay() {
		MainMenuUI mainMenuUI = new MainMenuUI();
		mainMenuUI.initData();
		mainMenuUI.displayMenu();
	}

}