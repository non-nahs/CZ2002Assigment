package entity;

import java.util.ArrayList;

public class Order {

	private ArrayList<MenuItem> order  = new ArrayList<MenuItem>();
	private double pretaxTotal;

	public void viewOrder() {
		// TODO - implement Order.viewOrder
		for (MenuItem m : order)
			System.out.println(m.getName());
	}

	public void addItem() {
		// TODO - implement Order.addItem
		order.add(MenuItem);		
	}

	public void removeItem() {
		// TODO - implement Order.removeItem
		order.remove(MenuItem);		
	}

	public void calPretaxTotal() {
		// TODO - implement Order.calPretaxTotal
		for (MenuItem m : order)
			this.pretaxTotal += m.getPrice();
	}

	public double getPretaxTotal() {
		return this.pretaxTotal;
	}

}