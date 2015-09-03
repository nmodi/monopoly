package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Board;
import com.flippedshield.monopoly.Game;
import com.flippedshield.monopoly.PropertySpace;
import com.flippedshield.monopoly.Space;

public class WhenASpaceIsAPropertySpace {
	
	private Game game;
	private Board board;
	private ArrayList<Space> spaces;

	@Before
	public void setUp() throws Exception 
	{
		game = new Game();
		board = game.getBoard();
		spaces = board.getSpaces();
	}

	@Test
	public void shouldHaveAnEmptyBuildingTokenList() {
		PropertySpace property;
		ArrayList<PropertySpace> properties = new ArrayList<PropertySpace>();
		
		for(Space s : spaces)
		{
			if(s instanceof PropertySpace)
			{
				properties.add((PropertySpace) s);
			}
		}
		
		for(PropertySpace p : properties)
		{
			assertTrue("Property space did not have an empty building token", p.getBuildingTokenList().isEmpty());
		}
	}

}
