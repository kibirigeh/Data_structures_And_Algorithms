package topCoder;

public class Refactoring{
	
	public int refactor(int n){
		return count(n,2);
	}
	
	private int count(int n,int lastF){
		int result =0;
		for(int i=lastF;i*i<=n;i++){
			if(n%i==0) result+=count(n/i,i)+1;
		}
		return result;
	}

}
