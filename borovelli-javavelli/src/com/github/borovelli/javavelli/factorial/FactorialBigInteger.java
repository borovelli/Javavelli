package com.github.borovelli.javavelli.factorial;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class FactorialBigInteger {

	public static BigInteger factorial(long n) {

		BigInteger fac = BigInteger.ONE;
		for (long i = 1; i <= n; i++) {
			System.out.println(" factorial of " + (i-1) + " is equal to " + fac);
			fac = BigInteger.valueOf(i).multiply(fac);
		}
		return fac;
	}

	private static String format(BigInteger fac)
	{
	    NumberFormat formatter = new DecimalFormat("0.0E0");
	    formatter.setRoundingMode(RoundingMode.HALF_UP);
	    formatter.setMinimumFractionDigits(11);
	    return formatter.format(fac);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis(); // timer start
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		String a = format(factorial(n));
		System.out.println(" factorial of " + n + " is equal " + a);  

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
}
