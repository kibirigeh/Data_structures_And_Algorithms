package cracking_Coding_Interviews;

public class BitManipulation {
	/*
	 * Program to test Bit Manipulation facts
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int num=12;
		int bit=3;
		System.out.println("Bit "+bit+" in num "+num+" is a "+getBit(num,bit));
	}
	/*
	 * IAnd num with (1 left shifted by (bit) positions)
	 * If result is not 0 then the bit position contains a 1 otherwise a 0.
	 */
	public static int getBit(int num,int bit){
		return ((num&(1<<bit))==0)?(0):(1);
	}

}
