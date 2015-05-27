package cracking_Coding_Interviews;

import java.util.BitSet;

public class BitSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitSet set = new BitSet(10);//bitset of 10 bits
		for(int i=0;i<10;i++)	
		{
			set.set(i+1);
			System.out.println(set);
		}
	}

}
