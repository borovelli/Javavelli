package com.github.borovelli.javavelli.reverse.string;

import static org.junit.Assert.assertTrue;

import java.util.*;

import java.util.Scanner;

import org.junit.Test;

public class ReverseString {

	@Test
	public void testReverse() {
		String input = "abc";
		boolean testPassed = Reverse(input).equals("cba");
		assertTrue(testPassed);
		if (testPassed) {
			System.out.println("Test passed");
		}
	}

	public static String Reverse(String input) {
		char[] borovin = input.toCharArray();
		int L = borovin.length;
		char[] buffer = new char[L + 1];
		for (int i = 0; i < L; i++) {
			buffer[L - i] = borovin[i];
		}
		String result = new String(buffer);
		return result;

	}

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String result = Reverse(input);

		System.out.println("Original string " + input);
		System.out.println("Reverse string " + result);

	}

}
