
package com.github.borovelli.javavelli.prime;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class ElucidCGD {

	private static int cdg (final int a, final int b) {

		if (a > b) {
			return cdg(b, a);
		}
		if (a == b) {
			return a;
		}
		if (a == 1) {
			return 1;
		}
		if (b % a == 0) {
			return a;
		}
		return cdg(a, b - a);
	}

	public static void main (final String[] args) {

		final long beginTime = System.currentTimeMillis();

		System.out.println(" Enter the p value ");
		@SuppressWarnings("resource")
		final Scanner sc = new Scanner(System.in);
		final int a = sc.nextInt();
		System.out.println(" Enter the q value ");
		@SuppressWarnings("resource")
		final Scanner input = new Scanner(System.in);
		final int b = input.nextInt();
		System.out.println(" CGD of p and q is " + cdg(a, b));

		final long endTime = System.currentTimeMillis();
		final long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

	@Test
	public void test () {
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				for (int k = 1; k < 100; k++) {
					final int a = i * j;
					final int b = i * k;
					final int cdg = cdg(a, b);
					if (cdg == 0) {
						throw new Error("a=" + a + " b=" + b + " cdg=" + cdg);
					}

					assertTrue(a % cdg == 0);
					assertTrue(b % cdg == 0);
					assertTrue(cdg(b / cdg, a / cdg) == 1);
					System.out.println("a=" + a + " b=" + b + " cdg=" + cdg);
				}

			}
		}

	}

}
