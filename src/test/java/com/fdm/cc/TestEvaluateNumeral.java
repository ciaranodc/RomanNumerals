package com.fdm.cc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.cc.exceptions.InvalidNumeralException;
import com.fdm.cc.model.EvaluateNumeral;

public class TestEvaluateNumeral {
	
	EvaluateNumeral en = new EvaluateNumeral();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() throws InvalidNumeralException {
		assertEquals(1, en.convertNumeral("I"));
	}
	
	@Test
	public void test2()  throws InvalidNumeralException {
		assertEquals(2, en.convertNumeral("II"));
	}
	
	@Test
	public void test3()  throws InvalidNumeralException {
		assertEquals(3, en.convertNumeral("III"));
	}
	
	@Test
	public void test4()  throws InvalidNumeralException {
		assertEquals(5, en.convertNumeral("V"));
	}
	
	@Test
	public void test5()  throws InvalidNumeralException {
		assertEquals(10, en.convertNumeral("X"));
	}
	
	@Test
	public void test6()  throws InvalidNumeralException {
		assertEquals(50, en.convertNumeral("L"));
	}

	@Test
	public void test7()  throws InvalidNumeralException {
		assertEquals(100, en.convertNumeral("C"));
	}
	
	@Test
	public void test8()  throws InvalidNumeralException {
		assertEquals(500, en.convertNumeral("D"));
	}
	
	@Test
	public void test9()  throws InvalidNumeralException {
		assertEquals(1000, en.convertNumeral("M"));
	}

	@Test
	public void test10() throws InvalidNumeralException {
		assertEquals(4, en.convertNumeral("IV"));
	}
	
	@Test
	public void test11() throws InvalidNumeralException {
		assertEquals(14, en.convertNumeral("VIX"));
	}
	
	@Test
	public void test12() throws InvalidNumeralException{
		assertEquals(3911, en.convertNumeral("MMMCMXI"));
	}
	
	@Test
	public void test13() throws InvalidNumeralException{
		assertEquals(1999, en.convertNumeral("MCMXCIX"));
	}
	
	@Test
	public void test14() throws InvalidNumeralException {
		assertEquals(3561, en.convertNumeral("MMMDLXI"));
	}
	
	@Test
	public void test15() throws InvalidNumeralException {
		assertEquals(4999, en.convertNumeral("MMMMCMXCIX"));
	}
	
	@Test
	public void test16() throws InvalidNumeralException {
		assertEquals(9999, en.convertNumeral("MMMMMMMMMCMXCIX"));
	}
	
	@Test(expected=InvalidNumeralException.class)
	public void testInvalidNumeral() throws InvalidNumeralException {
		en.convertNumeral("IXB");
		fail();
	}
	
}
