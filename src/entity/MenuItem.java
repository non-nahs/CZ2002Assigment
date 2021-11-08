package entity;

public abstract class MenuItem {

	private String name;
	private String desc;
	private double price;

	public MenuItem(String n, String d, double p){
		name = n;
		desc = d;
		price = p;
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

	public void setName(String name){
		this.name = name;
	}

	public void setDescription(String desc){
		this.desc = desc;
	}

	public void setPrice(double price){
		this.price = price;
	}

}