
package com.github.borovelli.javavelli.sorting;

import static org.junit.Assert.assertTrue;

//import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//import jdk.nashorn.internal.runtime.arrays.ArrayData;

import org.junit.Test;

public class IntMergeSort {

	// TEST TEST TEST TEST TEST TEST TEST TEST

	@Test
	public void testReverse () {

		assertTrue(checkSorting(new byte[] {}));
		assertTrue(checkSorting(new byte[] {1}));
		assertTrue(checkSorting(new byte[] {1, 2}));
		assertTrue(checkSorting(new byte[] {2, 1}));
		assertTrue(checkSorting(new byte[] {1, 2, 1}));
		assertTrue(checkSorting(RandomIntArray(100)));

	}

	private boolean checkSorting (byte[] list) {
		System.out.println("checkSorting " + "(" + Arrays.toString(list) + ")");

		byte[] java_array = copy(list);
		byte[] merge_array = copy(list);

		Arrays.sort(java_array);
		mergeSort(merge_array);

		boolean areEqual = Arrays.equals(java_array, merge_array);
		if (!areEqual) {
			System.out.println("Failed to sort " + "(" + Arrays.toString(list) + ")");
			System.out.println("        result" + "(" + Arrays.toString(merge_array) + ")");
			System.out.println("     should be" + "(" + Arrays.toString(java_array) + ")");
		} else {
			System.out.println("Success to sort " + "(" + Arrays.toString(list) + ")");
			System.out.println("        result" + "(" + Arrays.toString(merge_array) + ")");
			System.out.println("     should be" + "(" + Arrays.toString(java_array) + ")");
			System.out.println();
		}
		return areEqual;
	}

	private byte[] copy (byte[] src) {
		byte[] copy = new byte[src.length];
		System.arraycopy(src, 0, copy, 0, src.length);
		return copy;
	}

	// TEST TEST TEST TEST TEST TEST TEST TEST

	public static byte[] RandomIntArray (int N) {

		byte[] random = new byte[N]; // create the Array with N slots
		Random rnd = new Random(); // create a local variable for Random
		for (int i = 0; i < random.length; i++) // filling with randoms
		{
			random[i] = ((byte)rnd.nextInt());
// random[i] = (int) random[i];
		}
		return random;
	}

	// getting the array list[] and preparing for the mergeSort method
	public static void mergeSort (byte[] list) {

		byte[] buffer = new byte[list.length];
		int lowIndex = 0;
		int highIndex = list.length - 1;
		mergeSort(list, buffer, lowIndex, highIndex);
	}

	// Starting the mergeSort method with reccursion

	public static void mergeSort (byte[] list, byte[] buffer, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int midIndex = highIndex / 2 + lowIndex / 2;
			mergeSort(list, buffer, lowIndex, midIndex);
			mergeSort(list, buffer, midIndex + 1, highIndex);
			merge(list, buffer, lowIndex, midIndex, highIndex);
		}
	}

	// Starting the merge method (no sorting yet)

	public static void merge (byte[] list, byte[] buffer, int lowIndex, int midIndex, int highIndex) {
		for (int i = lowIndex; i <= highIndex; i++) {
			buffer[i] = list[i];
		}
		int leftBuffer = lowIndex;
		int rightBuffer = midIndex + 1;// starts from the middle+1
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
		int leftover = midIndex - leftBuffer;
		for (int i = 0; i <= leftover; i++) {
			list[curBuffer + i] = buffer[leftBuffer + i];
		}
	}

	public static void main (String[] args) {
		long beginTime = System.currentTimeMillis(); // timer start

		System.out.println("Array size ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		byte[] list = RandomIntArray(N);

		if (IsSorted.isSorted(list)) {
			String randomStr = Arrays.toString(list);// random String
			System.out.println("Already sorted " + "(" + randomStr + ")");
		} else {
			System.out.println("Array " + "(" + Arrays.toString(list) + ")");
			mergeSort(list); // sorting random integer
			System.out.println("Sorted " + "(" + Arrays.toString(list) + ")");
		}
		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

}
