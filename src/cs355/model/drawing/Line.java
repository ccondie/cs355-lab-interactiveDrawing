package cs355.model.drawing;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import src.model.Model;
import cs355.GUIFunctions;

/**
 * Add your line code here. You can add fields, but you cannot
 * change the ones that already exist. This includes the names!
 */
public class Line extends Shape 
{
	/**
	 * Basic constructor that sets all fields.
	 * @param color the color for the new shape.
	 * @param start the starting point.
	 * @param end the ending point.
	 */
	public Line(Color color, Point2D.Double start, Point2D.Double end) {

		// Initialize the superclass.
		super(color, start);

		// Set the field.
		this.end = end;
	}
	
	///////////////////////////////////////////////////////////
	/////	User Defined Variables	///////////////////////////
	///////////////////////////////////////////////////////////
	
	
	
	
	///////////////////////////////////////////////////////////
	/////	Abstracted/Program defined Variables	///////////
	///////////////////////////////////////////////////////////
	
	// The ending point of the line.
	private Point2D.Double end;
	
	
	///////////////////////////////////////////////////////////
	/////	User Defined Methods	///////////////////////////
	///////////////////////////////////////////////////////////
	
	public Point2D.Double getHandle()
	{	
		return new Point2D.Double(0,0);	
	}

	
	///////////////////////////////////////////////////////////
	/////	Abstracted/Program defined Methods	///////////////
	///////////////////////////////////////////////////////////
	
	/**
	 * Getter for this Line's ending point.
	 * @return the ending point as a Java point.
	 */
	public Point2D.Double getEnd() {
		return end;
	}

	/**
	 * Setter for this Line's ending point.
	 * @param end the new ending point for the Line.
	 */
	public void setEnd(Point2D.Double end) 
	{
		
		this.end = worldToObj(end);
	}

	/**
	 * Add your code to do an intersection test
	 * here. You <i>will</i> need the tolerance.
	 * @param pt = the point to test against.
	 * @param tolerance = the allowable tolerance.
	 * @return true if pt is in the shape,
	 *		   false otherwise.
	 */
	@Override
	public boolean pointInShape(Point2D.Double pt, double tolerance) 
	{
		Point2D.Double objPt = worldToObj(pt);
		System.out.println("CHECKING FOR HIT ISIDE A LINE");
		
		double top = Math.abs((end.y)*objPt.x - (end.x)*objPt.y);
		double bottom = Math.sqrt(Math.pow(end.y, 2) + Math.pow(end.x,2));
		
		double distance = top/bottom;
		
		System.out.println("Distance:" + distance);
		
		if((distance) <= tolerance)
		{
			System.out.println("HIT INSIDE A Line");
			GUIFunctions.changeSelectedColor(color);
			Model.get().setColor(color);
			setActive(true);
			
			return true;
		}
		return false;
	}


	@Override
	public boolean pointInHandle(Double pt) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
