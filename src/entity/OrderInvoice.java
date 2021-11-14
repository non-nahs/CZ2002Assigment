package entity;

import java.util.*;

import boundary.MainMenuUI;
import controller.MainMgr;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.ObjectOutput;
//import java.io.ObjectOutputStream;
//import java.nio.file.Path;
//import java.nio.file.Paths;

/**
 * Represents an OrderInvoice that a customer needs to pay in the restaurant
 * @author Chieng Shuen Ern Shannon
 * @version 1.0
 * @since 2021-10-15
 */
public class OrderInvoice {
	static Order order = MainMenuUI.order;
	static Customer cus = MainMenuUI.customer;
	private static final DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * This is the time when OrderInvoice object is created.
	 */
	private LocalDate timeStamp;

	/**
	 * This is the ArrayList of all Orders made by customer.
	 */
	private ArrayList<Order> totalOrders;
	
	/**
	 * This is the total ordered item amount before any discount.
	 */
	private static double b4DiscTotal;

	/**
	 * This is the total discount for all ordered item for this OrderInvoice
	 */
	private static double discountTotal;

	/**
	 * This is the GST tax for this OrderInvoice
	 */
	private static double gstTax;

	/**
	 * This is the service tax for this OrderInvoice
	 */
	private static double svcTax;

	/**
	 * This is the total payable amount for this OrderInvoice
	 */
	private static double finalTotal;
	
	
	/**
	 * Creates a blank sheet of orderInvoice with all the values being set to 0.
	 * The timeStamp of the orderInvoice will be set as the computer's current time upon construction.
	 */
	public OrderInvoice() {
		this.timeStamp = LocalDate.now(ZoneId.systemDefault());  // dunno works or not
		//membership = false;
		OrderInvoice.b4DiscTotal = 0;
		OrderInvoice.discountTotal = 0;
		OrderInvoice.gstTax = 0;
		OrderInvoice.svcTax = 0;
		OrderInvoice.finalTotal = 0;
	} 


