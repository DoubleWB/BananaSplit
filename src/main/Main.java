package main;

import java.util.ArrayList;
import resources.*;

public class Main {
	
	private static ArrayList<Person> people = new ArrayList<Person>();
	private static ArrayList<Item> outstandingItems = new ArrayList<Item>();
	
	public void on_Finished(Item finished) {
		people.get(0).split(finished, 1, this.people);
	}
		
	public static void main(String[] args) {
		
		System.out.println(people.size());
		
	}

}
