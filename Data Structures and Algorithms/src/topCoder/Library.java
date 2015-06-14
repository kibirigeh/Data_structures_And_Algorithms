package topCoder;

import java.util.HashMap;
public class Library{
	public int documentAccess(String[] records,String[] groups, String[] rights){
		if(groups.length<1||rights.length<1)return 0;
		HashMap<String,Integer> rightsIdx,groupsIdx,docsIdx;
		rightsIdx = new HashMap<String,Integer>();
		groupsIdx = new HashMap<String,Integer>();
		docsIdx  = new HashMap<String,Integer>();	
		
		for(int i=0;i<groups.length;i++){
			groupsIdx.put(groups[i],0);
		}
		for(int i=0;i<rights.length;i++){
			rightsIdx.put(rights[i],0);
		}
		for(String S :records){
			String[] split = S.split(" ");
			if( rightsIdx.containsKey(split[1]) && groupsIdx.containsKey(split[2]) )docsIdx.put(split[0],0);
		}
		return docsIdx.size();
	}
}