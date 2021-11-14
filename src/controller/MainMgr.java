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
	
	private static void initDisplay() {
		MainMenuUI mainMenuUI = new MainMenuUI();
		mainMenuUI.initData();
		mainMenuUI.displayMenu();
	}

}