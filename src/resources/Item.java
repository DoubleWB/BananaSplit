package resources;

public class Item {
	
	private double price;
	private String name;
	
	public Item() {
		this.name = "";
		this.price = 0.0;
	}
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

}
