package cracking_Coding_Interviews;

public class UniqueString {

	/*
	 *algorithm to test if all characters in string are unique 
	 *stringUnique1 uses extra datastructure
	 *stringUnique2 does not
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean test = stringUnique2("tes");
		if(test)
		{
			System.out.println("Unique is true");
		}
		else
		{
			System.out.println("Unique is false");
		}
	}
	
	public static boolean stringUnique(String word)//method that uses a Hash map to count char frequency and return true or false
	{
		HashMap<String,Integer> freqMap = new HashMap<String,Integer>();
		for(int i=0;i<word.length();i++)
		{
			boolean contains = freqMap.contains(""+word.charAt(i));
			int freq = (!contains)?(1):(freqMap.get(""+word.charAt(i))+1);
			if(freq>1)return false;
			freqMap.put(""+word.charAt(i),freq);
		}
		return true;
	}
	
	public static boolean stringUnique2(String word)//method that uses a boolean array of the 256 (possible unique asci characters) to verify uniqueness	
	{
		if(word.length()>256)return false;
		boolean [] char_set = new boolean[256];
		for(int i=0;i<word.length();i++)
		{
			int val = word.charAt(i);
			if(char_set[val])return false;
			char_set[val]=true;
		}
		return true;
	}

}
