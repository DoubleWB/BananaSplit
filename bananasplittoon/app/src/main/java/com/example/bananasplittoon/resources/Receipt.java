package com.example.bananasplittoon.resources;

import android.graphics.Canvas;

import java.io.Serializable;
import java.util.ArrayList;
import android.graphics.Paint;

public class Receipt implements Serializable{
	
	private Person owner;
	private Canvas image;
	private Date boughtOn;
	private ArrayList<Integer> dividers;
	private static int fudgeFactor = 1000;
	private boolean flagged = false;
	
	public Receipt(Person owner, Canvas i, Date d) {
		this.owner = owner;
		this.image = i;
		this.boughtOn = d;
		//findDividers();
	}
	
	public Person getOwner() {
		return this.owner;
	}

	public void flagForDeletion() {
		this.flagged = true;
	}

	public boolean getFlaggedForDeletion() {
		return this.flagged;
	}
	public void addCross(int x, int y) { // Assuming good touch information
		int top = 0;
		int bottom = 0;
		for(int div = 0; div < dividers.size(); div ++) {
			if (y < dividers.get(div) && div%2==1) {
				top = dividers.get(div - 1);
				bottom = dividers.get(div);
			}
		}
		image = new Canvas();
		Paint p = new Paint();
		image.drawRect(0, (bottom - top)/2 + top, image.getWidth(), 2, new Paint()); //Draw a thin line
	}
	
	public void findDividers() {
		ArrayList<Integer> rowSums = new ArrayList<Integer>();
		for(int row = 0; row < image.getHeight(); row++) {
			int rowSum = 0;
			for(int col = 0; col < image.getWidth(); col++) {
				rowSum += 0;
			}
			rowSums.add(rowSum);
		}
		boolean decreasing = true;
		int last = Integer.MAX_VALUE;
		for(int i = 0; i < rowSums.size(); i++) {
			if(decreasing) {
				if(rowSums.get(i) > last + fudgeFactor) {
					decreasing = false;
					dividers.add(i);
				}
				else {
					if(rowSums.get(i) + fudgeFactor < last ) {
						decreasing = true;
						dividers.add(i);
					}
				}
			}
		}
	}
}
