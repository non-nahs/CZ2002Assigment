package boundary;

import java.util.Scanner;
import controller.DisplayMgr;
import entity.OrderInvoice;
import entity.Order;

public class InvoiceUI {

	Scanner sc = new Scanner(System.in);
	DisplayMgr displayMgr = MainMenuUI.displayMgr;
	OrderInvoice orderInvoice = MainMenuUI.orderInvoice;
	Order order = MainMenuUI.order;
	
	
	public void printInvoice() {
		// TODO - implement InvoiceUI.printInvoice
		//throw new UnsupportedOperationException();
		int tableID=0;
		System.out.println("Please enter table number from 1-18");
		tableID = sc.nextInt();
		MainMenuUI.table.get(tableID-1).releaseTable();

		checkoutOrder();
		orderInvoice.printInvoice();
		System.out.println("Returning to main menu");
	}

	private void checkoutOrder() {
		
	}

}