package topCoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoxAndMp3Easy {

	public String[] playList(int n){
		String [] results = new String[((n>50)?(50):(n))];
		int i=0,j=1,k=1;
		Matcher m ;
		String ext=".mp3";
		StringBuilder sb ;
		
		while(i<n && i<50){
			if(k<=n){
				System.out.println("J: "+j+" K: "+k);
				m = Pattern.compile("^"+j+".*").matcher(""+(k));
				if(m.find()){
					System.out.println("match above");
					sb=new StringBuilder();
					sb.append(k);
					sb.append(ext);
					results[i++]=sb.toString();
				}
				k++;
			}
			else{
				k=1;
				j++;
			}
		}
		return results;
	}
}
