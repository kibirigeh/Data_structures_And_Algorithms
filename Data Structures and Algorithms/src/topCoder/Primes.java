package topCoder;

import java.util.Arrays;

public class Primes {

	/*
	 * Algorithm that uses the sieve of eratosthenes to find primes easily
	 */
	static boolean [] primes = primeSieve(1000);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPrime(23);
		isPrime(4);
	}
	
	public static void isPrime(int n){
		
		if(primes[n]){
			System.out.println(n+" is a prime");
		}
		else{
			System.out.println(n+" is not a prime");
		}
	}
	
	public static boolean[] primeSieve(int n){
		boolean [] primes = new boolean[n+1];
		Arrays.fill(primes, true);
		primes[0]=false;
		primes[1]=false;
		int m = (int) Math.sqrt(n);
		
		for(int i=2;i<=m;i++){//find next prime
			if(primes[i]){
				for(int j=i*i;j<=n;j+=i){//remove multiples of found prime
					if(primes[j]){
						primes[j]=false;
					}
				}
			}
		}
		return primes;
	}

}
