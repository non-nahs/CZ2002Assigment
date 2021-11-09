package controller;

import boundary.MainMenuUI;

public class MainMgr {

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
		throw new UnsupportedOperationException();
	}
	
	private static void initDisplay() {
		MainMenuUI mainMenuUI = new MainMenuUI();
		mainMenuUI.displayMenu();
	}

}