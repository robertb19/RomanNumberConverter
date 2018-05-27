package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import converter.Rome;

public class ConverterTests {
	
	@Before
	public void beforeTest() {
		Rome.fillArabicToRomanMap();
	}
	
	@Test
	public void romanNumbersWithSignBeforeTest() {
		assertEquals(9, Rome.getArabicFromRoman("IX"));
		assertEquals(24, Rome.getArabicFromRoman("XXIV"));
		assertEquals(64, Rome.getArabicFromRoman("LXIV"));
		assertEquals(89, Rome.getArabicFromRoman("LXXXIX"));
		assertEquals(209, Rome.getArabicFromRoman("CCIX"));
		assertEquals(314, Rome.getArabicFromRoman("CCCXIV"));
	}
	
	@Test
	public void romanWithSignsAfter(){
		assertEquals(16, Rome.getArabicFromRoman("XVI"));
		assertEquals(8, Rome.getArabicFromRoman("VIII"));
		assertEquals(208, Rome.getArabicFromRoman("CCVIII"));
		assertEquals(307, Rome.getArabicFromRoman("CCCVII"));
		assertEquals(316, Rome.getArabicFromRoman("CCCXVI"));
		assertEquals(758, Rome.getArabicFromRoman("DCCLVIII"));
		assertEquals(888, Rome.getArabicFromRoman("DCCCLXXXVIII"));
	}
	
	@Test
	public void wholeRomanNumbers(){
		assertEquals(5, Rome.getArabicFromRoman("V"));
		assertEquals(10, Rome.getArabicFromRoman("X"));
		assertEquals(20, Rome.getArabicFromRoman("XX"));
		assertEquals(30, Rome.getArabicFromRoman("XXX"));
		assertEquals(15, Rome.getArabicFromRoman("XV"));
		assertEquals(205, Rome.getArabicFromRoman("CCV"));
		assertEquals(375, Rome.getArabicFromRoman("CCCLXXV"));
	}
	
	@Test
	public void largeRomanNumbers(){
		assertEquals(998, Rome.getArabicFromRoman("CMXCVIII"));
		assertEquals(872, Rome.getArabicFromRoman("DCCCLXXII"));
		assertEquals(738, Rome.getArabicFromRoman("DCCXXXVIII"));
		assertEquals(588, Rome.getArabicFromRoman("DLXXXVIII"));
		assertEquals(1000, Rome.getArabicFromRoman("M"));
		assertEquals(750, Rome.getArabicFromRoman("DCCL"));
		assertEquals(800, Rome.getArabicFromRoman("DCCC"));
	}
	
	

}
