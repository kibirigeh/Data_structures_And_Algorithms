package topCoder;

public class Bases {

	/*
	 * Converting bases to and from 10
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toDecimal1(111,2));
		System.out.println(toDecimal2(101,2));
		System.out.println(fromDecimal1(5,2));
		System.out.println(Integer.toBinaryString(5));
		System.out.println(Integer.toOctalString(10));
		System.out.println(Integer.toHexString(10));
		swap(9,4);
		System.out.println(add(9,2));
	}
	
	public static int toDecimal1(int n,int b){
		int result=0;
		int multiplier=1;
		while(n>0){
			result+=n%10*multiplier;
			multiplier*=b;
			n/=10;
		}
		return result;
	}
	
	public static int toDecimal2(int n,int b){
		return Integer.parseInt(""+n,b);
	}
	
	public static String fromDecimal1(int n,int b){
		String chars = "0123456789ABCDEFGHIJ";
		String result="";
		while(n>0){
			result = chars.charAt(n%b)+result;
			n/=b;
		}
		return result;
	}
	/*
	 * Swap 2 numbers in-place
	 */
	public static void swap(int a,int b){
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("a: "+a+" b: "+b);
	}
	/*
	 * Add without any arithmetic operations
	 */
	public static int add(int a,int b){
		if(b==0)return a;
		int sum=a^b;
		int carry =(a&b)<<1;
		return add(sum,carry);
	}

}
