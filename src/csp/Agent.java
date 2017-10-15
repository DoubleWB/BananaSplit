package csp;

import java.util.ArrayList;
import java.util.HashMap;

import resources.*;

public class Agent {
	
	private ArrayList<State> explored;
	private ArrayList<State> toExplore;
	private State start;
	
	public Agent(State s) {
		this.start = s;
		this.explored = new ArrayList<State>();
		this.toExplore = new ArrayList<State>();
		this.toExplore.add(start);
	}
	
	public HashMap<Person, Integer> optimalAssignments() {
		HashMap<Person, Integer> solution = new HashMap<Person, Integer>();
		int failCount = 0;
		State optimal = this.start;
		while (optimal.total() != 100) {
			System.out.println(optimal);
			optimal = optimal.successor();
		}
		return optimal.getAssignments();
	}

}
