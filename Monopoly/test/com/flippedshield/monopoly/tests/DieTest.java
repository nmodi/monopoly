package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Die;

public class DieTest {
	
	private Die die;

	@Before
	public void setUp() throws Exception {
		die = new Die();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/**
	 * test no param roll returns populated array
	 */
	public void testRollNoParams() 
	{
		assertNotNull(die.roll());
	}
	
	@Test
	/**
	 * test roll with params returns populated array
	 */
	public void testRollWithParams() 
	{
		assertNotNull(die.roll(2));
	}

}
