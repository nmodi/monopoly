package com.flippedshield.monopoly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Board {
	
	private static final String PROPERTIES_FILE = "properties.txt"; 
	private static final String CARD_INFORMATION_JSON = "cardInformation.json"; 
	
	private ArrayList<Player> players;
	private Die die;
	private ArrayList<Card> bigFunCards;
	private ArrayList<Card> contingencyCards;
	private ArrayList<Space> spaces; 
	
	public Board()
	{
		initPlayers();
		die = new Die();
		initBigFunCards();
		initContingencyCards();
		try {
			initSpaces();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private void initPlayers()
	{
		players = new ArrayList<Player>();
		
		players.add(new Player("Nilay", 200));
		players.add(new Player("Jacob", 200));
		players.add(new Player("Derek", 200));
	}
	
	/**
	 * Creates the spaces list and fills it with space objects
	 * @throws IOException
	 */
	private void initSpaces() throws IOException{
		spaces = new ArrayList<Space>(40);
		BufferedReader br = new BufferedReader(new FileReader(PROPERTIES_FILE));
		try { 
			String line = br.readLine(); 
			while (line != null) {
				spaces.add(new Space(line));
				line = br.readLine(); 
			}	
		} finally {
			br.close(); 
		}
	}
	
	/**
	 * Creates big fun card list and fills it with cards
	 */
	private void initBigFunCards()
	{
		bigFunCards = new ArrayList<Card>();
		
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader(CARD_INFORMATION_JSON));
			JSONObject jsonObj = (JSONObject) obj;
			
			JSONArray cards = (JSONArray) jsonObj.get("bigFunCards");
			
			Iterator<JSONObject> iterator = cards.iterator();
			
			while(iterator.hasNext())
			{
				bigFunCards.add(new Card(iterator.next()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates contingency card list and fills it with cards
	 */
	private void initContingencyCards()
	{
		contingencyCards = new ArrayList<Card>();
		
		JSONParser parser = new JSONParser();
		
		try {
			Object obj = parser.parse(new FileReader(CARD_INFORMATION_JSON));
			JSONObject jsonObj = (JSONObject) obj;
			
			JSONArray cards = (JSONArray) jsonObj.get("contingencyCards");
			
			Iterator<JSONObject> iterator = cards.iterator();
			
			while(iterator.hasNext())
			{
				contingencyCards.add(new Card(iterator.next()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * === GETTERS AND SETTERS  ==================================
	 */
	public ArrayList<Player> getPlayers() { return players; }
	public Die getDie() { return die; }
	public ArrayList<Card> getBigFunCards() { return bigFunCards; }
	public ArrayList<Card> getContingencyCards() { return contingencyCards; }
	public ArrayList<Space> getSpaces() { return spaces; } 

}
