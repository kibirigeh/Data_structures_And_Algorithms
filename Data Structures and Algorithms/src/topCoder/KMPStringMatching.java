package topCoder;

import java.util.Arrays;

public class KMPStringMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pat = "ACACAGT";
		System.out.println(Arrays.toString(KMPprefix(pat.toCharArray())));
		System.out.println("char at 0 "+pat.charAt(0));
	}
	/*
	 * Generates prefix table for a pattern
	 */
	public static int [] KMPprefix(char [] pat){
		int [] pT = new int [pat.length];
		int i=0;
		int j;
		pT[i]=0;
		
		for(j=1;j < pT.length;j++){
			while(i>0 && pat[i]!=pat[j]){
				i=pT[i-1];
			}
			if(pat[i]==pat[j])i++;
			pT[j]=i;
		}
		
		return pT;
	}
	
	
}
