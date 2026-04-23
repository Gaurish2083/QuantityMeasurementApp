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

		assertNotEquals(f1.equals(f2),false);
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

}    