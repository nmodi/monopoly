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
	private static final String TOKENS_JSON = "tokens.json";
	private static final String PLAYERS_JSON = "players.json";
	
	private ArrayList<Player> players;
	private Die die;
	private ArrayList<Card> bigFunCards;
	private ArrayList<Card> contingencyCards;
	private ArrayList<Space> spaces; 
	private ArrayList<PlayerToken> playerTokens; 
	
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
		initTokens(); 
	}
	
	private void initPlayers()
	{
		players = new ArrayList<Player>(); 
		JSONParser parser = new JSONParser(); 
		try {
			Object obj = parser.parse(new FileReader(PLAYERS_JSON)); 
			JSONObject jsonObj = (JSONObject) obj; 
			JSONArray jsonPlayers = (JSONArray) jsonObj.get("players"); 
			Iterator<JSONObject> iterator = jsonPlayers.iterator(); 
			while(iterator.hasNext()){
				players.add(new Player(iterator.next())); 
			} 
			} catch (IOException | ParseException e){
				e.printStackTrace();
		}
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
	
	/**
	 * Creates list of Tokens and initializes it from TOKENS_JSON file 
	 */
	private void initTokens(){
		playerTokens = new ArrayList<PlayerToken>(); 
		JSONParser parser = new JSONParser(); 
		try {
			Object obj = parser.parse(new FileReader(TOKENS_JSON)); 
			JSONObject jsonObj = (JSONObject) obj; 
			JSONArray tokens = (JSONArray) jsonObj.get("tokens"); 
			Iterator<JSONObject> iterator = tokens.iterator(); 
			while(iterator.hasNext()){
				playerTokens.add(new PlayerToken(iterator.next())); 
			} 
			} catch (IOException | ParseException e){
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
	public ArrayList<PlayerToken> getTokens() { return playerTokens; } 

}
