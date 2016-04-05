package EratosphenePrime;

import java.math.BigDecimal;

public class FibonacciForBigInteger {

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start

		long N = 300; // amount of Fibonacci numbers to be found
		BigDecimal resultat = BigDecimal.ONE;
		BigDecimal f2 = BigDecimal.ZERO;
		BigDecimal f1 = BigDecimal.ONE;
		BigDecimal f = BigDecimal.ONE;
		long j = 2; 
		System.out.println(1 + " fibonacci is " + f2);
		System.out.println(2 + " fibonacci is " + f1);

		while (j < N) {
			f = f2.add(f1); // addition for BigDecimal
			f2 = f1;
			f1 = f;
			j++;
			System.out.println(j + " fibonacci is " + f);
		}

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
}

/*	
public class BigDecimalDemo { 

public static void main(String[] args) { 

// create a BigDecimal object 
BigDecimal bg; 

// create a String object 
String s; 

MathContext mc = new MathContext(3); // 3 precision 

bg = new BigDecimal("1234E4", mc); 

// assign the string value of bg to s 
s = bg.toString(); 

String str = "String value of " + bg + " is " + s; 

// print s value 
System.out.println( str ); 
} 
}*/