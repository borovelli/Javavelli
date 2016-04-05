package com.github.borovelli.javavelli.fibonacci;

public class FibonacciArray {

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start

		int N = 93; // amount of Fibonacci numbers to be found
		long[] fib = new long[N];
		fib[0] = 0;
		System.out.println(1 + " fibonacci is " + fib[0]);
		fib[1] = 1;
		System.out.println(2 + " fibonacci is " + fib[1]);
		fib[2] = 1;
		System.out.println(3 + " fibonacci is " + fib[2]);

		for (int i = 3; i < N; i++) {
			fib[i] = fib[i - 2] + fib[i - 1];
			System.out.println(i + 1 + " fibonacci is " + fib[i]);
		}

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
}
