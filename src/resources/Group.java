package resources;

import java.util.ArrayList;
import java.util.HashMap;

public class Group {
	private ArrayList<Person> people;
	private HashMap<Item, Person> outstandingItems;
	
	Group() {
		this.people = new ArrayList<Person>();
		this.outstandingItems = new HashMap<Item, Person>();
	}
	
	Group(ArrayList<Person> people, HashMap<Item, Person> outstandingItems) {
		this.people = people;
		this.outstandingItems = outstandingItems;
	}
	
	
	public void on_Finished(Item finished) {
		people.get(0).split(finished, 0, people, outstandingItems);
	}
	
	// add to arrayList
	void addToList(Person person) {
		this.people.add(person);
	}
	
	// remove from arrayList
	void removeFromList(Person person) {
		this.people.remove(person);
	}
	
	// add to HashMap
	void addtoMap(Item item, Person person) {
		this.outstandingItems.put(item, person);
	}
	
	// remove from HashMap
	void removeFromMap(Item item) {
		this.outstandingItems.remove(item);
	}
}
