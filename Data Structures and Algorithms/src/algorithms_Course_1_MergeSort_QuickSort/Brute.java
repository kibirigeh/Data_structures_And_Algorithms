package algorithms_Course_1_MergeSort_QuickSort;

import java.util.Arrays;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Brute {

	/*
	 * 
	 * Write a program Brute.java that examines 4 points at a time and checks whether they all lie on the same line segment, 
	 * printing out any such line segments to standard output and drawing them using standard drawing.
	 *  To check whether the 4 points p, q, r, and s are collinear, 
	 *  check whether the slopes between p and q, between p and r, and between p and s are all equal
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		// read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        
        //set of N points
        Point [] set = new Point [N];
        
        //read N points into set 
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            set[i] = new Point(x, y);
        }
        
        //not necessary
        Arrays.sort(set);//call java system merge sort on point set to make point co-relation easier
       
        /*
         * N^4 loops that will find 4 co-linear points within the set.(Brute force approach can be optimized but not wasting my time since its the overall idea to have it unoptimized)
         */
        
		for(int i=0;i<set.length;i++)
		{
			Point p = set[i];
			
			for(int j=i+1;j<set.length;j++)
			{
				Point q=set[j];
				
				for(int k = j+1;k<set.length;k++)
				{
					Point r=set[k];
					
					for(int l = k+1;l<set.length;l++)
					{
						Point s=set[l];
						if(sameLine(p,q,r,s))
						{
							StdOut.println(p.toString() + " -> " + q.toString() + " -> " + r.toString() + " -> " + s.toString());
						}
					}
				}
			}
		}
	}
	
	/*
	 * UTility function to check if 4 points are on the same slope.
	 */
	private static boolean sameLine(Point p,Point q,Point r,Point s )
	{
		if(p.slopeTo(q)==p.slopeTo(r) && p.slopeTo(r)==p.slopeTo(s)) return true;
		return false;
	}
}
