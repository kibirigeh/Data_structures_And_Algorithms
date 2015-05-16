package cracking_Coding_Interviews;

public class BitManipulation {
	/*
	 * Program to test Bit Manipulation facts
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int num=12;//1100
		int bit=3;//1<<3=1000
		System.out.println("Bit "+bit+" in num "+num+" is a "+getBit(num,bit));
		
		num=12;//1100
		bit=1;//1<<1=0010
		System.out.println("Num "+num+" set bit "+bit+" is "+setBit(num,bit));
		
		num=15;//1100
		bit=2;//1<<1=0010
		System.out.println("Num "+num+" clear bit "+bit+" is "+clearBit(num,bit));
		System.out.println("Num "+num+" clearMSBThrough bit "+bit+" is "+clearBit(num,bit));
	}
	
	/*
	 * And Num with (1 left shifted by (bit) positions)
	 * If result is not 0 then the bit position contains a 1 otherwise a 0.
	 */
	public static int getBit(int num,int bit){
		return ((num & (1<<bit))==0)?(0):(1);
	}
	/*
	 * OR Num with (1 left shifted by (bit) positions)
	 * The result will have that bit position set
	 */
	public static int setBit(int num,int bit){
		return (num | (1<<bit));
	}
	/*
	 * Negate the (left Shift of 1 by bit positions) 
	 * AND result of above with num 
	 */
	public static int clearBit(int num,int bit){
		return (num & ~(1<<bit));
	}
	/*
	 * AND num with (1 left shifted by (bit) positions)-1
	 */
	public static int clearBitsMSBTHroughI(int num,int bit){
		return (num & ((1<<bit)-1));
	}
	/*
	 * Update bit i with v
	 */
	public static int updateBit(int num,int i,int v){
		int mask = ~(1<<i);
		return (num & mask) | (v<<i);
	}
}
