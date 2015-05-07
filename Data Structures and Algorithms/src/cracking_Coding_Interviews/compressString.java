package cracking_Coding_Interviews;

public class compressString {
	
	/*
	 * Implement a method to perform basic string compression using the counts 
	 * of repeated characters. For example, the string aabcccccaaa would become
	 * a2blc5a3. If the "compressed" string would not become smaller than the original
	 * string, your method should return the original string
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("aabbcc"));
		System.out.println(compress("aaabbcc"));
	}
	/*
	 * method compress solves in O(n) time;
	 * Uses the buffer to append a pattern char and its freq to a new string (String concatenation will take more time).
	 * Then compares if the compression is useful or not
	 */
	public static String compress(String a)
	{
		StringBuffer buffer = new StringBuffer();//buffer to build compressed string using freq
		char[] contents = a.toCharArray();//character array for in-place analysis / I can use charAT() on the string for more space efficiency
		int freq=0;//pattern freq temp var
		
		for(int i = 0;i<contents.length;i++)
		{
			//System.out.println("Char is "+contents[i]);
			freq++;
			if((i==contents.length-1)||contents[i]!=contents[i+1])//if pattern ends here
			{
				buffer.append(contents[i]);//append pattern char
				buffer.append(freq);//append freq
				freq=0;//reset pattern freq
			}
		}
		return (a.length() > buffer.length()) ? (buffer.toString()) : (a);//return buffer if string is compressed or return string if no compression beneifit
	}

}
