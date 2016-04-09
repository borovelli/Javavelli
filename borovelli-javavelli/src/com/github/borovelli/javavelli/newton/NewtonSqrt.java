package com.github.borovelli.javavelli.newton;

//import java.math.BigDecimal;
import java.util.Scanner;

public class NewtonSqrt {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		double c = input.nextDouble();
		long beginTime = System.nanoTime();
		// timer starts in nanoseconds
		double epsilon = 1e-15; // error tolerance
		double t = c / 2; // sqrt(c) estimate

		while (Math.abs(c / t - t) > epsilon * t) {
			// unless t is epsilon close to c
			// take the t = (t and c/t) average
			System.out.println(t);
			t = (c / t + t) / 2.0;
		}
		double check = t * t;
		System.out.println("   x * x = " + check);
		System.out.println("   Math.sqrt " + Math.sqrt(c));

		// print out the estimate of the square root of c
		long endTime = System.nanoTime(); // timer finishes
		long difference = endTime - beginTime;
		System.out.println(difference + " nanoseconds ");
	}

}
