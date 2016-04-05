package EratosphenePrime;

public class FibonacciReccursion {

	public static long fib(long n) {
		if (n <= 1) {
			return n;
		}
		long b = fib(n - 1) + fib(n - 2);
		return b;
	}

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start
		for (long i = 0; i < 44; i++) {
			System.out.println(i + " fibonacci is " + fib(i));
		}

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}
}
