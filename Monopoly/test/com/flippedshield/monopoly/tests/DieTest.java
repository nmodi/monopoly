package com.flippedshield.monopoly.tests;


import static org.junit.Assert.*;
import org.junit.Test;

import com.flippedshield.monopoly.Die;
import com.flippedshield.monopoly.exceptions.InvalidRollValueException;


public class DieTest {
	
	private Die die;

	@Test
	/**
	 * test no param roll returns populated array
	 */
	public void testRollNoParams() 
	{
		die = new Die();
		assertNotNull(die.roll());
	}
	
	@Test
	/**
	 * test roll with params returns populated array
	 */
	public void testRollWithParams() 
	{
		die = new Die(6);
		assertNotNull(die.roll(4));
	}
	
	@Test
	public void testRollReturnsValuesBetweenOneAndSix() throws InvalidRollValueException
	{
		int sides = 6;
		int[] roll;
		
		die = new Die(sides);
		
		roll = die.roll(2);
		
		for(int i = 0; i < roll.length; i++)
		{
			if(roll[i] < 0)
			{
				fail("Dice " + i + " roll is less than 0");
			} else if(roll[i] > die.getNumberOfSides())
			{
				fail("Dice " + i + " roll is greater than max");
			}
		}
	}
	
	@Test
	/**
	 * test that double dice roll returns 2 outputs
	 */
	public void testReturnArrayLength(){
		boolean arrayLengthEqual = (die.roll(2).length == 2);
		assertTrue(arrayLengthEqual); 		
	}
	
	@Test
	/**
	 * test that double dice roll doesn't return 1 output
	 */
	public void testReturnArrayLengthFalse(){
		boolean arrayLengthEqual = (die.roll(2).length == 1);
		assertFalse(arrayLengthEqual); 		
	}
}
