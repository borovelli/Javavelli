package com.github.borovelli.javavelli.quadraticEquation;

import java.util.*;
import java.math.*;

public class QuadraticEquation {

	public static void main(String[] args) {
		System.out
				.println("For the quadratic equation of the type axˆ2 + bx + c = 0");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("a =");
		double a = sc.nextDouble();
		System.out.println("b =");
		double b = sc.nextDouble();
		System.out.println("c =");
		double c = sc.nextDouble();
		double d = Math.pow(b, 2.0) - 4 * a * c;
		System.out.println("Discriminant is equal" + "  " + d);

		if (d < 0) {
			double x1 = (-b + Math.sqrt(Math.abs(d))) / (2 * a);
			double x2 = (-b - Math.sqrt(Math.abs(d))) / (2 * a);
			if (x1 < 0) {
				System.out.println("Root x1 is equal " + " -i* " + Math.abs(x1));
			}
			if (x2 < 0) {
				System.out.println("Root x2 is equal " + " -i* " + Math.abs(x2));
			}
			if (x1 > 0) {
				System.out.println("Root x1 is equal " + " i* " + x1);
			}
			if (x2 > 0) {
				System.out.println("Root x2 is equal " + " i* " + x1);
			}

		}
		if (d == 0) {
			double x1 = -b / (2 * a);
			System.out.println("Root x of second order is equal" + x1);
		}
		if (d > 0) {
			double x1 = (-b + Math.sqrt(d)) / (2 * a);
			double x2 = (-b - Math.sqrt(d)) / (2 * a);
			System.out.println("Root x1 is equal" + ("  ") + x1);
			System.out.println("Root x2 is equal" + ("  ") + x2);
		}

	}
}