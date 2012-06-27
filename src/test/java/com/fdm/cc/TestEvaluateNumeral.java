package com.fdm.cc;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fdm.cc.exceptions.InvalidNumeralException;
import com.fdm.cc.model.EvaluateNumeral;

public class TestEvaluateNumeral {
	
	EvaluateNumeral en = new EvaluateNumeral();
	
	@Test(expected=InvalidNumeralException.class)
	public void testConvertNumeralReturnsForInvalidNumeral() throws InvalidNumeralException {
		en.convertNumeral("IXB");
		fail();
	}

	@Test
	public void testConvertNumeralReturnsCorrectResultsForSingleNumerals() throws InvalidNumeralException {
		assertEquals(1, en.convertNumeral("I"));
		assertEquals(5, en.convertNumeral("V"));
		assertEquals(10, en.convertNumeral("X"));
		assertEquals(50, en.convertNumeral("L"));
		assertEquals(100, en.convertNumeral("C"));
		assertEquals(500, en.convertNumeral("D"));
		assertEquals(1000, en.convertNumeral("M"));
	}
	
	@Test
	public void testConvertNumeralForMoreThanOneIValue()  throws InvalidNumeralException {
		assertEquals(2, en.convertNumeral("II"));
		assertEquals(3, en.convertNumeral("III"));
	}
	
	@Test
	public void testConvertNumeralForSmallerNumeralBeforeLargerNumeral()  throws InvalidNumeralException {
		assertEquals(4, en.convertNumeral("IV"));
		assertEquals(9, en.convertNumeral("IX"));
		assertEquals(49, en.convertNumeral("IL"));
	}
	
	@Test
	public void testConvertNumeralForVariousNumeralCombinations() throws InvalidNumeralException {
		assertEquals(14, en.convertNumeral("VIX"));
		assertEquals(3911, en.convertNumeral("MMMCMXI"));
		assertEquals(1999, en.convertNumeral("MCMXCIX"));
		assertEquals(3561, en.convertNumeral("MMMDLXI"));
		assertEquals(4999, en.convertNumeral("MMMMCMXCIX"));
		assertEquals(9999, en.convertNumeral("MMMMMMMMMCMXCIX"));
	}
	
	
	
}
