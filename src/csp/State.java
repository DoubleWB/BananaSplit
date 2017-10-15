package com.example.bananasplittoon.csp;

import java.util.ArrayList;
import java.util.HashMap;
import com.example.bananasplittoon.resources.*;

public class State {

	private HashMap<Person, Integer> assignments;
	private HashMap<Person, Integer> desired;
	
	public State() {
		assignments = new HashMap<Person, Integer>();
		desired = new HashMap<Person, Integer>();
	}
	
	public State(HashMap<Person, Integer> assignments, HashMap<Person, Integer> desired) {
		this.assignments = new HashMap<Person, Integer>(assignments);
		this.desired = new HashMap<Person, Integer>(desired);
	}
	
	public State successor() {
		Person leastUnhappy = (Person) assignments.keySet().toArray()[0];
		int difference = Integer.MAX_VALUE;
		for (Person p : assignments.keySet()) {
			int tempDiff = (desired.get(p) - assignments.get(p));
			if (Math.abs(difference) > Math.abs(tempDiff)) {
				difference = tempDiff;
				leastUnhappy = p;
			}
		}
		if (this.total() < 100) {
			assignments.put(leastUnhappy, assignments.get(leastUnhappy) + 1);
		}
		else {
			assignments.put(leastUnhappy, assignments.get(leastUnhappy) - 1);
		}
		return new State(assignments, desired);
	}
	
	public int score() {
		int score = 0;
		for (Person p : assignments.keySet()) {
			score += Math.abs(assignments.get(p) - desired.get(p));
		}
		return score;
	}
	
	public boolean equals(State other) {
		for(Person p : this.assignments.keySet()) {
			if (!other.assignments.containsKey(p) || other.assignments.get(p) != this.assignments.get(p)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isComplete() {
		for (Person p : assignments.keySet()) {
			if (assignments.get(p) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public HashMap<Person, Integer> getAssignments() {
		return this.assignments;
	}
	
	public String toString() {
		String output = "";
		for (Person p : assignments.keySet()) {
			output += p.toString() + ":  " + assignments.get(p) + " ";
		}
		return output;
	}
	
	public int total() {
		int output = 0;
		for (Person p : assignments.keySet()) {
			output +=  assignments.get(p);
		}
		return output;
	}
}
