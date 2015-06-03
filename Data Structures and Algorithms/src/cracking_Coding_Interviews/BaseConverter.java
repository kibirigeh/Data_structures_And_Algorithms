package cracking_Coding_Interviews;

public class BaseConverter {

	/*
	 * Test Program to convert bases 
	 */
	
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(DecToBaseN(15,11200));
	}
	
	/*
	 * function to convert any base 10 number N  to a base between 2 and 9 
	 * 
	 */
	public static String DecToBaseN(int N,int X){
		int r = X%N;//The divider of X / base N
		int d = X/N;//The remainder of X % base N
		//System.out.println("N: "+N+" X: "+X+" D: "+d+" R: "+r);
		if(N<=10 && r<N && d < N){//if the base we want is less than or equal to base 10 and the division can't continue
			return ""+d+r;
		}
		else if(N>10 && r<N && d<N){//if the base we want is greater than base 10 and the division can't continue
			String a = (d>=10 && d<N)?(Integer.toHexString(d)):(""+d);//convert the divider to a HEX String {10:A, 11:B, 12:C, 13:D, 14:E, 15:F}
			String b = (r>=10 && r<N)?(Integer.toHexString(r)):(""+r);//convert the remainder to a HEX String
			return ""+a+b;//return the representation of divider and remainder
		}
		else return DecToBaseN(N,d)+Integer.toHexString(r);//if the division can still continue, keep going and append the remainder HEX representation to remainder 
	}
}
