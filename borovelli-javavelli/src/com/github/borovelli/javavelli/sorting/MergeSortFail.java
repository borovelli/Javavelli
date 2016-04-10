
package com.github.borovelli.javavelli.sorting;

import org.junit.Test;

public class MergeSortFail {

	@Test
	public void testReverse () {
		int[] prepare_array = fatIntArray((int)(Integer.MAX_VALUE / 1.8d));
		System.out.println("sorting " + prepare_array.length);
		MergeSort.mergeSort(prepare_array);
	}

	public static int[] fatIntArray (int size) {
		int[] array = new int[size];
		for (int i = size / 2; i < size; i++) {
// array[i] = size - i;
		}

		array[size - 100] = 1;
		return array;
	}

	public static final void main (String[] arg) {
		MergeSort.mergeSort(fatIntArray((int)(Integer.MAX_VALUE / 1.8d)));
	}

}
