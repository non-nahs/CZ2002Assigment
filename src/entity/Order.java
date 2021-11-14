package entity;

import java.util.ArrayList;
//import boundary.MainMenuUI;

/**
 * @author Yap Eugene
 * @version 1.0
 * @since 2021-10-15
 */
public class Order {

	/**
	 * List of a la carte items in this order.
	 */
	private static ArrayList<MenuItem> order  = new ArrayList<MenuItem>();
	
	/**
	 * List of promotion sets in this order.
	 */
	private static ArrayList<SetPromotionPackage> setOrder = new ArrayList<SetPromotionPackage>();
	
	/**
	 * The subtotal of the order before gst, service charge and discounts. 
	 */
	private double pretaxTotal;

	/**
	 * Prints name of all menu items currently in this order.
	 */
	public void viewOrder() {
		for (MenuItem m : order)
			System.out.println(m.getName());
	}

	/**
	 * Deletes all menu items currently in this order.
	 */
	public void clearOrder() {
		order.removeAll(order);
		setOrder.removeAll(setOrder);
		
		pretaxTotal = 0;
	}

	/**
	 * Add this menu item to order ArrayList<MenuItem>. 
	 * @param menuItem This Order's a la carte menu item.
	 */
	public void addItem(MenuItem menuItem) {
		order.add(menuItem);		
	}

	/**
	 * Remove this menu item from order ArrayList<MenuItem>. 
	 * @param menuItem This Order's a la carte menu item.
	 */
	public void removeItem(MenuItem menuItem) {
		order.remove(menuItem);		
	}

	/**
	 * Add this Promotion set to setOrder ArrayList<SetPromotionPackage>.
	 * @param set This Order's promotion sets. 
	 */
	public void addSet(SetPromotionPackage set) {
		setOrder.add(set);		
	}

	/**
	 * Remove this Promotion set from setOrder ArrayList<SetPromotionPackage>.
	 * @param set This Order's Set Promotion Package. 
	 */
	public void removeSet(SetPromotionPackage set) {
		setOrder.remove(set);		
	}

	/**
	 * Calculate pre tax total for this Order.
	 */
	public void calPretaxTotal() {
		for (MenuItem m : order)
			this.pretaxTotal += m.getPrice();
		for (SetPromotionPackage set : setOrder)
			pretaxTotal += set.getPromotionPrice();
	}

	/**
	 * Gets pre tax total for this Order.
	 * @return This Order's pre tax total. 
	 */
	public double getPretaxTotal() {
		return this.pretaxTotal;
	}

	/**
	 * Gets all a la carte menu items in this order.
	 * @return This Order's a la carte menu items. 
	 */
	public ArrayList<MenuItem> getOrder() {
		return order;
	}

	/**
	 * Gets all prmotion sets in this order.
	 * @return This Order's promotion sets. 
	 */
	public ArrayList<SetPromotionPackage> getSetOrder() {
		return setOrder;
	}

}