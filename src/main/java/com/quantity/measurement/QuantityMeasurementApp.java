package com.quantity.measurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuantityMeasurementApp {
	static class Feet{
		private final double value;

		public Feet(double value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) return true;

			if(obj == null || getClass() != obj.getClass()){
				return false;
			}

			Feet Nfeet = (Feet) obj;
			return Double.compare(this.value , Nfeet.value) == 0;
		}
	}

	static class Inch{
		private final double value;
		public Inch(double value){
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if(this == obj) return true;

			if(obj == null || getClass()!= obj.getClass()){
				return false;
			}

			Inch NInch = (Inch) obj;
			return Double.compare(this.value , NInch.value) == 0;

		}
	}

	public static void main(String[] args) {
		SpringApplication.run(QuantityMeasurementApp.class, args);

		Feet f1 = new Feet(34.5);
		Feet f2 = new Feet(34.5);

		System.out.println(f1.equals(f2));

		Inch i1 = new Inch(52.2);
		Inch i2 = new Inch(52.2);

		System.out.println(i1.equals(i2));
	}
}