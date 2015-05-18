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
		
		System.out.println("bitsUpdated :  "+updateBits(1024,19,2,6));
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
	/*
	 * num =  10000000000, m=10011, i=2, j = 6
	 * Merge m into num from position j to i
	 * e.g result = 10001001100 
	 */
	public static int updateBits(int num,int m,int i,int j){
		int allones = ~0;//11111111
		int left = allones<<(j+1);//11100000
		int right = ((1<<i)-1);//00000011
		int mask=left|right;//11100011 //mask with bits j through i cleared 
		int num_cleared = num & mask;//10000000000 //clear bits j through i in num
		int m_Shifted = m<<i;//00001001100   left shift m i positions
		return num_cleared | m_Shifted;//10001001100
	}
	/*
	 * Method to print binary representation of a double between 1 and 0;
	 */
	public String getBinary(double num){
		if(num>=1||num<=0)return "ERROR";
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while(num>0){
			if(binary.length()>=32)return "ERROR";
			double r = num*2;
			if(r>=1){
				binary.append(1);
				num=r-1;
			}
			else
			{
				binary.append(0);
				num=r;
			}
		}
		return binary.toString();
	}
}
