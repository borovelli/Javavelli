package com.github.borovelli.javavelli.fibonacci;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Test;

public class FibonacciForBigInteger {

	private static String format(BigInteger fac) {
		NumberFormat formatter = new DecimalFormat("0.0E0");
		formatter.setRoundingMode(RoundingMode.HALF_UP);
		formatter.setMinimumFractionDigits(11);
		return formatter.format(fac);
	}

	public static BigInteger fibonacci(long N) {
		BigInteger f2 = BigInteger.ZERO;
		BigInteger f1 = BigInteger.ONE;
		BigInteger f = BigInteger.ONE;
		long j = 1;
		System.out.println(0 + " fibonacci is " + f2.toString());
		System.out.println(1 + " fibonacci is " + f1.toString());

		while (j < N) {
			System.out.println(j + " fibonacci is " + f.toString());
			f = f2.add(f1); // addition for BigDecimal
			f2 = f1;
			f1 = f;
			j++;
		}
		return f;
	}

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start

		long N = 10000; // amount of Fibonacci numbers to be found
		String fibonacci = format(fibonacci(N));
		System.out.println(N + " fibonacci is " + fibonacci);

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

	@Test
	public void testFibonacci() {
		boolean testPassed = fibonacci(300)
				.toString()
				.equals("222232244629420445529739893461909967206666939096499764990979600");
		assertTrue(testPassed);
		if (testPassed) {
			System.out.println("Test passed");
		}
	}

}
