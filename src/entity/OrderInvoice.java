// Jasper
package entity;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;

public class OrderInvoice {

	//Collection<Order> orders;
	private LocalDate timeStamp;
	private ArrayList<Order> totalOrders;
	//private boolean membership;
	private double b4DiscTotal;   // added this for easier calculation bah....
	private double discountTotal;
	private double gstTax;
	private double svcTax;
	private double finalTotal;
	
	public OrderInvoice() {
		this.timeStamp = LocalDate.now(ZoneId.systemDefault());  // dunno works or not
		//membership = false;
		this.b4DiscTotal = 0;
		this.discountTotal = 0;
		this.gstTax = 0;
		this.svcTax = 0;
		this.finalTotal = 0;
	} 

	public void initInvoice() {
		// insert ur path name to this place
		// copy path of orderList.txt
		Path path = Paths.get("/Users/shanchieng/Desktop/Git/CZ2002Assigment/src/dataBase/orderList.txt");
		try(Scanner sc = new Scanner(path)) {
			
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage() + e.getLocalizedMessage());
		}
	}

	public void printInvoice() {
		Path path = Paths.get("/Users/shanchieng/Desktop/Git/CZ2002Assigment/src/dataBase/orderList.txt");
		try(Scanner sc = new Scanner(path)) {
			
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage() + e.getLocalizedMessage());
		}
	}t

	public LocalDate getTimeStamp() {
		return this.timeStamp;
	}

	public void includeOrder(Order newOrder){
		this.totalOrders.add(newOrder);
	}

	public double sumTotal() {
		double totalSum = 0;
		for(Order o : this.totalOrders){
			totalSum += o.getPretaxTotal();
		}
		return totalSum;
	}
	public void calculateDiscount(boolean status) {
		// assume member = flat 10% discount....
		double totalSum = sumTotal();
		double totalDisc = 0;
		if (status){ // if memberstatus == true
			totalDisc = 0.1 * totalSum;
		}
		this.discountTotal = totalDisc; 

		//throw new UnsupportedOperationException();
	}

	public void calculateGST() {
		// assume GST = 7%
		this.gstTax = 0.07 * sumTotal();
		//throw new UnsupportedOperationException();
	}

	public void calculateSVC() {
		// assume svc charge = 10%
		this.gstTax = 0.10 * sumTotal();
		//throw new UnsupportedOperationException();
	}

	public void calculateTotal() {
		this.finalTotal = sumTotal() + this.gstTax + this.svcTax - this.discountTotal;
		//throw new UnsupportedOperationException();
	}

	public double getDiscount() {
		return this.discountTotal;
	}

	public double getGST() {
		return this.gstTax;
	}

	public double getSVC() {
		return this.svcTax;
	}

	public double getFinalTotal() {
		return this.finalTotal;
	}

}		