package topCoder;

import java.util.*;

public class RugSizes{
	public int rugCount(int area){
		int result=1;
		boolean []flags = new boolean[(area/2)+1];
		Arrays.fill(flags,false);
		 
		for(int i=2;i<=(area/2);i++){
			if((!flags[i]) && area%i==0){
				int a=area/i;
				flags[a]=true;
				flags[i]=true;
				if(a!=i && a%2==0 && i%2==0)continue;
				result++;
			}
		}
		return result;
	}
} 
