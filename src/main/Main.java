package main;

import java.util.ArrayList;
import resources.*;

public class Main {
	
	private static ArrayList<Person> people = new ArrayList<Person>();
	private static ArrayList<Item> outstandingItems = new ArrayList<Item>();
	
	public static void on_Finished(Item finished) {
		people.get(0).split(finished, 0, people);
	}
		
	public static void main(String[] args) {
		people.add(new Person(1, "Anthony", 0));
		people.add(new Person(2, "Kevin", 0));
		people.add(new Person(3, "Will", 0));
		people.add(new Person(4, "Matteus", 0));
		people.add(new Person(5, "Nick", 0));
		Item i = new Item("Milk", 5);
		on_Finished(i);
		System.out.println(people.get(0).getDebt());
	}

}
