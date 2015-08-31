package com.flippedshield.monopoly.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.flippedshield.monopoly.Die;

public class DieTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRoll() {
		Die die = new Die();
		
		assertNotNull(die.roll());
	}

}
