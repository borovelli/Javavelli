
package com.github.borovelli.javavelli.newton;

//import java.math.BigDecimal;
import java.util.Scanner;

public class PowReccursion {

	public static double PowerReccursion (double b, double p) {

		if (inepsilondistance(p, 0, 1e-15)) {
			return 1; // check if p is zero
		}
		double result = b * PowerReccursion(b, p - 1);
		return result;
	}

	public static boolean inepsilondistance (double a, double b, double EPSILON) {
		double distance = Math.abs(a - b);
		return distance < EPSILON;
	}

	@SuppressWarnings("resource")
	public static void main (String[] args) {

		System.out.println("The base is");
		Scanner base = new Scanner(System.in);
		double b = base.nextDouble();
		System.out.println("The power is");
		Scanner power = new Scanner(System.in);
		double p = power.nextDouble();

		long beginTime = System.currentTimeMillis();
		// timer starts in nanoseconds
		System.out.println(PowerReccursion(b, p));
		long endTime = System.currentTimeMillis(); // timer finishes
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
}
