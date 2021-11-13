package entity;

import java.util.ArrayList;

public class Order {

	private static ArrayList<MenuItem> order  = new ArrayList<MenuItem>();
	private static ArrayList<SetPromotionPackage> setOrder = new ArrayList<SetPromotionPackage>();
	private double pretaxTotal;

	public void viewOrder() {
		// TODO - implement Order.viewOrder
		for (MenuItem m : order)
			System.out.println(m.getName());
	}

	public void addItem(MenuItem menuItem) {
		// TODO - implement Order.addItem
		order.add(menuItem);		
	}

	public void removeItem(MenuItem menuItem) {
		// TODO - implement Order.removeItem
		order.remove(menuItem);		
	}

	public void addSet(SetPromotionPackage set) {
		// TODO - implement Order.addItem
		setOrder.add(set);		
	}

	public void removeSet(SetPromotionPackage set) {
		// TODO - implement Order.removeItem
		setOrder.remove(set);		
	}

	public void calPretaxTotal() {
		// TODO - implement Order.calPretaxTotal
		for (MenuItem m : order)
			this.pretaxTotal += m.getPrice();
		for (SetPromotionPackage set : setOrder)
			pretaxTotal += set.getPromotionPrice();
	}

	public double getPretaxTotal() {
		return this.pretaxTotal;
	}

	public ArrayList<MenuItem> getOrder() {
		return order;
	}

	public ArrayList<SetPromotionPackage> getSetOrder() {
		return setOrder;
	}

}