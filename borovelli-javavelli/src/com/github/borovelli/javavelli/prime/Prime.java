package com.github.borovelli.javavelli.prime;

public class Prime {

	private static boolean isPrime(int n) {

		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		int i = 0;
		int sqrtn = (int) Math.sqrt(n);
		for (i = 2; i <= sqrtn; i++) {

			int rest = n % i;
			if (rest == 0) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis();

		int K = 100000000;
		int j = 1;
		for (int n = 0; n < K; n++) {
			if (isPrime(n)) {
				System.out.println(n + " is prime # " + j);
				j++;
			}
		}

		long endTime = System.currentTimeMillis();
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");

	}
}
