package com.quantity.measurement;

import com.quantity.measurement.enums.LengthUnit;
import com.quantity.measurement.model.QuantityLength;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuantityMeasurementAppTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testFeetEquality_SameValue(){
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

		assertEquals(q1, q2);
	}

	@Test
	void testFeetEquality_DifferentValue(){
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(4.0, LengthUnit.FEET);

		assertNotEquals(q1, q2);
	}

	@Test
	void testInchEquality_SameValue(){
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
		QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);

		assertEquals(q1, q2);
	}

	@Test
	void testInchEquality_DifferentValue(){
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
		QuantityLength q2 = new QuantityLength(4.0, LengthUnit.INCH);

		assertNotEquals(q1, q2);
	}

	@Test
	void testDifferentValue(){
		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

		assertEquals(q1, q2);

	}

	@Test
	void testNullUnit(){
		assertThrows(IllegalArgumentException.class, () -> {
			new QuantityLength(1.0,null);
		});
	}

	@Test
	void testNullComparison(){
		QuantityLength q1 = new QuantityLength(1.0,LengthUnit.FEET);

		assertNotEquals(q1, null);
	}

	//YARD AND CM
	// 1
	@Test
	void testEquality_YardToYard_SameValue() {
		assertEquals(
				new QuantityLength(1.0, LengthUnit.YARD),
				new QuantityLength(1.0, LengthUnit.YARD)
		);
	}

	// 2
	@Test
	void testEquality_YardToYard_DifferentValue() {
		assertNotEquals(
				new QuantityLength(1.0, LengthUnit.YARD),
				new QuantityLength(2.0, LengthUnit.YARD)
		);
	}

	// 3
	@Test
	void testEquality_YardToFeet_EquivalentValue() {
		assertEquals(
				new QuantityLength(1.0, LengthUnit.YARD),
				new QuantityLength(3.0, LengthUnit.FEET)
		);
	}

	// 4
	@Test
	void testEquality_FeetToYard_EquivalentValue() {
		assertEquals(
				new QuantityLength(3.0, LengthUnit.FEET),
				new QuantityLength(1.0, LengthUnit.YARD)
		);
	}

	// 5
	@Test
	void testEquality_YardToInches_EquivalentValue() {
		assertEquals(
				new QuantityLength(1.0, LengthUnit.YARD),
				new QuantityLength(36.0, LengthUnit.INCH)
		);
	}

	// 6
	@Test
	void testEquality_InchesToYard_EquivalentValue() {
		assertEquals(
				new QuantityLength(36.0, LengthUnit.INCH),
				new QuantityLength(1.0, LengthUnit.YARD)
		);
	}

	// 7
	@Test
	void testEquality_YardToFeet_NonEquivalentValue() {
		assertNotEquals(
				new QuantityLength(1.0, LengthUnit.YARD),
				new QuantityLength(2.0, LengthUnit.FEET)
		);
	}

	// 8
	@Test
	void testEquality_CentimetersToInches_EquivalentValue() {
		assertEquals(
				new QuantityLength(1.0, LengthUnit.CM),
				new QuantityLength(0.393701, LengthUnit.INCH)
		);
	}

	// 9
	@Test
	void testEquality_CentimetersToFeet_NonEquivalentValue() {
		assertNotEquals(
				new QuantityLength(1.0, LengthUnit.CM),
				new QuantityLength(1.0, LengthUnit.FEET)
		);
	}

	// 10 (Transitive property)
	@Test
	void testEquality_MultiUnit_TransitiveProperty() {
		QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
		QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
		QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);

		assertEquals(yard, feet);
		assertEquals(feet, inch);
		assertEquals(yard, inch);
	}

	// 11
	@Test
	void testEquality_YardWithNullUnit() {
		assertThrows(IllegalArgumentException.class, () -> {
			new QuantityLength(1.0, null);
		});
	}

	// 12 (Reflexive)
	@Test
	void testEquality_YardSameReference() {
		QuantityLength q = new QuantityLength(1.0, LengthUnit.YARD);
		assertEquals(q, q);
	}

	// 13
	@Test
	void testEquality_YardNullComparison() {
		QuantityLength q = new QuantityLength(1.0, LengthUnit.YARD);
		assertNotEquals(q, null);
	}

	// 14
	@Test
	void testEquality_CentimetersWithNullUnit() {
		assertThrows(IllegalArgumentException.class, () -> {
			new QuantityLength(1.0, null);
		});
	}

	// 15 (Reflexive)
	@Test
	void testEquality_CentimetersSameReference() {
		QuantityLength q = new QuantityLength(1.0, LengthUnit.CM);
		assertEquals(q, q);
	}

	// 16
	@Test
	void testEquality_CentimetersNullComparison() {
		QuantityLength q = new QuantityLength(1.0, LengthUnit.CM);
		assertNotEquals(q, null);
	}

	// 17 (Complex multi-unit)
	@Test
	void testEquality_AllUnits_ComplexScenario() {
		QuantityLength yard = new QuantityLength(2.0, LengthUnit.YARD);
		QuantityLength feet = new QuantityLength(6.0, LengthUnit.FEET);
		QuantityLength inch = new QuantityLength(72.0, LengthUnit.INCH);

		assertEquals(yard, feet);
		assertEquals(feet, inch);
		assertEquals(yard, inch);
	}

	//UC5
	// 1 (Feet → Inches)
	@Test
	void testConversion_FeetToInches() {
		assertEquals(12.0,
				QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH));
	}

	// 2 (Inches → Feet)
	@Test
	void testConversion_InchesToFeet() {
		assertEquals(2.0,
				QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET));
	}

	// 3 (Yards → Inches)
	@Test
	void testConversion_YardsToInches() {
		assertEquals(36.0,
				QuantityLength.convert(1.0, LengthUnit.YARD, LengthUnit.INCH));
	}

	// 4 (Inches → Yards)
	@Test
	void testConversion_InchesToYards() {
		assertEquals(2.0,
				QuantityLength.convert(72.0, LengthUnit.INCH, LengthUnit.YARD));
	}

	// 5 (Centimeters → Inches with precision)
	@Test
	void testConversion_CentimetersToInches() {
		assertEquals(1.0,
				QuantityLength.convert(2.54, LengthUnit.CM, LengthUnit.INCH),
				1e-6);
	}

	// 6 (Feet → Yards)
	@Test
	void testConversion_FeetToYards() {
		assertEquals(2.0,
				QuantityLength.convert(6.0, LengthUnit.FEET, LengthUnit.YARD));
	}

	// 7 (Zero value)
	@Test
	void testConversion_ZeroValue() {
		assertEquals(0.0,
				QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH));
	}

	// 8 (Negative value)
	@Test
	void testConversion_NegativeValue() {
		assertEquals(-12.0,
				QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH));
	}

	// 9 (Round-trip conversion)
	@Test
	void testConversion_RoundTrip() {
		double original = 5.0;

		double converted = QuantityLength.convert(original, LengthUnit.FEET, LengthUnit.INCH);
		double back = QuantityLength.convert(converted, LengthUnit.INCH, LengthUnit.FEET);

		assertEquals(original, back, 1e-6);
	}

	// 10 (Invalid unit → null)
	@Test
	void testConversion_InvalidUnit_Throws() {
		assertThrows(IllegalArgumentException.class, () ->
				QuantityLength.convert(1.0, null, LengthUnit.FEET));
	}

	// 11 (NaN or Infinite values)
	@Test
	void testConversion_NaNOrInfinite_Throws() {
		assertThrows(IllegalArgumentException.class, () ->
				QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH));

		assertThrows(IllegalArgumentException.class, () ->
				QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCH));
	}

	// 12 (Precision tolerance across multiple conversions)
	@Test
	void testConversion_PrecisionTolerance() {
		double result = QuantityLength.convert(1.0, LengthUnit.CM, LengthUnit.FEET);
		double expected = 0.0328084;

		assertEquals(expected, result, 1e-6);
	}
}