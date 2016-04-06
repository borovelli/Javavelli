package com.github.borovelli.javavelli.fibonacci;

import java.math.BigInteger;

public class FibonacciArrayBigInteger {

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start

		int N = 5001; // amount of Fibonacci numbers to be found (unlimited)
		BigInteger[] fib = new BigInteger[N + 1];
		fib[0] = BigInteger.ZERO;
		System.out.println(1 + " fibonacci is " + fib[0]);
		fib[1] = BigInteger.ONE;
		System.out.println(2 + " fibonacci is " + fib[1]);
//		fib[2] = BigInteger.ONE;
//		System.out.println(3 + " fibonacci is " + fib[2]);

		for (int i = 2; i < N; i++) {
			fib[i] = fib[i - 2].add(fib[i - 1]); // addition for BigInteger
			System.out.println(i + " fibonacci is " + fib[i]);
		}

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
}
