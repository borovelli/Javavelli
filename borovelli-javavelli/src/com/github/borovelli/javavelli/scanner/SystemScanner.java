package com.github.borovelli.javavelli.scanner;

import java.util.*;

public class SystemScanner {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
 
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

	}
}