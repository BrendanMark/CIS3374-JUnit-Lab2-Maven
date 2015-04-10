package com.lab2.FareCalculator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lab2.transit.FareCalculator;

@RunWith(Parameterized.class)
public class FareCalculatorTest {
	
	private static final double DELTA = 1e-15;
	private FareCalculator calculator;
	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;
	
	public FareCalculatorTest(double expected, int age, String time, boolean isHoliday){
		this.expected = expected;
		this.age = age;
		this.time = time;
		this.isHoliday = isHoliday;
	}
	
	@Parameters
	public static Collection<Object[]> testParams(){
		return Arrays.asList(new Object[][] {
				{0.0, 4, "6:00", false}, {0.0, 5, "6:00", false}, {2.5, 6, "6:00", false}, {2.5, 64, "6:00", false}, {0.0, 65, "6:00", false}, {0.0, 66, "6:00", false},
				{0.0, 4, "6:59", false}, {2.5, 4, "7:00", false}, {2.5, 4, "7:01", false}, {2.5, 4, "8:59", false}, {2.5, 4, "9:00", false}, {0.0, 4, "9:01", false},
				{0.0, 4, "6:00", true}
		});
	}
	
	
	public void setUp() {
		calculator = new FareCalculator();
	}
	
	

	@Test
	public void fareCalculatorTest() {
		assertEquals(expected, FareCalculator.calculateFare(age, time, isHoliday), DELTA);
	}

}