package main;

import java.util.ArrayList;
import java.util.HashMap;

import resources.*;

public class Main {
		
	public static void main(String[] args) {
		Person a = new Person(1, "Anthony");
		people.add(a);
		people.add(new Person(2, "Kevin"));
		people.add(new Person(3, "Will"));
		people.add(new Person(4, "Matteus"));
		people.add(new Person(5, "Nick"));
		Item i = new Item("Milk", 5);
		outstandingItems.put(i, a);
		on_Finished(i);
		System.out.println(people.get(1).getDebts().get(0));
		System.out.println(people.get(0).getDebts().size());
	}

}
