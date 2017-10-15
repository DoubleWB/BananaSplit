package com.example.bananasplittoon.resources;

import java.io.Serializable;

public class Debt implements Serializable{
	
	private Person owed;
	private double amount;
	
	public Debt(Person owed, double amount) {
		this.owed = owed;
		this.amount = amount;
	}
	
	public String toString() {
		return this.owed.toString() + " is owed: " + amount + "\n";
	}

}
