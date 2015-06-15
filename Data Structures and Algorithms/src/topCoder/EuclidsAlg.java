package topCoder;

public class EuclidsAlg {

	/*
	 * Euclid's algorithm for finding GCD
	 * THe GCD is used to find LCM as well
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GCD(6,9));
		System.out.println(LCM(6,9));
	}
	
	public static int GCD(int a , int b){
		if(b==0)return a;
		return GCD(b,a%b);
	}
	
	public static int LCM(int a , int b){
		return (a*b)/GCD(a,b);
	}

}
