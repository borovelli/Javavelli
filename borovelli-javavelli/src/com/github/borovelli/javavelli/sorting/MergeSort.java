package com.github.borovelli.javavelli.sorting;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.arrays.ArrayData;

import org.junit.Test;

public class MergeSort {
	
	@Test
	public void testReverse () {

		assertTrue(checkSorting(new int[] {}));
		assertTrue(checkSorting(new int[] {1}));
		assertTrue(checkSorting(new int[] {1, 2}));
		assertTrue(checkSorting(new int[] {2, 1}));
		assertTrue(checkSorting(new int[] {1, 2, 1}));
		assertTrue(checkSorting(RandomIntArray(100)));

	}
	
	private boolean checkSorting (int[] origial) {
	// System.out.println("checkSorting " + "(" + Arrays.toString(origial) + ")");

			int[] java_array = copy(origial);
			int[] merge_array = copy(origial);

			Arrays.sort(java_array);
			mergeSort(merge_array);

			boolean areEqual = Arrays.equals(java_array, merge_array);
			if (!areEqual) {
				System.out.println("Failed to sort " + "(" + Arrays.toString(origial) + ")");
				System.out.println("        result" + "(" + Arrays.toString(merge_array) + ")");
				System.out.println("     should be" + "(" + Arrays.toString(java_array) + ")");
			}
			return areEqual;
		}

		private int[] copy (int[] src) {
			int[] copy = new int[src.length];
			System.arraycopy(src, 0, copy, 0, src.length);
			return copy;
		}

	public static int[] RandomIntArray(int N) {

		int[] random = new int[N]; // create the Array with N slots
		Random rnd = new Random(); // create a local variable for Random
		for (int i = 0; i < random.length; i++) // filling with randoms
		{
			random[i] = rnd.nextInt();
		}
		return random;
	}

	public static void mergeSort(int[] list, int lowIndex, int highIndex) {
		if (lowIndex == highIndex) // check if we have only 1 index
			return;
		else {
			int midIndex = (lowIndex + highIndex) / 2; // define the middle
			
			//RECCURSION STARTS - will go from bottom (1 index only) to final array
			mergeSort(list, lowIndex, midIndex); // run same function for left half
			mergeSort(list, midIndex + 1, highIndex);// run same function for right half
			merge(list, lowIndex, midIndex, highIndex); // merge halfs
		}
	}

	public static void merge(int[] list, int lowIndex, int midIndex,
			int highIndex) {

		//		LEFT PART of THE INITIAL ARRAY
		int[] L = new int[midIndex - lowIndex + 2]; // new array L

		for (int i = lowIndex; i <= midIndex; i++) { // copy 1/2 of list[] to L[]
			L[i - lowIndex] = list[i];
		}
		L[midIndex - lowIndex + 1] = Integer.MAX_VALUE; // marker at the END of L[]

		//		RIGHT PART of THE INITIAL ARRAY
		int[] R = new int[highIndex - midIndex + 1];

		for (int i = midIndex + 1; i <= highIndex; i++) {// copy 1/2 of list[] to R[]
			R[i - midIndex - 1] = list[i];
		}
		R[highIndex - midIndex] = Integer.MAX_VALUE; // marker at the BEGINNING of R[]
		int i = 0, j = 0;

		//		FINALLY - - - THE MERGE ITSELF
		for (int k = lowIndex; k <= highIndex; k++) {
			if (L[i] <= R[j]) { // start comparison from i=j=0;
				list[k] = L[i]; // rewrite list[] upon result
				i++; // switch to the next in L[]
			} else {
				list[k] = R[j];// rewrite list[] upon result
				j++;// switch to the next in R[]
			}
		}
	}

	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis(); // timer start

		System.out.println("Enter number of slots in random array of integers ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int[] list = RandomIntArray(N);
		int lowIndex = 0;
		int highIndex = N - 1;

		if (IsSorted.isSorted(list)) {
			String randomString = Arrays.toString(list);// random String
			System.out.println("Array is already sorted " + "(" + randomString
					+ ")");
		} else {
			System.out.println("Random Array " + "("
					+ Arrays.toString(list) + ")");

			mergeSort(list, lowIndex, highIndex); // sorting random integer

			System.out.println("Sorted Array " + "("
					+ Arrays.toString(list) + ")");
		}
		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
	
	public static void mergeSort (int[] list) {

		int lowIndex = 0;
		int highIndex = list.length - 1;

		if (IsSorted.isSorted(list)) {
// String randomString = Arrays.toString(list);// random String
// System.out.println("Array is already sorted " + "(" + randomString + ")");
		} else {
// System.out.println("Random Array " + "(" + Arrays.toString(list) + ")");

			mergeSort(list, lowIndex, highIndex); // sorting random integer

// System.out.println("Sorted Array " + "(" + Arrays.toString(list) + ")");
		}
	}

}
