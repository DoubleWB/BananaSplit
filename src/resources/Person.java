package resources;

public class Person {
	
	private int pId;
	private String name;
	private double debt;
	
	Person(int pId, String name, double debt) {
		this.pId = pId;
		this.name = name;
		this.debt = debt;
	}
	
	Person(int pId, String name) {
		this(pId, name, 0);
	}
}
