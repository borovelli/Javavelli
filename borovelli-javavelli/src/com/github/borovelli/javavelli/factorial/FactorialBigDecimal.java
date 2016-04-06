package com.github.borovelli.javavelli.factorial;

import java.math.BigDecimal;

public class FactorialBigDecimal {

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start
		int N = 1700;

		BigDecimal resultat = BigDecimal.ONE;

		for (int i = 1; i <= N; i++) {
			BigDecimal multiplicand = new BigDecimal(i);
			resultat = resultat.multiply(multiplicand);
		}
		System.out.println(" factorial is equal " + resultat.toPlainString()); // converts BigDecimal to String

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

}
