package com.fdm.cc.model;

import com.fdm.cc.exceptions.InvalidNumeralException;

public class EvaluateNumeral {

	/**
	 * Takes string of Roman numerals 'str' and returns the decimal value.
	 * @param str
	 * @return
	 * @throws InvalidNumeralException
	 */
	public int convertNumeral(String str) throws InvalidNumeralException {
		RomanNumeral[] rnArr = convertToNumeralArray(str);
		int result = 0;
		
		for (int i=0; i<rnArr.length; i++) {
			int current = i, next = i+1, last = rnArr.length-1;
			if (current == last)
				return result + rnArr[current].getValue();
			else if (rnArr[current].getValue() < rnArr[next].getValue()) {
				result += rnArr[next].getValue() - rnArr[current].getValue();
				i++;
			}
			else
				result += rnArr[current].getValue();
		}
		
		return result;
	}
	
	/**
	 * Takes string of Roman numerals 'str' and returns a character array of
	 * RomanNumeral types.
	 * @param str
	 * @return
	 * @throws InvalidNumeralException
	 */
	private RomanNumeral[] convertToNumeralArray(String str) throws InvalidNumeralException {
		RomanNumeral[] rnArr = new RomanNumeral[str.length()];
		for (int i=0; i<str.length(); i++) {
			if (isNumeral(str.charAt(i)))
				rnArr[i] = new RomanNumeral(str.charAt(i));
			else
				throw new InvalidNumeralException();
		}
		return rnArr;
	}
	
	/**
	 * Is 'numeral' a Roman numeral.
	 * @param numeral
	 * @return
	 */
	private boolean isNumeral(char numeral) {
    	if (RomanNumeral.NUMERALS.indexOf(numeral) >= 0)
    		return true;
    	return false;
    }

}
