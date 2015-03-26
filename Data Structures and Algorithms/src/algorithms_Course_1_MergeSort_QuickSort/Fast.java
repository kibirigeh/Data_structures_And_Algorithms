package algorithms_Course_1_MergeSort_QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public class Fast {
	
	private static  ArrayList<ArrayList<Point>> lines;//listy of lines found in fast algorithm
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger
	
		// read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        
        //set of N points
        Point [] set = new Point [N];
        lines = new ArrayList<ArrayList<Point>>();
        
        //read N points into set 
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            set[i] = new Point(x, y);
        }	
        
        Arrays.sort(set);
        
        //----------------------------------------------------------------------------------------------------------------------------------------------------
          
        /*
         * Algorithm starts here
         */
        for(int i=0;i<N;i++)// loop over each point and find the lines that can be made with the point as a start
        {
        	ArrayList<Point> line = new ArrayList<Point>();//a list of points that share the same slope with the origin point i
        	Point [] sorted = set;//a set of the points sorted by slope with i
        	Arrays.sort(sorted,set[i].SLOPE_ORDER);
            	
        	Double slope = set[i].slopeTo(sorted[0]);//Slope variable that must make a pattern for a point to be considered
        	
        	for(Point p : sorted)//search through all points sorted by slope order with origin
        	{
        		p.draw();//draw point
        		
        		if(set[i].compareTo(p)==0) addTo(line,p);//origin is always the first point in the sorted set
        		else if(slope==set[i].slopeTo(p)) addTo(line,p);//if the previous slope is the same slope found at point p then add to line
        		else {//otherwise
        			if(line.size()>3)//if the line found has less than 4 points don't bother with it
        			{
        				Collections.sort(line);//sort the line and check if its already been added to our list of lines found
        				if(lines.contains(line)==false)lines.add(line);
        			}
        			slope=set[i].slopeTo(p);//change the slope to try and find next pattern
        			line = new ArrayList<Point>();//change the line to a new line
        			addTo(line,set[i]);//add the origin point to the new line
        			addTo(line,p);//add the point with the slope we are now looking for
        		}
        	}
        }
        
        //for all the lines found, print/draw the lines
        for(ArrayList<Point> line : lines)
        {
        	printLine(line);
        }
        
        /*
         * algorithm ends here
         */
        //----------------------------------------------------------------------------------------------------------------------------------------------------
     
        // display to screen all at once
        StdDraw.show(0);

        // reset the pen radius
        StdDraw.setPenRadius();
        
	}
	
	/*
	 * Utility function to print out a line if it has more than 3 points
	 */
	private static void printLine(ArrayList<Point> line ){
		line.get(0).drawTo(line.get(1));
		StdOut.print(line.get(0).toString()+" -> ");
		
		for(int i=1;i<line.size();i++){
			line.get(i-1).drawTo(line.get(i));
			
			if(i!=line.size()-1){
				StdOut.print(line.get(i).toString() + " -> ");
			}
			else {
				StdOut.println(line.get(i).toString());
			}
		}
	}
	
	/*
	 * Utility function to avoid adding points that exist to a line
	 */
	private static void addTo(ArrayList<Point> line,Point p)
	{
		if(line.contains(p) == false) line.add(p);
	}
}