	/**
	 * Call all set methods for orderInvoice
	 * Display this orderInvoice's details with the following:
	 * 		- subtotal
	 * 		- service charge
	 * 		- GST charge
	 * 		- discounted amount
	 * 		- final total
	 * @param membership	customer's membership status to be used for this orderInvoice's discount
	 */
	public void printInvoice(Boolean membership) {

		order.calPretaxTotal();
		b4DiscTotal = order.getPretaxTotal();
		svcTax = b4DiscTotal * 0.1;
		gstTax = b4DiscTotal * 1.1 * 0.07;
		if(membership) {
			discountTotal = b4DiscTotal * 0.1;
			finalTotal = b4DiscTotal + svcTax + gstTax - discountTotal;
		}
		else {
			finalTotal = b4DiscTotal + svcTax + gstTax;
		}
		try {
			invoice2txt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nSubTotal: " + df.format(b4DiscTotal));
		System.out.println("Service Charge: " + df.format(svcTax));
		System.out.println("GST: " + df.format(gstTax));
		if(membership) {
			System.out.println("Discount: " + df.format(discountTotal));
			System.out.println("Total: " + df.format(finalTotal));
		}
		else {
			System.out.println("Total: " + df.format(finalTotal));
		}
		
		order.clearOrder();
	}


	/**
	 * Writes this orderInvoice to a txt file.
	 * @throws IOException throws input/ouput error message if file does not exist
	 */
	public void invoice2txt() throws IOException {
		ArrayList <Order> totalOrder= new ArrayList<Order>();
		//converts object from order to total order to add to invoice for sale revenue in future
		MenuItem tempItem = new MenuItem();
		SetPromotionPackage tempPackage = new SetPromotionPackage();
		LocalDate orderDate;

		orderDate = LocalDate.now();
		int i=0;
		for (i=0; i<order.getOrder().size(); i++) {
			tempItem = order.getOrder().get(i);
			try (FileWriter writer = new FileWriter(MainMgr.PATH, true)){;  //add to promoUI
				writer.write(orderDate + "\t" + "ALC : " + tempItem.getName() + "\t" + tempItem.getPrice() + "\n");
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			System.out.println(tempItem.getName() + "\t" + tempItem.getPrice());
		}
		i=0;
		for (i=0; i<order.getSetOrder().size(); i++) {
			tempPackage = order.getSetOrder().get(i);
			try (FileWriter writer = new FileWriter(MainMgr.PATH, true)){;  //add to promoUI
				writer.write(orderDate + "\t" + "Set : " + tempPackage.getPromotionName() + "\t" + tempPackage.getPromotionPrice() + "\n");
				writer.flush();
				writer.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			System.out.println(tempPackage.getPromotionName() + "\t" + tempPackage.getPromotionPrice());
		}
		// writes object in stream to txt file
		
		/*try (FileWriter writer = new FileWriter(MainMgr.PATH, true)){;  //add to promoUI
					writer.write(orderDate + "\t" + "ALC : " + tempItem.getName() + "\t" + tempItem.getPrice() + "\n");
					writer.flush();
					writer.close();
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
		*/
		
	}

	/**
	 * Get the time of when this OrderInvoice was created
	 * @return this orderInvoice's timestamp.
	 */
	public LocalDate getTimeStamp() {
		return this.timeStamp;
	}

	/**
	 * Add new order made by customer to OrderInvoice
	 */

	public void includeOrder(Order newOrder){
		this.totalOrders.add(newOrder);
	}

	/**
	 * Set the total sum of items ordered by customer
	 * @return total amount of items ordered for this invoice
	 */
	public double sumTotal() {
		double totalSum = 0;
		for(Order o : this.totalOrders){
			totalSum += o.getPretaxTotal();
		}
		return totalSum;
	}
	/**
	 * Set discount amount a customer has received.
	 * There will be a 10% discount of all orders made if membership is true
	 * @param status this customer's membership status 
	 * 					- True: have membership
	 * 					- False: do not have membership
	 */
	public void calculateDiscount(boolean status) {
		// assume member = flat 10% discount....
		double totalSum = sumTotal();
		double totalDisc = 0;
		if (status){ // if memberstatus == true
			totalDisc = 0.1 * totalSum;
		}
		OrderInvoice.discountTotal = totalDisc; 
	}

	/**
	 * Set the GST charge amont a customer needs to pay in the orderInvoice
	 * GST charge is set to 7% of the total cost of orders (without other taxes)
	 */
	public void calculateGST() {
		// assume GST = 7%
		OrderInvoice.gstTax = 0.07 * sumTotal();
	}

	/**
	 * Set the total amount of service charge a customer needs to pay in the orderInvoice
	 * Service charge is set to 10% of the total cost of orders (without other taxes)
	 */
	public void calculateSVC() {
		// assume svc charge = 10%
		OrderInvoice.gstTax = 0.10 * sumTotal();
	}

	/**
	 * Set the final total amount a customer needs to pay in the orderInvoice
	 */
	public void calculateTotal() {
		OrderInvoice.finalTotal = sumTotal() + OrderInvoice.gstTax + OrderInvoice.svcTax - this.discountTotal;
	}

	/**
	 * Gets the discount amount the customer has recieved
	 * @return this orderInvoice's discount amount.
	 */
	public double getDiscount() {
		return this.discountTotal;
	}

	/**
	 * Gets the GST charge amount the customer needs to pay
	 * @return this orderInvoice's GST charge amount.
	 */
	public double getGST() {
		return OrderInvoice.gstTax;
	}

	/**
	 * Gets the service charge amount the customer needs to pay
	 * @return this orderInvoice's service charge amount.
	 */
	public double getSVC() {
		return OrderInvoice.svcTax;
	}

	/**
	 * Gets the final total amount the customer needs to pay
	 * @return this orderInvoice's final total amount.
	 */
	public double getFinalTotal() {
		return OrderInvoice.finalTotal;
	}

}		