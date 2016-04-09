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

public class IsSorted {

	public static boolean isSorted(int[] array) {
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

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		boolean a = isSorted(array);

		System.out.println(" Expression ..The array is sorted.. is  " + a);
	}

}
