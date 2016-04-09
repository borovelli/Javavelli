package com.github.borovelli.javavelli.sorting;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.arrays.ArrayData;

import org.junit.Test;

public class MergeSort {

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
		if (lowIndex == highIndex)
			return;
		else {
			int midIndex = (lowIndex + highIndex) / 2;
			mergeSort(list, lowIndex, midIndex);
			mergeSort(list, midIndex + 1, highIndex);
			merge(list, lowIndex, midIndex, highIndex);
		}
	}

	public static void merge(int[] list, int lowIndex, int midIndex,
			int highIndex) {
		int[] L = new int[midIndex - lowIndex + 2];

		for (int i = lowIndex; i <= midIndex; i++) {
			L[i - lowIndex] = list[i];
		}
		L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
		int[] R = new int[highIndex - midIndex + 1];

		for (int i = midIndex + 1; i <= highIndex; i++) {
			R[i - midIndex - 1] = list[i];
		}
		R[highIndex - midIndex] = Integer.MAX_VALUE;
		int i = 0, j = 0;

		for (int k = lowIndex; k <= highIndex; k++) {
			if (L[i] <= R[j]) {
				list[k] = L[i];
				i++;
			} else {
				list[k] = R[j];
				j++;
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

}
