
package com.github.borovelli.javavelli.sorting;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IsSorted {

	@Test
	public void testReverse () {

		assertTrue(isSorted(new int[] {}));
		assertTrue(isSorted(new int[] {1}));
		assertTrue(isSorted(new int[] {1, 2}));
		assertTrue(!isSorted(new int[] {2, 1}));
		assertTrue(!isSorted(new int[] {1, 2, 1}));

	}

	public static boolean isSorted (int[] array) {
		boolean check = true;
		int L = array.length;

		for (int i = 0; i < L - 1; i++) {

			if (array[i] <= array[i + 1]) {
				check = true;
			}
			if (array[i] > array[i + 1]) {
				check = false;
				break;
			}
		}
		return check;
	}

	public static void main (String[] args) {

		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		boolean a = isSorted(array);

		System.out.println(" Expression ..The array is sorted.. is  " + a);
	}

}
