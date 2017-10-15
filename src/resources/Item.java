package com.example.bananasplittoon.resources;

public class Item {
	
	private int iId;
	private double price;
	private String name;
	
	public Item() {
		this.iId = 0;
		this.name = "";
		this.price = 0.0;
	}
	
	public Item(int iId, String name, double price) {
		this.iId = iId;
		this.name = name;
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public boolean equals(Item other) {
		return this.iId == other.iId;
	}

}
