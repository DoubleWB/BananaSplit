package com.example.bananasplittoon.resources;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import com.example.bananasplittoon.csp.*;

public class Group implements Serializable{
	private ArrayList<Person> people;
	private ArrayList<Receipt> receipts;
	private ArrayList<Item> noMansLand;
	private int dShare = 25;
	
	public Group() {
		this.people = new ArrayList<Person>();
		this.receipts = new ArrayList<Receipt>();
		this.noMansLand = new ArrayList<Item>();
	}
	
	public Group(ArrayList<Person> people) {
		this.people = people;
		this.receipts = new ArrayList<Receipt>();
		this.noMansLand = new ArrayList<Item>();
	}

	
	public void on_Finished(Item finished, Person finisher, Context c, Intent i) {
		for (Receipt r : this.receipts) {
			if (r.getOwner().acceptItemBought(r, finished)) {
				this.split(this.gatherConsumers(finished), finished, r.getOwner(), c, i);
				return;
			}
		}
	}
	
	public void split(ArrayList<Person> consumers, Item i, Person owner, Context c, Intent in) {
		int percentage = (100 / people.size());
		HashMap<Person, Integer> shares = new HashMap<Person, Integer>();
		HashMap<Person, Integer> satisfactions = new HashMap<Person, Integer>();
		for (Person p : people) {
			shares.put(p, percentage);
			satisfactions.put(p, 0);
		}
		for (Person p : people) {
			if (p.getId() != 10001) {
				satisfactions.put(p, p.rateSatisfaction(shares.get(p), i, c, in));
			}
			else {
				satisfactions.put(p, dShare);
			}
		}
		Agent solutionFinder = new Agent(new State(satisfactions, satisfactions));
		shares = solutionFinder.optimalAssignments();
		
		for (Person p : shares.keySet()) {
			p.addDebt(new Debt(owner, shares.get(p)*i.getPrice()/100));
		}
	}
	
	public double getTotalSatisfaction() {
		return 0;
	}
	
	public ArrayList<Person> gatherConsumers(Item i) {
		ArrayList<Person> output = new ArrayList<Person>();
		for (Person p : people) {
			if (p.optIn(i)) {
				output.add(p);
			}
		}
		return output;
	}

	public Person getById(int id) {
		for (Person p : people) {
			if (p.getId() == id) {
				return p;
			}
		}
		throw new IllegalArgumentException("ID not in list");
	}

	public void addReceipt(Receipt r) {
		this.receipts.add(r);
	}
	
	// add to arrayList
	public void addPerson(Person person) {
		this.people.add(person);
	}
	
	// remove from arrayList
	public void removePerson(Person person) {
		this.people.remove(person);
	}

	private void purgeReceipts() {
		for (int i = 0; i < receipts.size(); i ++) {
			Receipt r = receipts.get(i);
			if (r.getFlaggedForDeletion()) {
				i--;
				receipts.remove(r);
			}
		}
	}

	public void setDesire(int des) {
		this.dShare = des;
	}
	/*// add to HashMap
	void addtoMap(Item item, Person person) {
		this.outstandingItems.put(item, person);
	}
	
	// remove from HashMap
	void removeFromMap(Item item) {
		this.outstandingItems.remove(item);
	}*/
}
