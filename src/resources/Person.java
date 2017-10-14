package resources;

import java.util.ArrayList;

public class Person {
	
	private int pId;
	private String name;
	private double debt;
	
	public Person(int pId, String name, double debt) {
		this.pId = pId;
		this.name = name;
		this.debt = debt;
	}
	
	public Person(int pId, String name) {
		this(pId, name, 0);
	}
	
	public void split(Item i, int index, ArrayList<Person> group) {
		this.debt += i.getPrice()/group.size();
		if((index + 1) == group.size()) {
			return;
		}
		group.get(index + 1).split(i, index + 1, group);
	}
	
	public double getDebt() {
		return this.debt;
	}
}
