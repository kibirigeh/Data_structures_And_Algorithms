package topCoder;

import java.util.Arrays;

public class GUMIAndSongsDiv2 {
	
	class Song implements Comparable<Song>{
		int d;
		int t;
		Song(int d,int t){
			this.d=d;
			this.t=t;
		}
		
		public int compareTo(Song that){//sort by tone
			if(this.t<that.t)return -1;
			if(this.t>that.t)return 1;
			else return 0;
		}
	}
	
	public int maxSongs(int []D,int []TO,int T){
		Song [] songs = genSongs(D,TO);//wrap song data
		int maxS = 0;
		
		int options = (1<<songs.length);//number of possible song queues
		
		Arrays.sort(songs);//sort songs by tone
		
		for(int option = options; (option>0); option--){//for each queue
			int tempMax=0;
			int Tused=0;
			int prev = 0;
			int rest = 0;
			for(int i=0;i<songs.length;i++){
				if(((1 << i) & option) > 0){//Get running time for each song in queue
					rest = (tempMax==0)?0:(songs[i].t-prev);
					Tused=Tused+songs[i].d+Math.abs(rest);
					prev=songs[i].t;
					tempMax++;
				}
			}
			if(Tused<=T){//if running time is less than T and the size of que is more than the previous queue then update max
				maxS=Math.max(maxS, tempMax);
			}
		}
		return maxS;
	}
	
	
	public Song [] genSongs(int []D,int []TO){
		Song[] songs = new Song[D.length];
		
		for(int i=0;i<songs.length;i++){
			songs[i]= new Song(D[i],TO[i]);
		}
		
		return songs;
	}
}
