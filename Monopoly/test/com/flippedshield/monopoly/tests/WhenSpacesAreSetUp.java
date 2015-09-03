package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Board;
import com.flippedshield.monopoly.Game;
import com.flippedshield.monopoly.Space;

public class WhenSpacesAreSetUp {
	
	private Game game;
	private Board board;

	@Before
	public void setUp() throws Exception 
	{
		game = new Game();
		board = game.getBoard();
	}

	@Test
	public void shouldBeFourtySpacesOnBoard() {
		ArrayList<Space> spaces = board.getSpaces();
		
		assertTrue("There were not 40 spaces on the board", spaces.size() == 40);
	}
	
	@Test
	public void SpacesShouldHaveNames()
	{
		ArrayList<Space> spaces = game.getBoard().getSpaces();
		
		System.out.println(Game.getBank().getDeeds().get(Game.getBank().getDeeds().size()-1).getName());
		
		if(spaces.isEmpty())
		{
			fail("Spaces list is empty");
			
		} else
		{
			for (Space s : spaces){
				if (s.getName() == null || s.getName() == null){
					fail("Space #" + spaces.indexOf(s) + " name was empty"); 
				}
			}
		}
	}

}
