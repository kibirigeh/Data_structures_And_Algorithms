package cracking_Coding_Interviews;

import java.util.HashMap;
import java.util.Map.Entry;

public class ReconstructPath {
	/*
	 * 
	 * Find the start point in a map of Trips and reconstruct the itinerary
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String>trips = new HashMap<String,String>();
		trips.put("MUC","LHR");
		trips.put("CDG","MUC");
		trips.put("SFO","SJC");
		trips.put("LHR","SFO");
		for(String point: reconstruct(trips)){
			System.out.println(point);
		}
	}
	/*
	 * This finds which origination is not a destination in the map
	 */
	public static String[] reconstruct(HashMap<String,String>trips){
		String [] paths = new String[trips.size()+1];
		String startK;
		for(Entry<String,String> trip : trips.entrySet() ){
			if(trips.containsValue(trip.getKey()))continue;
			paths[0]=trip.getKey();
			break;
		}
		
		for(int i=0;i<paths.length-1;i++){
			paths[i+1]=trips.get(paths[i]);
		}
		
		return paths;
	}

}
