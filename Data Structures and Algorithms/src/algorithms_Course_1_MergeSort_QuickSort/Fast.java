package algorithms_Course_1_MergeSort_QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public class Fast {
	
	private static Map<String,ArrayList<Point>> lines;//Map of lines found using fast algorithm
	
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
        Point [] sorted = new Point[N];
        
        lines = new HashMap<String,ArrayList<Point>>();
        
        //read N points into set 
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            set[i] = new Point(x, y);
            set[i].draw();
            sorted[i]=new Point(x,y);
        }	
        
        Arrays.sort(set);
        
        //----------------------------------------------------------------------------------------------------------------------------------------------------
          
        /*
         * Algorithm starts here
         */
        for(int i=0;i<N;i++)// loop over each point and find the lines that can be made with the point as a start
        {
        	ArrayList<Point> line = new ArrayList<Point>();//a list of points that share the same slope with the origin point i
        	//sorted set of the points sorted by slope with i
        	Arrays.sort(sorted,set[i].SLOPE_ORDER);
        	
        	Double prevSlope = sorted[i].slopeTo(sorted[1]);//first slope to be used in pattern recognition
        	
        	for(int j=1;j<N;j++)//loop through all the patterns based on slope similarity
        	{
        		Double currSlope=sorted[0].slopeTo(sorted[j]);//the current slope between original point and sorted point j
    
        		if(currSlope.compareTo(prevSlope)==0)	addTo(line,sorted[j]);//if the slope pattern matches add the point
        		else{//if the slope pattern did not match
        			if(line.size()>2) // commit the line if the points are 4 or more  
        			{
        				addTo(line,sorted[0]);
        				Collections.sort(line);//sort the points in the line to achieve a desired order
        				lines.put(line.toString(),line);//put the line in the map making sure its distinct
        			}
        			line=new ArrayList<Point>();//create a new line for the rest of the points
        			prevSlope=currSlope;
        			addTo(line,sorted[j]);
        		}
        	}
        	/*
    		 * add the last line found if any
    		 * This is usually a vertical line
    		 */
        	if(line.size()>2)
    		{
    			addTo(line,sorted[0]);
    			Collections.sort(line);
    			lines.put(line.toString(),line);
    		}
        }
        
        //for all the lines found, print/draw the lines
        for(ArrayList<Point> line : lines.values())
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
