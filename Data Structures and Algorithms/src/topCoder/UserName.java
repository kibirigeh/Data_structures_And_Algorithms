package topCoder;

import java.util.*;

public class UserName{
	public static String newMember(String[] names,String pref){
		int x=1;
		Arrays.sort(names);
		for(int i=0;i<names.length;i++){
			if(names[i]==pref){
				pref+=(x++);
			}
		}
		return pref;
	}
	
	static void main(String[] args){
		String[] names ={"MasterOfDisaster", "TygerTyger1", "DingBat", "Orpheus", 
				 "TygerTyger", "WolfMan", "MrKnowItAll"};
		String pref ="TygerTyger";
		System.out.println(newMember(names,pref));
	}
}

