
package com.github.borovelli.javavelli.fibonacci;
//import com.github.borovelli.javavelli.reverse.string.ReverseString;  for importing methods from other classes
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

public class FibonacciForBigInteger {

	public static void main (String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start

		long N = 300; // amount of Fibonacci numbers to be found
		fibonacci(N);
	//	ReverseString.Reverse(input);  for importing methods from other classes
		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

	@Test
	public void testFibonacci () {
		boolean testPassed = fibonacci(300).toString().equals("222232244629420445529739893461909967206666939096499764990979600");
		assertTrue(testPassed);
		if (testPassed) {
			System.out.println("Test passed");
		}
	}

	public static BigInteger fibonacci (long N) {
		BigInteger f2 = BigInteger.ZERO;
		BigInteger f1 = BigInteger.ONE;
		BigInteger f = BigInteger.ONE;
		long j = 1;
		System.out.println(1 + " fibonacci is " + f2.toString());
		System.out.println(2 + " fibonacci is " + f1.toString());

		while (j < N) {
			f = f2.add(f1); // addition for BigDecimal
			f2 = f1;
			f1 = f;
			j++;
			System.out.println(j + " fibonacci is " + f.toString());
		}

		return f;
	}
}

