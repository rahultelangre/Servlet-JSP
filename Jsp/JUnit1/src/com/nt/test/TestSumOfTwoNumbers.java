package com.nt.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nt.service.AddTwoNumbers;

public class TestSumOfTwoNumbers {

	static AddTwoNumbers sum=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sum=new AddTwoNumbers();
		System.out.println("TestSumOfTwoNumbers.setUpBeforeClass()");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TestSumOfTwoNumbers.tearDownAfterClass()");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("TestSumOfTwoNumbers.setUp()");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TestSumOfTwoNumbers.tearDown()");
	}

	@Test
	public void testAddtwoNoPositive() {
		int actualResult=0;
		int expectedResult=8;
		actualResult=AddTwoNumbers.sum(4,4);
		assertEquals(expectedResult, actualResult);
		/* fail("Not Yet implements")*/
	}
	
	@Test(expected =IllegalArgumentException.class )
	public void testByNegetive() {
		int actualResult=0;
		int expectedResult=-8;
		actualResult=AddTwoNumbers.sum(-4,-4);
		assertEquals(expectedResult, actualResult);
		/* fail("Not Yet implements")*/
	}
	@Test
	public void testPositiveWithZero() {
		int actualResult=0;
		int expectedResult=4;
		actualResult=AddTwoNumbers.sum(4,0);
		assertEquals(expectedResult, actualResult);
		/* fail("Not Yet implements")*/
	}

	

}
