package entity;

/**
 * Represents an ala-carte item in the menu.
 * @author Yu Runhan
 * @version 1.0
 * @since 2021-10-15
 */
public class MenuItem {

	/**
	 * The name of this ala-carte menu item.
	 */
	private String name;

	/**
	 * The description of this ala-carte menu item. 
	 * The description includes the details of each menu item.
	 */
	private String description;

	/**
	 * The price of this ala-carte menu item.
	 */
	private double price;

	/**
	 * The categories that this ala-carte menu item can be categorised under.
	 * The three categories are main course, drink, and dessert.
	 */
	public enum Category {MAIN_COURSE, DRINK, DESSERT};
	
	/**
	 * The category of this menu item.
	 * This menu item can be either a main course, drink, or dessert.
	 */
	private Category category;

	/**
	 * Class constructor.
	 * Creates an empty menu item to allow initialisation of an menu item with default empty parameters.
	 */
	public MenuItem() {
		category = Category.MAIN_COURSE;
		name = "";
		description = "";
		price = 0;
	}

	/**
	 * Constructor of this class.
	 * Creates a menu item with the given parameters.
	 * The paramaters include the class's category, name, description, and price.
	 * @param category The category of this menu item.
	 * @param name The name of this menu item.
	 * @param desc The description of this menu item.
	 * @param price The price of this menu item.
	 */
	public MenuItem(Category category, String name, String desc, double price){
		this.category = category;
		this.name = name;
		this.description = desc;
		this.price = price;
	}

	//getters
	/**
	 * Gets the category of this menu item.
	 * @return this menu item's category
	 */
	public Category getCategory(){
		return category;
	}

	/**
	 * Gets the name of this menu item.
	 * @return this menu item's name.
	 */
	public String getName(){
		return name;
	}

	/**
	 * Gets the description of this menu item.
	 * @return this menu item's description.
	 */
	public String getDescripton(){
		return description;
	}

	/**
	 * Gets the price of this menu item.
	 * @return this menu item's price.
	 */
	public double getPrice(){
		return price;
	}

	//setters
	/**
	 * Changes this menu item's category to the new given category.
	 * @param category This menu item's new category.
	 */
	public void setCategory(Category category){
		this.category = category;
	}

	/**
	 * Changes this menu item's name to the new given name.
	 * @param name This menu item's new name.
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Changes this menu item's description to the new given description.
	 * @param desc This menu item's new description.
	 */
	public void setDescription(String desc){
		this.description = desc;
	}

	/**
	 * Changes this menu item's price to the new given price.
	 * @param price This menu item's new price.
	 */ 
	public void setPrice(double price){
		this.price = price;
	}

	/**
	 * Convert the instance variables of this menu item to String.
	 * String is formatted to show the name, price, and description of this menu item.
	 * @param item This menu item.
	 * @return This menu item's name, price and description as a String.
	 */
	public String toString(MenuItem item){
		return name + "\t\t" + price + "\n" + description;
	}

}