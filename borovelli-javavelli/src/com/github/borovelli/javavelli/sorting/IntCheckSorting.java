package com.github.borovelli.javavelli.sorting;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.arrays.ArrayData;

import org.junit.Test;

public class IntCheckSorting {

	/*
	 * @Test public void testReverse () { String input = "qwertyuiop"; boolean
	 * testPassed = Reverse(input).equals("poiuytrewq");
	 * 
	 * if (testPassed) { System.out.println("Test passed"); } else {
	 * System.out.println("Test failed: " + input); } assertTrue(testPassed); }
	 * 
	 * @Test public void testReverse2 () { String input = "";
	 * 
	 * byte[] data = {0, 0x41, // A (byte)0xD8, 1, // High surrogate (byte)0xDC,
	 * 2, // Low surrogate 0, 0x42, // B };
	 * 
	 * try { input = new String(data, "UTF-16"); } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); }
	 * 
	 * String reversed = new StringBuilder(input).reverse().toString(); String
	 * result = Reverse(input); boolean testPassed = result.equals(reversed);
	 * 
	 * if (testPassed) { System.out.println("Test2 passed"); } else {
	 * System.out.println("Test2 failed: <" + input +
	 * "> should be reversed to <" + reversed + ">, not <" + result + ">"); }
	 * assertTrue(testPassed); }
	 */

/*	public static long[] RandomIntArray(int N) {

		long[] random = new long[N]; // create the Array with N slots
		Random rnd = new Random(); // create a local variable for Random
		for (int i = 0; i < random.length; i++) // filling with randoms
		{
			random[i] = rnd.nextInt();
		}
		return random;
		}
*/

	public static boolean isSorted(int[] array) {
		boolean check = true;
		int L = array.length;
		
		for (int i = 0; i < L - 1; i++) {
			
			if (array[i] <= array[i + 1]) {
				int a = array[i];
				check = true;
			}
			if (array[i] > array[i + 1]) {
				check = false;
				break;
			}
			
		}
		return check;
	}

	public static void main(String[] args) {

//		System.out.println("enter integer, press enter");
//		System.out.println("to finish filling enter any non-integer");
//		Scanner input = new Scanner(System.in);
		// creating a list with dynamic array of integers
//		List<Integer> borovin = new ArrayList<Integer>();
		// filling array unless non-integer is entered
//		while (input.hasNextInt()) {
//			int n = input.nextInt();
//			borovin.add(n);
//		}

		// int[] n = borovin.toArray(new int[0]);
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		boolean a = isSorted(array);
	
		System.out.println(" Expression ..The array is sorted.. is  " + a);
	}

}
