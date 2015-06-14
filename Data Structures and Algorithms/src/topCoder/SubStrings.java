package topCoder;

import java.util.Arrays;

public class SubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(getPrefix("papstvo")));
		System.out.println(Arrays.toString(getSuffix("papstvo")));
		getSubStrings("abc");
	}
	
	public static String [] getSuffix(String str){
		int subL = str.length()-1;
		String [] results = new String[subL];
		int j=1;
		for(int i=0;i<subL;i++){
			results[i]=str.substring(0, j++);
		}
		return results;
	}
	
	public static String[] getPrefix(String str){
		int subL = str.length()-1;
		String [] results = new String[subL];
		int j=1;
		for(int i=0;i<subL;i++){
			results[i]=str.substring(j++,str.length());
		}
		return results;
	}
	
	public static void getSubStrings(String str){
		int n=str.length();
		for(int i=0;i<n;i++){
			for(int j=i+1;j<=n;j++){
				System.out.println(str.substring(i, j));
			}
		}
	}
}
