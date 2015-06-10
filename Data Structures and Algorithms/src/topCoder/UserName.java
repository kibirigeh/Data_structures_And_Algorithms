package topCoder;

import java.util.Arrays;

public class UserName{
	public static String newMember(String[] names,String pref){
		int x=1;
		String result=pref;
		Arrays.sort(names);
		boolean found = false;
		for(int i=0;i<names.length;i++){
			if(names[i].equalsIgnoreCase(result)){
				result=pref+(x++);
				found=true;
			}
			else if(found){
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		String[] names ={"MasterOfDisaster", "TygerTyger1", "DingBat", "Orpheus", 
				 "TygerTyger", "WolfMan","WolfMan2", "MrKnowItAll"};
		String pref ="TygerTyger";
		System.out.println(newMember(names,pref));
	}
}

