package com.flippedshield.monopoly.tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.flippedshield.monopoly.Board;
import com.flippedshield.monopoly.FeeSpace;
import com.flippedshield.monopoly.Game;
import com.flippedshield.monopoly.Space;

public class WhenASpaceIsAFeeSpace {

	private Game game;
	private Board board;
	private ArrayList<Space> spaces;
	private ArrayList<FeeSpace> feeSpaces;

	@Before
	public void setUp() throws Exception 
	{
		game = new Game();
		board = game.getBoard();
		spaces = board.getSpaces();
		
		feeSpaces = new ArrayList<FeeSpace>();
		
		for(Space s : spaces)
		{
			if(s instanceof FeeSpace)
			{
				feeSpaces.add((FeeSpace) s);
			}
		}
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shouldHaveNotAnyTokens() throws ClassNotFoundException, NoSuchFieldException, SecurityException {
//		Class space = Class.forName("com.flippedshield.monopoly");
//		
//		for(FeeSpace p : feeSpaces)
//		{
//			thrown.expect(NoSuchFieldException.class);
//			thrown.expect(SecurityException.class);
//			
//			Field field = space.getField("buildingTokenList");
//		}
		
		fail("not yet implemented");
	}

}
