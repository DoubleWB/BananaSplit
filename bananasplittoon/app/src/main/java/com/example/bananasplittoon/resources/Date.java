package com.example.bananasplittoon.resources;

import java.io.Serializable;
import java.util.HashMap;

public class Date implements Serializable{
	
	private HashMap<Integer, Integer> limits = new HashMap<Integer, Integer>();
	
	private int month;
	private int day;
	
	//IGNORING YEARS FOR THE TIME BEING

	public Date(int month, int day) {
		populateLimits();
		if (0 < month && month <= 12) {
			this.month = month;
		}
		else {
			throw new IllegalArgumentException("Invalid Month Number");
		}
		if (0 < day && day <= limits.get(this.month)) {
			this.month = month;
		}
		else {
			throw new IllegalArgumentException("Invalid Day Number");
		}
	}
	
	public int compareTo(Date other) {
		if (this.month != other.month) {
			return this.month - other.month; 
		}
		else {
			return this.day - other.day;
		}
	}
	
	public boolean equals(Date other) {
		return (this.compareTo(other) == 0);
	}
	
	private void populateLimits() {
		limits.put(1, 31);
		limits.put(2, 28);
		limits.put(3, 31);
		limits.put(4, 30);
		limits.put(5, 31);
		limits.put(6, 30);
		limits.put(7, 31);
		limits.put(8, 31);
		limits.put(9, 30);
		limits.put(10, 31);
		limits.put(11, 30);
		limits.put(12, 31);
	}
}
