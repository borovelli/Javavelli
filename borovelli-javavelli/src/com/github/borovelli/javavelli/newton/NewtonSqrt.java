
package com.github.borovelli.javavelli.newton;

import static org.junit.Assert.assertTrue;

//import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.Test;

public class NewtonSqrt {

	@Test
	public void testReverse () {

		assertTrue(testRoot(2));
		assertTrue(testRoot(3));
		assertTrue(testRoot(64));
		assertTrue(testRoot(121));

	}

	private boolean testRoot (double x) {
		double rootNewton = sqrt(x);
		double rootJava = StrictMath.sqrt(x);
		return PowReccursion.inepsilondistance(rootNewton, rootJava, epsilon);
	}

	public static void main (String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		double c = input.nextDouble();
		long beginTime = System.nanoTime();
		// timer starts in nanoseconds
		double t = sqrt(c);
		double check = t * t;
		System.out.println("   Newton x  = " + t);
		System.out.println("   Math.sqrt " + Math.sqrt(c));
		System.out.println("   x * x = " + check);

		// print out the estimate of the square root of c
		long endTime = System.nanoTime(); // timer finishes
		long difference = endTime - beginTime;
		System.out.println(difference + " nanoseconds ");
	}

	static public double epsilon = 1e-15; // error tolerance

	public static double sqrt (double c) {

		double t = c / 2; // sqrt(c) estimate

		while (Math.abs(c / t - t) > epsilon * t) {
			// unless t is epsilon close to c
			// take the t = (t and c/t) average
//			System.out.println(t);
			t = (c / t + t) / 2.0;
		}
		return t;
	}

}
