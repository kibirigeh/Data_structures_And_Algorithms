package topCoder;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoxAndMp3Easy {

	public String[] playList(int n){
		String [] nums = new String[n];
		
		int k=1;
		StringBuilder sb ;
		String ext=".mp3";
		for(int i=0;i<nums.length;i++){
			sb=new StringBuilder();
			nums[i]=sb.append((k++)+ext).toString();
		}
		Arrays.sort(nums);
		if(n<=50)return nums;
		String [] results = new String[50];
		for(int i=0;i<50;i++){
			results[i]=nums[i];
		}
		return results;
	}
}
