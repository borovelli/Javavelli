package com.github.borovelli.javavelli.sorting;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.arrays.ArrayData;

import org.junit.Test;

public class ByteMergeSortBorovin {
	/*
	 * // TEST TEST TEST TEST TEST TEST TEST TEST
	 * 
	 * @Test public void testReverse() {
	 * 
	 * assertTrue(checkSorting(new int[] {})); assertTrue(checkSorting(new int[]
	 * { 1 })); assertTrue(checkSorting(new int[] { 1, 2 }));
	 * assertTrue(checkSorting(new int[] { 2, 1 })); assertTrue(checkSorting(new
	 * int[] { 1, 2, 1 })); assertTrue(checkSorting(RandomIntArray(100)));
	 * 
	 * }
	 * 
	 * private boolean checkSorting(int[] origial) { //
	 * System.out.println("checkSorting " + "(" + Arrays.toString(origial) + //
	 * ")");
	 * 
	 * int[] java_array = copy(origial); int[] merge_array = copy(origial);
	 * 
	 * Arrays.sort(java_array); mergeSort(merge_array);
	 * 
	 * boolean areEqual = Arrays.equals(java_array, merge_array); if (!areEqual)
	 * { System.out.println("Failed to sort " + "(" + Arrays.toString(origial) +
	 * ")"); System.out.println("        result" + "(" +
	 * Arrays.toString(merge_array) + ")"); System.out.println("     should be"
	 * + "(" + Arrays.toString(java_array) + ")"); } return areEqual; }
	 * 
	 * private int[] copy(int[] src) { int[] copy = new int[src.length];
	 * System.arraycopy(src, 0, copy, 0, src.length); return copy; }
	 * 
	 * // TEST TEST TEST TEST TEST TEST TEST TEST
	 */
	public static int[] RandomIntArray(int N) {

		int[] random = new int[N]; // create the Array with N slots
		Random rnd = new Random(); // create a local variable for Random
		for (int i = 0; i < random.length; i++) // filling with randoms
		{
			random[i] = ((byte) rnd.nextInt());
		}
		return random;
	}

	// getting the array list[] and preparing for the mergeSort method
	public static void mergeSort(int[] list) {

		int[] buffer = new int[list.length];
		int lowIndex = 0;
		int highIndex = (int) ((int) list.length - 1);
		mergeSort(list, buffer, lowIndex, highIndex);
	}

	// Starting the mergeSort method with reccursion

	public static void mergeSort(int[] list, int[] buffer, int lowIndex,
			int highIndex) {
		if (lowIndex < highIndex) {
			int midIndex = (int) ((highIndex - lowIndex) / 2);
			mergeSort(list, buffer, lowIndex, midIndex);
			mergeSort(list, buffer, (int) (highIndex - lowIndex + 1), highIndex);
			merge(list, buffer, lowIndex, midIndex, highIndex);

		}
	}

	// Starting the merge method (no sorting yet)

	public static void merge(int[] list, int[] buffer, int lowIndex,
			int midIndex, int highIndex) {
		for (int i = lowIndex; i <= highIndex; i++) {
			buffer[i] = list[i];
		}
		int leftBuffer = lowIndex;
		int rightBuffer = (int) (midIndex + 1);// starts from the middle+1
		int curBuffer = lowIndex;

		// Starting comparison of left&right-buffers and re-write of the list[]

		while (leftBuffer <= midIndex && rightBuffer <= highIndex) {
			if (buffer[leftBuffer] <= buffer[rightBuffer]) {
				list[curBuffer] = buffer[leftBuffer];
				leftBuffer++;
			} else {
				list[curBuffer] = buffer[rightBuffer];
				rightBuffer++;
			}
			curBuffer++;// go to the next position
		}
		// Fill the not-moved indexes of buffer(if any) on the same position in
		// the list[]

		int leftover = (int) (midIndex - leftBuffer);
		for (int i = 0; i <= leftover; i++) {
			list[curBuffer + i] = buffer[leftBuffer + i];
		}
	}

	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis(); // timer start

		System.out
				.println("Enter number of slots in random array of integers ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] list = RandomIntArray(N); 
		
		if (IsSorted.isSorted(list)) {
			String randomString = Arrays.toString(list);// random String
			System.out.println("Array is already sorted " + "(" + randomString
					+ ")");
		} else {
			System.out.println("Random Array " + "(" + Arrays.toString(list)
					+ ")");

			mergeSort(list); // sorting random integer

			System.out.println("Sorted Array " + "(" + Arrays.toString(list)
					+ ")");
		}
		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

}
