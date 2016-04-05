package com.github.borovelli.javavelli.fibonacci;

public class FibonacciFor {

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start

		int N = 93; // amount of Fibonacci numbers to be found
		long f2 = 0;
		long f1 = 1;
		long f = 1;
		long j = 2; 
		System.out.println(1 + " fibonacci is " + f2);
		System.out.println(2 + " fibonacci is " + f1);

		while (j < N) {
			f = f2 + f1;
			f2 = f1;
			f1 = f;
			j++;
			System.out.println(j + " fibonacci is " + f);
		}

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
}
