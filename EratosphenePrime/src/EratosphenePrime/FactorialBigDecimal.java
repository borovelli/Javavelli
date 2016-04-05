package EratosphenePrime;

import java.math.BigDecimal;

public class FactorialBigDecimal {

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start
		int N = 1700;

		BigDecimal resultat = BigDecimal.ONE;

		for (int i = 1; i <= N; i++) {
			BigDecimal multiplicand = new BigDecimal(i);
			resultat = resultat.multiply(multiplicand);
		}
		System.out.println(" factorial is equal " + resultat);

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

}
// x in power x
// fibonacci