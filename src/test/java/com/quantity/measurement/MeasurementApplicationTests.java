package com.quantity.measurement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuantityMeasurementAppTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testFeetEquality_SameValues(){
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(34.5);
		QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(34.5);

		assertEquals(f1.equals(f2),true);
	}

	@Test
	void testFeetEquality_DifferentValues(){
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(34.5);
		QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(37.5);

		assertNotEquals(f1.equals(f2),true);
	}

	@Test
	void testFeetEquality_NullValues(){
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(34.5);

		assertFalse(f1.equals(null));
	}

	@Test
	void testFeetEquality_ClassComparison(){
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(34.5);
		QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(34.5);

		assertFalse(f1.equals("Some String"));

	}

	@Test
	void testFeetEquality_SameRef(){
		QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(34.5);

		assertTrue(f1.equals(f1));
	}

	@Test
	void testInchesEquality_SameValues(){
		QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(34.5);
		QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(34.5);

		assertTrue(i1.equals(i2));
	}

	@Test
	void testInchesEquality_DifferentValues(){
		QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(34.5);
		QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(37.5);

		assertNotEquals(i1.equals(i2),true);
	}

	@Test
	void testInchesEquality_NullValues(){
		QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(34.5);

		assertFalse(i1.equals(null));
	}

	@Test
	void testInchesEquality_ClassComparison(){
		QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(34.5);

		assertFalse(i1.equals("Some String"));
	}

	@Test
	void testInchesEquality_SameRef(){
		QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(34.5);

		assertTrue(i1.equals(i1));
	}
}