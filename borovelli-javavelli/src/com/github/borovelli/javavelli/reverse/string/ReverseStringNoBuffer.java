package com.github.borovelli.javavelli.reverse.string;

import static org.junit.Assert.assertTrue;

import java.util.*;

import java.util.Scanner;

import org.junit.Test;

public class ReverseStringNoBuffer {

	@Test
	public void testReverse() {
		String input = "qwertyuiop";
		boolean testPassed = Reverse(input).equals("poiuytrewq");
		assertTrue(testPassed);
		if (testPassed) {
			System.out.println("Test passed");
		}
	}

	public static String Reverse(String input) {
		char[] borovin = input.toCharArray();
		int L = borovin.length;

		for (int i = 0; i < L / 2; i++) { // does not matter if L is even or odd
											// -> int L will round L/2 nicely
			char b = borovin[L - i - 1];
			char a = borovin[i];
			borovin[L - i - 1] = a;
			borovin[i] = b;
		}
		String result = new String(borovin);
		return result;
	}

	//

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String result = Reverse(input);

		System.out.println("Original string " + "(" + input + ")");
		System.out.println("Reverse string " + "(" + result + ")");

	}

}
