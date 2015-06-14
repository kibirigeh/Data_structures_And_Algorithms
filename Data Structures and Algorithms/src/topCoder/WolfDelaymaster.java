package topCoder;

public class WolfDelaymaster{
	public String check(String str){
	int S = str.length();
	int i =0;
	while(i<S){
		if(str.charAt(i)!='w')return "INVALID";
		int n =0;
		while(i<S && str.charAt(i)=='w'){
			n++;
			i++;
		}
		char [] seq = {'o','l','f'};
		for(char ch:seq){
			for(int p=0;p<n;p++){
				if(i>=S  || str.charAt(i)!=ch) return "INVALID";
				i++;
			}
		}
	} 
	return "VALID";
	}
}