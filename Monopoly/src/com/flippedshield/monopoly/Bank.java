package com.flippedshield.monopoly;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Bank {
	private Bank instance; 
	
	static final String DEED_JSON = "deeds.json";
	
	private static ArrayList<Deed> deeds; 
	
	public Bank() {
		initBank();	
	} 
	
	public static void initBank(){
		initDeeds();	
	}
	
	public Bank getInstance(){
		if (instance == null){
			instance = new Bank(); 
			initBank(); 
		}
		
		return instance; 
	}
	
	public static void initDeeds()
	{
		deeds = new ArrayList<Deed>();
		
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader(DEED_JSON));
			JSONObject jsonObj = (JSONObject) obj;
			
			JSONArray deedArray = (JSONArray) jsonObj.get("deeds");
			
			Iterator<JSONObject> iterator = deedArray.iterator();
			
			while(iterator.hasNext())
			{
				JSONObject deed = iterator.next();
				deeds.add(
						new Deed(
							(String)deed.get("name"), 
							(String)deed.get("owner"),
							(String)deed.get("color"), 
							(long)deed.get("mortgage"), 
							(long)deed.get("blockCost"), 
							(long)deed.get("keyCost"), 
							(long)deed.get("baseRent"), 
							(long)deed.get("oneBlock"), 
							(long)deed.get("twoBlock"), 
							(long)deed.get("threeBlock"), 
							(long)deed.get("fourBlock"), 
							(long)deed.get("keyToCity") 
						));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		BankerPlayer.getBanker().setOwnedDeeds(deeds);
	}
	
	public ArrayList<Deed> getDeeds(){ return deeds; } 

}
