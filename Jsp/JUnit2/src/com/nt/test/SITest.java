package com.nt.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.service.SimpleIntrest;

public class SITest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("SITest.setUpBeforeClass()");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("SITest.tearDownAfterClass()");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("SITest.setUp()");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("SITest.tearDown()");
	}

	@Test
	public void testByPositive() {
		int actualResult=0;
		int expectedResult=80;
		
		actualResult=SimpleIntrest.simpleintrest(2000,2,2);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected =IllegalArgumentException.class)
	public void testByNegetive() {
		int actualResult=0;
		int expectedResult=80;
		
		actualResult=SimpleIntrest.simpleintrest(2000,-2,2);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testByZero() {
		int actualResult=0;
		int expectedResult=0;
		
		actualResult=SimpleIntrest.simpleintrest(2000,2,0);
		assertEquals(expectedResult, actualResult);
	}

}
