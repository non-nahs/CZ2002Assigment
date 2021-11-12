package entity;

public class MenuItem {

	private String name;
	private String desc;
	private double price;
	public enum Category {MAIN_COURSE, DRINK, DESSERT};
	private Category category;

	public MenuItem(Category cat, String n, String d, double p){
		category = cat;
		name = n;
		desc = d;
		price = p;
	}

	//getters
	public Category getCategory(){
		return category;
	}
	public String getName(){
		return name;
	}
	public String getDescripton(){
		return desc;
	}
	public double getPrice(){
		return price;
	}

	//setters
	public void setCategory(Category cat){
		this.category = cat;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDescription(String desc){
		this.desc = desc;
	}
	public void setPrice(double price){
		this.price = price;
	}

	//toString to print each item
	public String toString(MenuItem item){
		return name + "\t" + price + "\n" + desc;
	}

}