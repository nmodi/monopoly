package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Bank;
import com.flippedshield.monopoly.BankerPlayer;
import com.flippedshield.monopoly.Deed;
import com.flippedshield.monopoly.Game;

public class WhenTheBankIsCreated {
	
	private Game game;
	private Bank bank;

	@Before
	public void setUp() throws Exception 
	{
		game = new Game();
		bank = game.getBank();
	}

	@Test
	public void shouldHaveAListOfDeedsForEveryOwnableProperty() {
		ArrayList<Deed> deeds = bank.getDeeds();
		ArrayList<Deed> bankOwnedDeeds = new ArrayList<Deed>(deeds.size());
		
		for(Deed d : deeds)
		{
			if(d.getOwner() instanceof BankerPlayer)
			{
				bankOwnedDeeds.add(d);
				System.out.println(d.getName() + " owned by bank");
			}
		}
		
		assertTrue("Bank deed list was not the size it should have been", bankOwnedDeeds.size() == deeds.size());
	}

}
