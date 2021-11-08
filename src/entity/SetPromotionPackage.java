package entity;

import java.util.ArrayList;

public class SetPromotionPackage {

	private int promotionID;
	private String promotionName;
	private double promotionPrice;
	private ArrayList<MenuItem> setItems;

	//use constructor to add a set under menu
	public SetPromotionPackage(int id, String name, double price, ArrayList<MenuItem> items) {
		promotionID = id;
		promotionName = name;
		promotionPrice = price;
		setItems = items;
	}

	//getting the attributes
	public int getPromotionID() {
		return promotionID;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public double getPromotionPrice() {
		return promotionPrice;
	}
	public ArrayList<MenuItem> getSetItems() {
		return setItems;
	}

	//updating the attributes (setting)
	//ask for input in controller.
	public void updatePromotionID(int newId){
		promotionID = newId;
	}
	public void updatePromotionName(String newName){
		promotionName = newName;
	}
	public void updatePromotionPrice(double newPrice){
		promotionPrice = newPrice;
	}
	public void updateSetItems(ArrayList<MenuItem> newSetItems){
		setItems = newSetItems;
	}

}