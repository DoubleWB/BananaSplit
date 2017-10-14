package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Person {
	
	private int pId;
	private String name;
	private ArrayList<Debt> debts;
	
	public Person(int pId, String name) {
		this.pId = pId;
		this.name = name;
		this.debts = new ArrayList<Debt>();
	}
	
	public void split(Item i, int index, ArrayList<Person> group, HashMap<Item, Person> items) {
		Person owedTo = items.get(i);
		Scanner s = new Scanner(System.in);
		if(s.next().equals("n")) {
			percentageSplit(i, 0, group, items);
		}
		if(owedTo != this) {
			this.debts.add(new Debt(owedTo, i.getPrice()/group.size()));
		}
		if((index + 1) == group.size()) {
			return;
		}
		group.get(index + 1).split(i, index + 1, group, items);
	}
	
	public void percentageSplit(Item i, int index, ArrayList<Person> group, HashMap<Item, Person> items) {
		Scanner s = new Scanner(System.in);
		
	}
	
	public ArrayList<Debt> getDebts() {
		return this.debts;
	}
	
	public String toString() {
		return this.name;
	}
	
	public boolean equals(Person other) {
		return this.pId == other.pId;
	}
}
