package com.flippedshield.monopoly;

import java.util.ArrayList;

public class Bank {
	
	private ArrayList<Deed> deeds; 
	
	public Bank(){
		deeds = new ArrayList<Deed>(); 	
	}
	
	
	public ArrayList<Deed> getDeeds(){ return deeds; } 

}
