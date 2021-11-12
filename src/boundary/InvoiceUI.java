package boundary;

import java.util.Scanner;
import controller.DisplayMgr;

public class InvoiceUI {

	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	
	public void printInvoice() {
		// TODO - implement InvoiceUI.printInvoice
		//throw new UnsupportedOperationException();
		displayMgr.getInvoice();
		System.out.println("Invoice printed!"); 
		System.out.println("Returning to main menu");
	}

}