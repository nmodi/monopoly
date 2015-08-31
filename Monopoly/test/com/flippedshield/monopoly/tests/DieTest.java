package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.flippedshield.monopoly.Die;

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
	public void testRollReturnsValuesBetweenOneAndSix() throws Exception
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

}
