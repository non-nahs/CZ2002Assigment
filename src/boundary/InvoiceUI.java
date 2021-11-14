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
		if(order.getOrder().size()==0 && order.getSetOrder().size()==0) {
			System.out.println("Order is empty, please add items to order!");
			return;
		}
		int tableID=0, member=0;
		Boolean membership = false;

		System.out.println("Please enter table number from 1-18");
		tableID = sc.nextInt();
		MainMenuUI.table.get(tableID-1).releaseTable();

		System.out.println("Is customer member?");
		System.out.println("1 yes");
		System.out.println("0 no");
		member = sc.nextInt();
		if (member==1) membership=true;

		checkoutOrder();
		orderInvoice.printInvoice(membership);
		System.out.println("Returning to main menu");
	}

	private void checkoutOrder() {
		
	}

}