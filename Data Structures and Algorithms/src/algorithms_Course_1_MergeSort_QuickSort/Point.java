package algorithms_Course_1_MergeSort_QuickSort;

import java.util.Comparator;

import edu.princeton.cs.introcs.StdDraw;

public class Point implements Comparable<Point>{
	
	/*
	 * 
	 * Create an immutable data type Point that represents a point
	 */

	// compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Slope_Order() ;       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    	if (compareTo(that) == 0) return Double.NEGATIVE_INFINITY;
		else if (this.y == that.y) return +0;
		else if (this.x == that.x) return Double.POSITIVE_INFINITY;
		else return (new Double(that.y - this.y)/ new Double(that.x - this.x));
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    	int result = compare(this.y,that.y);
    	if(result==0)
    	{
    		result = compare(this.x,that.x);//Tie breaker
    	}
    	return result;
    }
    
    private int compare(Integer i,Integer j){//private utility function to compare integers
    	return i.compareTo((Integer) j);
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    
    private class Slope_Order implements Comparator<Point>{//comparator class to use slope as an ordering
		@Override
		public int compare(Point q1, Point q2) {
            Point p = new Point(x, y);
            double d = p.slopeTo(q1) - p.slopeTo(q2);
            if (d > 0)
                return -1;
            if (d < 0)
                return 1;
            return 0;
		}
    }


}
