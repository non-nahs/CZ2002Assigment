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
		checkoutOrder();
		OrderInvoice.printInvoice();
		System.out.println("Returning to main menu");
	}

	private void checkoutOrder() {
		
	}

}