package EratosphenePrime;

public class FactorialWithFor {

	public static void main(String[] args) {

		long beginTime = System.currentTimeMillis(); // timer start
		int N = 170;

		double resultat = 1;
		
		for(int i = 1; i <= N; i++ ){
			resultat = i * resultat;
		}
		System.out.println(" factorial is equal " + resultat);

		long endTime = System.currentTimeMillis(); // timer finish
		long difference = endTime - beginTime;
		System.out.println(difference + " milliseconds ");
	}

}
