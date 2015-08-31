package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
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
		final int expectedMax = 6;
		int[] roll;
		
		die = new Die(sides);
		
		roll = die.roll(2);
		
		
		
		for(int i = 0; i < roll.length; i++)
		{
			if(roll[i] < 0)
			{
				throw new Exception("Dice " + i + " roll is less than 0");
			} else if(roll[i] > expectedMax)
			{
				throw new Exception("Dice " + i + " roll is greater than max");
			}
		}
	}

}
