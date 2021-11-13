package entity;

import java.util.ArrayList;

/**
 * Represents a set promotion package in the menu.
 * A set promotion package can contain many menu items.
 * @author Yu Runhan
 * @version 1.0
 * @since 2021-10-15
 */
public class SetPromotionPackage {

	/**
	 * The name of this set promotion package.
	 */
	private String promotionName;

	/**
	 * The price of this set promotion package.
	 */
	private double promotionPrice;

	/**
	 * The list of menu items in this set promotion package.
	 */
	private ArrayList<MenuItem> setItems = new ArrayList<MenuItem>(); 

	/**
	 * Creates an empty set promotion package, constructor
	 */
	public SetPromotionPackage() {
		promotionName = "";
		promotionPrice = 0;
		setItems = null;
	}

	/**
	 * Creates a new set promotion package with the given name, price and list of menu items.
	 * The list of menu items should exist in the menu.
	 * @param name This set promotion package's name.
	 * @param price This set promotion package's price.
	 * @param items This set promotion package's menu items.
	 */
	//use constructor to add a set under promotionUI
	public SetPromotionPackage(String name, double price, ArrayList<MenuItem> items) {
		promotionName = name;
		promotionPrice = price;
		setItems = items;
	}

	//getting the attributes
	/**
	 * Gets the name of this set promotion package.
	 * @return this set promotion package's name.
	 */
	public String getPromotionName() {
		return promotionName;
	}

	/**
	 * Gets the price of this set promotion package.
	 * @return this set promotion package's price.
	 */
	public double getPromotionPrice() {
		return promotionPrice;
	}

	/**
	 * Gets the list of menu items in this set promotion package.
	 * @return the list of items in this set.
	 */
	public ArrayList<MenuItem> getSetItems() {
		return setItems;
	}

	// public int getSetSize() {
	// 	return setItems.size();
	// }

	//updating the attributes (setters)
	/**
	 * Changes this set promotion package's name.
	 * @param newName
	 */
	public void updatePromotionName(String newName){
		promotionName = newName;
	}

}