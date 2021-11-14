package boundary;

import java.util.Scanner;
import entity.OrderInvoice;
import entity.Order;

/**
 * Represents a boundary class to get user input to print the invoice.
 * @author Shannon Chieng
 * @version 1.0
 * @since 2021-10-15
 */
public class InvoiceUI {

	Scanner sc = new Scanner(System.in);
	OrderInvoice orderInvoice = MainMenuUI.orderInvoice;
	Order order = MainMenuUI.order;
	
	/**
	 * Gets user to input the table number.
	 * Release the table to the customer. 
	 * Gets user to input whether customer is a member or not. 
	 * Prints the invoice. 10% discount is applied if customer is a member. 
	 */
	public void printInvoice() {
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

		orderInvoice.printInvoice(membership);
		System.out.println("Returning to main menu");
	}

}