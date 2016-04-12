package com.github.borovelli.javavelli.newton;

import static org.junit.Assert.assertTrue;

//import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.Test;

public class NewtonCubeRoot {

	@Test
	public void testReverse() {
		assertTrue(testRoot(2));
		assertTrue(testRoot(3));
		assertTrue(testRoot(64));
		assertTrue(testRoot(121));
	}

	private boolean testRoot(double x) {
		double rootNewton = cuberoot(x);
		double rootJava = StrictMath.sqrt(x);
		return PowReccursion.inepsilondistance(rootNewton, rootJava, epsilon);
	}

	public static double cuberoot(double x) {

		double y = x / 3; // sqrt(x) estimate
		if (x == 0) {
			return 0;
		}
		while (Math.abs((x / (y * y) + 2 * y) / 3.0) > epsilon * y) {
			if (Math.abs(y - (x / (y * y) + 2 * y) / 3.0) <= epsilon) {
				break;
			}
			System.out.println("Newton x  = " + y);
			y = (x / (y * y) + 2 * y) / 3.0;
		}
		return y;
	}

	public static void main(String[] args) {
		System.out.println(" Enter the x value ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		double x = input.nextDouble();
		long beginTime = System.nanoTime();
		// timer starts in nanoseconds
		double y = cuberoot(x);
		double check = y * y * y;
		System.out.println("CubeRoot x  = " + y);
		System.out.println("Math.pow " + Math.pow(x, 1 / 3));
		System.out.println(" Check  x * x = " + check);

		// print out the estimate of the square root of c
		long endTime = System.nanoTime(); // timer finishes
		long difference = endTime - beginTime;
		System.out.println(difference + " nanoseconds ");
	}

	static public double epsilon = 1e-29; // error tolerance

}
