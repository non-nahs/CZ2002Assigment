public abstract class MenuItem {

	private String name;
	private String desc;
	private double price;

	public String getName() {
		return this.name;
	}

	public String getDescripton() {
		// TODO - implement MenuItem.getDescripton
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(string name) {
		// TODO - implement MenuItem.setName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param desc
	 */
	public void setDescription(string desc) {
		// TODO - implement MenuItem.setDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}