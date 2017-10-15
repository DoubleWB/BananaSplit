package com.example.bananasplittoon.resources;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static android.support.v4.content.ContextCompat.startActivity;

public class Person implements Serializable{
	
	private int pId;
	private String name;
	private ArrayList<Debt> debts;
	private int value = 0;
	
	public Person(int pId, String name) {
		this.pId = pId;
		this.name = name;
		this.debts = new ArrayList<Debt>();
	}
	
	public boolean acceptItemBought(Receipt owned, Item finished) {
		owned.flagForDeletion();
		return true;
	}
	
	public boolean optIn(Item i) {
		return true;
	}
	
	public int rateSatisfaction(int share, Item i, Context c, Intent in) {
		//100 is perfectly satisfied, 0 is 'I should pay 100% less', 200 is 'I should pay 100% more')
		in.putExtra("item", i);
		in.putExtra("share", share);
		in.putExtra("me", this.value);
		in.setType("meme");
		//c.startActivity(in);
		System.out.println(in.getType());
		return (int) ((80.0/100) * in.getIntExtra("share", 0));
	}

	public ArrayList<Debt> getDebts() {
		return this.debts;
	}
	
	public void addDebt(Debt d) {
		this.debts.add(d);
	}
	
	public String toString() {
		return this.name;
	}

	public int getId() {
		return this.pId;
	}

	public boolean equals(Person other) {
		return this.pId == other.pId;
	}
}
