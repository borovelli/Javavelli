package com.github.borovelli.javavelli.prime;


public class EratosphenePrime {

	private static void filterkratnoe(PRIME_STATE[] eratosphene, int i, int n) {
		for (int k = 2; k < n; k++) {
			int b = i * k;
			if (b >= n) {
				break;
			}
			eratosphene[b] = PRIME_STATE.isnotprime;

		}

	}

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis();
		int j = 1;
		int n = 100000000;

		PRIME_STATE[] eratosphene = new PRIME_STATE[n];

		eratosphene[0] = PRIME_STATE.isnotprime;

		eratosphene[1] = PRIME_STATE.isnotprime;

		// ERATOSPHENE[2] = PRIME_STATE.isprime; - no need for this line

		for (int i = 0; i < n; i++) {
			PRIME_STATE flag = eratosphene[i];

			if (flag == PRIME_STATE.isnotprime) {
				continue;
			}
			if (flag == null) {
				System.out.println(i + " is prime # " + j);
				j++;
				eratosphene[i] = PRIME_STATE.isprime;
				filterkratnoe(eratosphene, i, n);
			}
		}

		long endTime = System.currentTimeMillis();
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

}
