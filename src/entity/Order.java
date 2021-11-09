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

	public void addItem(MenuItem a) {
		// TODO - implement Order.addItem
		order.add(a);		
	}

	public void removeItem(MenuItem a) {
		// TODO - implement Order.removeItem
		order.remove(a);		
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