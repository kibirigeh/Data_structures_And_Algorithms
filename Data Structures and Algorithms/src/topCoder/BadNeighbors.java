package topCoder;

import java.util.Arrays;
public class BadNeighbors {
  public int maxDonations(int[] donations) {
    cache=new int[2][donations.length];
    Arrays.fill(cache[0],-1);
    Arrays.fill(cache[1],-1);
    return Math.max(max(donations,2,true)+donations[0],max(donations,1,false));
  }
  int[][] cache;
  public int max(int[] donations, int where, boolean onegave){
	print();
    if(where==donations.length) return 0;
    if(where==donations.length-1 && onegave) return 0;
    else if(where==donations.length-1) return donations[where];
    if(cache[onegave?1:0][where]!=-1) return cache[onegave?1:0][where];
    return cache[onegave?1:0][where]=Math.max(max(donations,where+1,onegave),max(donations,where+2,onegave)+donations[where]);
  }
  
  private void print(){
	  System.out.println("/n printing cache/n");
	  for(int i=0;i<cache.length;i++){
		  System.out.println("");
		  for(int j=0;j<cache[i].length;j++)
		  {
			  System.out.print(cache[i][j]+" ");
		  }
	  }
	  System.out.println("/n Done printing cache/n");
  }
}