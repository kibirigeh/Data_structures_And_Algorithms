package cracking_Coding_Interviews;

public class escapeSpaces {
	
	/*
	 * method to replace all spaces in a string with "%20".
	 * The strings original length is the true length of the output
	 * method escape takes O(n) with additional overhead from the string functions like substring and replaceAll
	 * method escape2 takes O(n) without any additional overhead but invoves copying the string into an char array during the replace process
	 *  
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(escape2("Mr John Smith    "));
	}
	
	/*
	 * method uses substring and replaceAll from the string class to do the heavy lifting after we identify where the spaces end
	 */
	public static String escape(String a){
		char [] contents = a.toCharArray();
		for(int i=contents.length-1;i>=0;i--){
			if(contents[i] != ' '){
				a=a.substring(0,(i+1));
				break;
			}
		}
		return a.replaceAll(" ","%20");
	}
	/*
	 * method uses a char array to do both analysis and replace at the same time.
	 */
	public static String escape2(String a){
		char [] content = new char[a.length()];
		for(int i=0,j=0;(i<a.length()&&j<a.length());i++)
		{
			char t=a.charAt(i);
			//System.out.println(t);
			if(t==' ')
			{
				content[j++]='%';
				content[j++]='2';
				content[j++]='0';
				continue;
			}
			content[j++]=t;
		}
		return new String(content);
	}
}
