package com.github.borovelli.javavelli.factorial;

public class FactorialReccursive {

	public static double factorial(double n) {
		if (inepsilondistance(n, 0)) {
			return 1; // check if n is zero
		}
		double a = factorial(n - 1); // call recursive function factorial (n-1)
		// it will reduce the n untill 0 at this point, and will only proceed to
		// the next one after
		double b = n * a;
		return b;
	}

	private static boolean inepsilondistance(double a, double b) {
		double EPSILON = 0.0000000000000000000001d;
		if (Math.abs(a - b) < EPSILON) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start

		double c = factorial(170);
		System.out.println(" factorial is equal " + c);

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

}
