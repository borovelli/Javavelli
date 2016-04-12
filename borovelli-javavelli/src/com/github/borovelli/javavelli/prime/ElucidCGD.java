package com.github.borovelli.javavelli.prime;

import java.util.Scanner;

public class ElucidCGD {

	private static int cdg(int a, int b) {
		
		if(a>b){
			return cdg(b,a);
		} 
		if(a == b){
			return a;
		}
		if(a == 1){
			return 1;
		}
		if (b%a == 0){
			return a;
		}
		return cdg(a, b-a);
	}

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis();

		System.out.println(" Enter the p value ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println(" Enter the q value ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int b = input.nextInt();
		System.out.println(" CGD of p and q is " + cdg(a, b));

		long endTime = System.currentTimeMillis();
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

}
