package main;

import java.util.ArrayList;
import java.util.HashMap;

import resources.*;

public class Main {
		
	public static void main(String[] args) {
		Group g = new Group();
		Person a = new Person(0, "Anthony");
		Person k = new Person(1, "Kevin");
		Person m  = new Person(2, "Matteus");
		Person n  = new Person(3, "Nick");
		Person w  = new Person(4, "Will");
		g.addPerson(a);
		g.addPerson(k);
		g.addPerson(m);
		g.addPerson(n);
		g.addPerson(w);
		g.addReceipt(new Receipt(a, null, new Date(12, 1)));
		Item i = new Item(0, "Milk", 5);
		g.on_Finished(i, a);
		System.out.println(k.getDebts().get(0));
		System.out.println(a.getDebts().get(0));
	}

}
