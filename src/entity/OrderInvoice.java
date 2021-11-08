package entity;

import java.util.*;

public class OrderInvoice {

	Collection<Order> orders;
	private Date timeStamp;
	private Order orderItems;
	private double discountTotal;
	private double gstTax;
	private double svcTax;
	private double finalTotal;

	/**
	 * 
	 * @param status
	 */
	public double calculateDiscount(boolean status) {
		// TODO - implement OrderInvoice.calculateDiscount
		throw new UnsupportedOperationException();
	}

	public void calculateGST() {
		// TODO - implement OrderInvoice.calculateGST
		throw new UnsupportedOperationException();
	}

	public void calculateSVC() {
		// TODO - implement OrderInvoice.calculateSVC
		throw new UnsupportedOperationException();
	}

	public void calculateTotal() {
		// TODO - implement OrderInvoice.calculateTotal
		throw new UnsupportedOperationException();
	}

	public void getDiscount() {
		// TODO - implement OrderInvoice.getDiscount
		throw new UnsupportedOperationException();
	}

	public double getGST() {
		// TODO - implement OrderInvoice.getGST
		throw new UnsupportedOperationException();
	}

	public double getSVC() {
		// TODO - implement OrderInvoice.getSVC
		throw new UnsupportedOperationException();
	}

	public double getFinalTotal() {
		return this.finalTotal;
	}

}