// Jasper
package entity;

import java.util.*;

import boundary.MainMenuUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;

public class OrderInvoice {
	Order order = MainMenuUI.order;
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

	public static void initInvoice() {
		// insert ur path name to this place
		// copy path of orderList.txt
		Path path = Paths.get("orderList.txt");
		try(Scanner sc = new Scanner(path)) {
			
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage() + e.getLocalizedMessage());
		}
	}

	public static void printInvoice() {
		Path path = Paths.get("orderList.txt");
		try(Scanner sc = new Scanner(path)) {
			
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage() + e.getLocalizedMessage());
		}
	}

	public void invoice2txt() throws IOException {
		ArrayList <Order> totalOrder= new ArrayList<Order>();
		//converts object from order to total order to add to invoice for sale revenue in future
		int i=0, j=0;

		for (i=0; i<order.getOrder().size(); i++) {

		}

		// writes object in stream to txt file
		try {
			FileOutputStream fos = new FileOutputStream("orderList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(totalOrder);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

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