package com.fdm.cc.model;

/**
 * Hello world!
 *
 */
public class RomanNumeral {
	
	public static final String NUMERALS = "IVXLCDM";
	
    private char numeral;
    private int value;
    
    public RomanNumeral(char numeral) {
    	this.numeral = numeral;
    	
    	if (numeral == 'I')
    		value = 1;
    	if (numeral == 'V')
    		value = 5;
    	if (numeral == 'X')
    		value = 10;
    	if (numeral == 'L')
    		value = 50;
    	if (numeral == 'C')
    		value = 100;
    	if (numeral == 'D')
    		value = 500;
    	if (numeral == 'M')
    		value = 1000;
    }
    
    public int getValue() {
		return value;
	}
    
    public char getNumeral() {
		return numeral;
	}
    
}
