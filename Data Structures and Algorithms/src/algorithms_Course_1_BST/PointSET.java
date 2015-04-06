package algorithms_Course_1_BST;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;

public class PointSET {
	
	private TreeSet<Point2D> rbBST ;//Red Black Binary Search tree
	
	public PointSET()// construct an empty set of points 
	{
		 rbBST = new TreeSet<Point2D>();
	}
	
	public boolean isEmpty() // is the set empty? 
	{
		return rbBST.isEmpty();
	}
	
	public int size()// number of points in the set
	{
		return rbBST.size();
	}
	
	public void insert(Point2D p)// add the point to the set (if it is not already in the set)
	{
		isNull(p);//check for null exception
		rbBST.add(p);
	}
	
	public boolean contains(Point2D p)// does the set contain point p? 
	{
		isNull(p);//check for null exception
		return rbBST.contains(p);
	}
	
	public void draw()// draw all points to standard draw 
	{
		for(Point2D p: rbBST)//iterate over points and draw them to stdDraw
		{
			p.draw();
		}
	}
	
	public Iterable<Point2D> range(RectHV rect)// all points that are inside the rectangle
	{
		isNull(rect);//check for null exception
		List<Point2D> list = new ArrayList<Point2D>();
		for(Point2D p:rbBST)
		{
			if(rect.distanceTo(p)==0D) list.add(p);
		}
		return list;
	}
	
	public Point2D nearest(Point2D p)// a nearest neighbor in the set to point p; null if the set is empty
	{
		isNull(p);//check for null exception;
		if(rbBST.isEmpty()||rbBST==null)return null;
		Point2D near = null;
		double dst = p.distanceTo(rbBST.first());
		
		for(Point2D i:rbBST)
		{
			if(p.equals(i)) continue;
			double tmp = p.distanceTo(i);
			if(tmp<dst)
			{
				near=i;
				dst=tmp;
			}
		}
	
		return near;
	}
	
	private void isNull(Object p)//utility method to check if any arguement is null
	{
		if(p==null) throw new java.lang.NullPointerException();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
