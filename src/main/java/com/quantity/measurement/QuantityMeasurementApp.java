package com.quantity.measurement;

import com.quantity.measurement.enums.LengthUnit;
import com.quantity.measurement.model.QuantityLength;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuantityMeasurementApp {

	public static void main(String[] args) {

		QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
		QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

		QuantityLength q3 = new QuantityLength(1.0, LengthUnit.YARD);
		QuantityLength q4 = new QuantityLength(3.0, LengthUnit.FEET);

		QuantityLength q5 = new QuantityLength(1.0, LengthUnit.CM);
		QuantityLength q6 = new QuantityLength(0.393701, LengthUnit.INCH);

		System.out.println(q1.equals(q2) ? "Equal (true)" : "Not Equal (false)");
		System.out.println(q3.equals(q4) ? "Equal (true)" : "Not Equal (false)");
		System.out.println(q5.equals(q6) ? "Equal (true)" : "Not Equal (false)");
	}
}