package controller;

import boundary.MainMenuUI;
import entity.*;

public class MainMgr {
	//change path of orderList.txt to local path
	public static final String PATH = "/Users/shanchieng/Desktop/Git/CZ2002Assigment/orderList.txt";
	public static int x;
	public static void main(String[] args) {
		
		initDisplay();
		//throw new UnsupportedOperationException();
	}
	
	/*public void main() {
		// TODO - implement MainMgr.main
		initDisplay();
		throw new UnsupportedOperationException();
	}*/

	public void checkTimeout() {
		// TODO - implement MainMgr.checkTimeout
		//throw new UnsupportedOperationException();
	}
	
	private static void initDisplay() {
		MainMenuUI mainMenuUI = new MainMenuUI();
		mainMenuUI.initData();
		mainMenuUI.displayMenu();
	}

}