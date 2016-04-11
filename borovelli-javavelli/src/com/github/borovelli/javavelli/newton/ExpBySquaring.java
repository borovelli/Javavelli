package com.github.borovelli.javavelli.newton;

//import java.math.BigDecimal;
import java.util.Scanner;

public class ExpBySquaring {

	public static double expBySquaring(double b, double p) {
		if (p < 0) {
			return expBySquaring(1 / b, -p);
		}
		if (p == 0) {
			return 1;
		}
		if (p == 1) {
			return b;
		}
		if (p % 2 == 0) {
			System.out.println(b);
			return expBySquaring(b * b, p / 2);
		} else {
			System.out.println(b);
			return b * expBySquaring(b * b, (p - 1) / 2);
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("The base is");
		Scanner base = new Scanner(System.in);
		double b = base.nextDouble();
		System.out.println("The power is");
		Scanner power = new Scanner(System.in);
		double p = power.nextDouble();

		long beginTime = System.currentTimeMillis();

		System.out.println(expBySquaring(b, p));

		long endTime = System.currentTimeMillis(); // timer finishes
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
}
